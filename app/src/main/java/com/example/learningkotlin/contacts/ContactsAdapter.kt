package com.example.learningkotlin.contacts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learningkotlin.R

import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.contacts_list_item.view.*
import org.jetbrains.anko.onClick

/**
 * Created by mateus on 04/11/16.
 */

class ContactsAdapter(val contacts: List<Contact>, val itemClick: (Contact) -> Unit) : RecyclerView
.Adapter<ContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contacts_list_item,
                parent, false)
        return ContactViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ContactViewHolder(itemView: View, val itemClick: (Contact) -> Unit) : RecyclerView
    .ViewHolder(itemView) {
        fun bind(contact: Contact) {
            with(contact) {
                itemView.nameTextView.text = name
                itemView.sexTextView.text = sex
                itemView.ageTextView.text = age.toString()
                itemView.onClick { itemClick(this) }
            }
        }
    }
}
