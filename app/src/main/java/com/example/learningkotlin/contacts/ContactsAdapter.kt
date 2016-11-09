package com.example.learningkotlin.contacts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learningkotlin.R

import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.contacts_list_item.view.*

/**
 * Created by mateus on 04/11/16.
 */

class ContactsAdapter(private val contacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contacts_list_item,
                parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contact) {
            with(contact) {
                itemView.nameTextView.text = name
                itemView.sexTextView.text = sex.toString()
                itemView.ageTextView.text = age.toString()
            }
        }
    }
}
