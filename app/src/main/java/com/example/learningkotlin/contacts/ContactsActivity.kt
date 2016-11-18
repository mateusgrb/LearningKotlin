package com.example.learningkotlin.contacts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.SparseBooleanArray
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import com.example.learningkotlin.R
import com.example.learningkotlin.addeditcontact.AddEditContactActivity
import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity


class ContactsActivity : AppCompatActivity(), ContactsContract.View {

    private val presenter: ContactsContract.Presenter = ContactsPresenter(this)
    private var actionMode: ActionMode? = null
    private val contacts = presenter.getContacts() as MutableList<Contact>

    private var adapter = ContactsAdapter(contacts, {
        actionMode ?: startActivity<AddEditContactActivity>(AddEditContactActivity.EXTRA_CONTACT to
                it)
    }, { contact -> handleOnLongClick(contact) })

    private val callback = object : ActionMode.Callback {
        override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.action_delete -> {
                    val selected: SparseBooleanArray = adapter.selected
                    val contactsToBeDeleted = adapter.contacts
                            .filterIndexed { index, contact -> selected[index] }
                    presenter.deleteContacts(contactsToBeDeleted)
                    mode?.finish()
                    return true
                }
                else -> return false
            }
        }

        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.context_menu, menu)
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
            adapter.actionModeEnabled = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        contactsList.layoutManager = LinearLayoutManager(this)
        contactsList.setHasFixedSize(true)
        contactsList.adapter = adapter

        floatingActionButton.onClick { presenter.addNewContact() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showAddContactScreen() {
        startActivity<AddEditContactActivity>()
    }

    override fun refreshList(updatedContacts: List<Contact>) {
        contacts.clear()
        contacts.addAll(updatedContacts)
        adapter.notifyDataSetChanged()
    }

    private fun handleOnLongClick(contact: Contact) {
        if (actionMode != null) {
            return
        }
        actionMode = startActionMode(callback)
    }
}
