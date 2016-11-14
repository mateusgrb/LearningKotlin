package com.example.learningkotlin.contacts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.learningkotlin.R
import com.example.learningkotlin.addeditcontact.AddEditContactActivity
import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity

class ContactsActivity : AppCompatActivity(), ContactsContract.View {

    private val presenter: ContactsContract.Presenter = ContactsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val adapter = ContactsAdapter(presenter.getContacts()) {
            startActivity<AddEditContactActivity>(AddEditContactActivity.EXTRA_CONTACT to it)
        }

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
}
