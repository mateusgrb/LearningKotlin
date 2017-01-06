package com.example.learningkotlin.data.source.remote

import android.content.Context
import android.net.Uri
import com.example.learningkotlin.R
import com.example.learningkotlin.data.source.ContactsDataSource
import com.google.firebase.storage.FirebaseStorage
import java.util.*

/**
 * Created by mateus on 16/12/16.
 */

class ContactsFirebaseDataSource(val context: Context) {

    companion object {
        private val IMAGES_DIR = "images"
        private val IMAGE_EXTENSION = ".jpg"
    }

    fun uploadImage(imageUri: Uri, listener: ContactsDataSource.UploadResultListener) {
        val storage = FirebaseStorage.getInstance()
        val root = storage.getReferenceFromUrl(context.getString(R.string.firebase_url) ?: "")
        val fileName = UUID.randomUUID().toString() + IMAGE_EXTENSION
        val fileReference = root.child(IMAGES_DIR).child(fileName)
        val uploadTask = fileReference.putFile(imageUri)
        uploadTask.addOnSuccessListener { taskSnapshot ->
            listener.onSuccess(taskSnapshot.downloadUrl)
        }.addOnFailureListener { exception ->
            listener.onError(exception)
        }
    }
}