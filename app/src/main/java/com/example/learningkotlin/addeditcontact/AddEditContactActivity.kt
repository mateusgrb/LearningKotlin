package com.example.learningkotlin.addeditcontact

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.example.learningkotlin.R
import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.activity_add_edit_contact.*
import org.jetbrains.anko.onClick

class AddEditContactActivity : AppCompatActivity(), AddEditContactContract.View {

    companion object {
        val EXTRA_CONTACT = "CONTACT"
    }

    private val presenter = AddEditContactPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_contact)

        saveButton.onClick {
            presenter.saveContact(nameEditText.text.toString(), emailEditText.text
                    .toString(), phoneEditText.text.toString())
        }

        val contact = intent.getSerializableExtra(EXTRA_CONTACT) as Contact?
        if (contact != null) {
            with(contact) {
                presenter.contactId = id
                nameEditText.setText(name)
                emailEditText.setText(email)
                phoneEditText.setText(phone)
            }
        }
    }

    override fun onContactSaved() {
        finish()
    }

    override fun showContactNameError() {
        showError(nameEditText, R.string.name)
    }

    override fun showContactEmailError() {
        showError(emailEditText, R.string.email)
    }

    override fun showContactPhoneError() {
        showError(phoneEditText, R.string.phone)
    }

    private fun showError(editText: EditText, stringId: Int) {
        with(editText) {
            error = getString(R.string.field_error, getString(stringId).toLowerCase())
            requestFocus()
        }
    }
}
