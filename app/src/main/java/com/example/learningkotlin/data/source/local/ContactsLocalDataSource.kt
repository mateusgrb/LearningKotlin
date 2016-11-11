package com.example.learningkotlin.data.source.local

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsDataSource

/**
 * Created by mateus on 10/11/16.
 */
class ContactsLocalDataSource : ContactsDataSource {

    override fun insertContact() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContacts(): List<Contact> {
        val contact1 = Contact("Ruan Rabelo", 134, "http://pngimg.com/upload/face_PNG5660.png",
                Contact.Sex.MALE)
        val contact2 = Contact("Julia Cigana", 29, "http://pngimg.com/upload/face_PNG5646.png",
                Contact.Sex.FEMALE)
        val contact3 = Contact("Rafaela Maria", 39, "http://www.taylorherring" +
                ".com/blog/wp-content/uploads/2015/03/Archetypal-Female-Face-of-Beauty-embargoed-to-00.01hrs-30.03.15.jpg", Contact.Sex.FEMALE)
        return listOf(contact1, contact2, contact3)
    }
}