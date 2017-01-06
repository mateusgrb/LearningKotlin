package com.example.learningkotlin.addeditcontact

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.example.learningkotlin.AppModule
import com.example.learningkotlin.R
import com.example.learningkotlin.data.models.Contact
import kotlinx.android.synthetic.main.activity_add_edit_contact.*
import org.jetbrains.anko.onClick
import javax.inject.Inject


class AddEditContactActivity : AppCompatActivity(), AddEditContactContract.View {

    companion object {
        val EXTRA_CONTACT = "CONTACT"
        val REQUEST_CODE_SELECT_IMAGE = 101
    }

    @Inject lateinit var presenter: AddEditContactContract.Presenter
    private var imageUri: Uri? = null
    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_contact)

        DaggerAddEditContactComponent.builder().appModule(AppModule(this))
                .addEditContactPresenterModule(AddEditContactPresenterModule(this)).build().inject(this)

        selectImageButton.onClick {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE_SELECT_IMAGE)
        }

        saveButton.onClick {
            if (contact == null) {
                contact = Contact.newInstance()
            }
            contact?.name = nameEditText.text.toString()
            contact?.email = emailEditText.text.toString()
            contact?.phone = phoneEditText.text.toString()
            presenter.saveContact(contact!!, imageUri)
        }

        contact = intent.getSerializableExtra(EXTRA_CONTACT) as Contact?
        if (contact != null) {
            nameEditText.setText(contact?.name)
            emailEditText.setText(contact?.email)
            phoneEditText.setText(contact?.phone)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            imagePathTextView.text = imageUri?.path
            presenter.onImageSelected()
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
