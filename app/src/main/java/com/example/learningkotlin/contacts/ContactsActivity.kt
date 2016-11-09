package com.example.learningkotlin.contacts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.learningkotlin.R
import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class ContactsActivity : AppCompatActivity(), ContactsContract.View {

    var mPresenter: ContactsContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        mPresenter = ContactsPresenter(this)

        val contact1 = Contact("Ruan Rabelo", 34, "http://pngimg.com/upload/face_PNG5660.png", Contact.Sex.MALE)
        val contact2 = Contact("Julia Cigana", 29, "http://pngimg.com/upload/face_PNG5646.png",
                Contact.Sex.FEMALE)
        val contact3 = Contact("Rafaela Maria", 39, "http://www.taylorherring" +
                ".com/blog/wp-content/uploads/2015/03/Archetypal-Female-Face-of-Beauty-embargoed-to-00.01hrs-30.03.15.jpg", Contact.Sex.FEMALE)
        val contacts: MutableList<Contact> = mutableListOf(contact1, contact2, contact3)
        val adapter = ContactsAdapter(contacts)

        contactsList.layoutManager = LinearLayoutManager(this)
        contactsList.setHasFixedSize(true)
        contactsList.adapter = adapter

        floatingActionButton.onClick { toast("Soon") }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
    }

    override fun setPresenter(presenter: ContactsContract.Presenter) {
        mPresenter = presenter
    }
}
