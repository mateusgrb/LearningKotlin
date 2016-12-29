package com.example.learningkotlin.contacts;

import com.example.learningkotlin.business.EventHandler;
import com.example.learningkotlin.data.models.Contact;
import com.example.learningkotlin.data.source.ContactsDataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by mateus on 29/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactsPresenterTest {

    @Mock
    private ContactsContract.View view;

    @Mock
    private ContactsDataSource repository;

    @Mock
    private EventHandler eventHandler;

    @InjectMocks
    private ContactsPresenter presenter;

    @Test
    public void testAddNewContact() {
        presenter.addNewContact();
        verify(view).showAddContactScreen();
    }

    @Test
    public void testGetContacts() {
        presenter.getContacts();
        verify(repository).getContacts();
    }

    @Test
    public void testDeleteContacts() {
        List<Contact> list = new ArrayList<>();
        presenter.deleteContacts(list);
        verify(repository).deleteContacts(list);
        verify(view).refreshList(ArgumentMatchers.<Contact>anyList());
    }

    @Test
    public void testOnDestroy() {
        Assert.assertNotNull(presenter.getView());
        presenter.onDestroy();
        Assert.assertNull(presenter.getView());
    }
}
