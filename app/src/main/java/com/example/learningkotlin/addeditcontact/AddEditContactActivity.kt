package com.example.learningkotlin.addeditcontact

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.learningkotlin.R
import kotlinx.android.synthetic.main.activity_add_edit_contact.*
import org.jetbrains.anko.onClick

class AddEditContactActivity : AppCompatActivity(), AddEditContactContract.View {

    val mPresenter = AddEditContactPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_contact)

        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout
                .simple_spinner_item, mPresenter.getSexValues())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sexSpinner.adapter = adapter
        saveButton.onClick { }
    }
}
