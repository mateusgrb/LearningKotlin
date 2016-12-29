package com.example.learningkotlin.addeditcontact;

import android.net.Uri;

import com.example.learningkotlin.business.EventHandler;
import com.example.learningkotlin.data.models.Contact;
import com.example.learningkotlin.data.source.ContactsDataSource;
import com.example.learningkotlin.utils.Validator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mateus on 23/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddEditContactPresenterTest {

    @Mock
    private AddEditContactContract.View view;

    @Mock
    private ContactsDataSource repository;

    @Mock
    private Validator validator;

    @Mock
    private EventHandler eventHandler;

    @Mock
    private Uri uri;

    @InjectMocks
    private AddEditContactPresenter presenter;

    private Contact contact;

    @Before
    public void setUp() throws Exception {
        contact = Contact.Companion.newInstance();

        when(validator.validateContactName(anyString())).thenReturn(true);
        when(validator.validateContactEmail(anyString())).thenReturn(true);
        when(validator.validateContactPhone(anyString())).thenReturn(true);
    }

    @Test
    public void testSaveContactWithNewImage() {
        presenter.onImageSelected();
        presenter.saveContact(contact, uri);
        verify(repository).uploadImage(same(uri), any(ContactsDataSource
                .UploadResultListener.class));
    }

    @Test
    public void testInsertNewContact() {
        presenter.saveContact(contact, null);
        verify(repository).insertContact(contact);
    }

    @Test
    public void testUpdateContact() {
        contact.setId(1);
        presenter.saveContact(contact, null);
        verify(repository).updateContact(contact);
    }

    @Test
    public void testOnDestroy() {
        Assert.assertNotNull(presenter.getView());
        presenter.onDestroy();
        Assert.assertNull(presenter.getView());
    }
}