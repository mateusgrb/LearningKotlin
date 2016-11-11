package com.example.learningkotlin.data.source.local

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.models.ContactRealm
import com.example.learningkotlin.data.source.ContactsDataSource
import io.realm.Realm

/**
 * Created by mateus on 10/11/16.
 */
class ContactsLocalDataSource : ContactsDataSource {

    override fun insertContact(name: String, age: Int, sex: String) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val contact = realm.createObject(ContactRealm::class.java)
            contact.name = name
            contact.age = age
            contact.sex = sex
        }
        realm.close()
    }

    override fun getContacts(): List<Contact> {
        val realm = Realm.getDefaultInstance()
        val results = realm.where(ContactRealm::class.java).findAll()
        val detachedResults = realm.copyFromRealm(results)
        realm.close()
        return detachedResults
    }
}