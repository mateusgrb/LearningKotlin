package com.example.learningkotlin.data.source.local

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.models.ContactRealm
import io.realm.Realm

/**
 * Created by mateus on 10/11/16.
 */
class ContactsLocalDataSource {

    fun insertContact(contact: Contact) {
        val realm = Realm.getDefaultInstance()
        val max: Number? = realm.where(ContactRealm::class.java).max(ContactRealm.ID)
        val primaryKey = max?.toLong()?.plus(1) ?: 1
        contact.id = primaryKey
        realm.executeTransaction {
            realm.insert(contact as ContactRealm)
        }
        realm.close()
    }

    fun updateContact(contact: Contact) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm.insertOrUpdate(contact as ContactRealm) }
        realm.close()
    }

    fun getContacts(): List<Contact> {
        val realm = Realm.getDefaultInstance()
        val results = realm.where(ContactRealm::class.java).findAll()
        val detachedResults = realm.copyFromRealm(results)
        realm.close()
        return detachedResults
    }

    fun deleteContacts(contacts: List<Contact>) {
        val ids = contacts.map { it.id }
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.where(ContactRealm::class.java).`in`(ContactRealm.ID, ids.toTypedArray())
                    .findAll().deleteAllFromRealm()
        }
        realm.close()
    }

    private fun setContactFields(contact: ContactRealm?, name: String, email: String, phone: String) {
        contact?.name = name
        contact?.email = email
        contact?.phone = phone
    }
}
