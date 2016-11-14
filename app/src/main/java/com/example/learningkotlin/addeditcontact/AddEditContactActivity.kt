package com.example.learningkotlin.addeditcontact

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.example.learningkotlin.R
import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.activity_add_edit_contact.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.onEditorAction
import org.jetbrains.anko.toast

class AddEditContactActivity : AppCompatActivity(), AddEditContactContract.View {

    companion object {
        val EXTRA_CONTACT = "CONTACT"
    }

    private val presenter = AddEditContactPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_contact)

        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout
                .simple_spinner_item, presenter.getSexValues())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sexSpinner.adapter = adapter
        sexSpinner.isFocusable = true
        sexSpinner.isFocusableInTouchMode = true

        ageEditText.onEditorAction { textView, i, keyEvent -> checkNextFocus(i) }
        saveButton.onClick {
            presenter.saveContact(nameEditText.text.toString(), ageEditText.text
                    .toString(), sexSpinner.selectedItem.toString())
        }

        val contact = intent.getSerializableExtra(EXTRA_CONTACT) as Contact?
        if (contact != null) {
            presenter.contactId = contact.id
            nameEditText.setText(contact.name)
            ageEditText.setText(contact.age.toString())
            sexSpinner.setSelection(adapter.getPosition(contact.sex))
        }
    }

    override fun showContactNameError() {
        with(nameEditText) {
            error = getString(R.string.name_error)
            requestFocus()
        }
    }

    override fun showContactAgeError() {
        with(ageEditText) {
            error = getString(R.string.age_error)
            requestFocus()
        }
    }

    override fun showContactSexError() {
        toast(getString(R.string.sex_error))
    }

    override fun onContactSaved() {
        finish()
    }

    private fun checkNextFocus(actionId: Int): Boolean {
        if (actionId == EditorInfo.IME_ACTION_NEXT) {
            hideKeyboard()
            sexSpinner.requestFocus()
            return true
        }
        return false
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
