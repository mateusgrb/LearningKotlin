package com.example.learningkotlin.contacts

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learningkotlin.R
import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.contacts_list_item.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.onClick
import org.jetbrains.anko.onLongClick

/**
 * Created by mateus on 04/11/16.
 */

class ContactsAdapter(val contacts: List<Contact>, val itemClick: (Contact) -> Unit, val itemLongClick: (Contact) -> Unit)
    : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    var actionModeEnabled = false
        set(value) {
            field = value
            if (!field) {
                selected = SparseBooleanArray()
                notifyDataSetChanged()
            }
        }
    var selected: SparseBooleanArray = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contacts_list_item,
                parent, false)
        return ContactViewHolder(view, { contact, position ->
            if (actionModeEnabled) {
                //toggle selection
                selected.put(position, !selected.get(position))
                notifyItemChanged(position)
            }
            itemClick(contact)
        }, { contact, position ->
            if (!actionModeEnabled) {
                actionModeEnabled = true
                selected.put(position, true)
                notifyItemChanged(position)
            }
            itemLongClick(contact)
        })
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position], selected.get(position))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ContactViewHolder(itemView: View, val itemClick: (Contact, Int) -> Unit, val itemLongClick
    : (Contact, Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contact, selected: Boolean) {
            with(contact) {
                itemView.nameTextView.text = name
                itemView.sexTextView.text = sex
                itemView.ageTextView.text = age.toString()
                itemView.onClick { itemClick(this, adapterPosition) }
                itemView.onLongClick { itemLongClick(this, adapterPosition); true }
                itemView.backgroundColor = if (selected) ContextCompat.getColor(itemView.context,
                        R.color.colorSelected) else Color.TRANSPARENT
            }
        }
    }
}
