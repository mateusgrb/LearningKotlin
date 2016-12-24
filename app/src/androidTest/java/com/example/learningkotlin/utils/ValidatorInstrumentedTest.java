package com.example.learningkotlin.utils;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mateus on 27/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class ValidatorInstrumentedTest {

    private Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = new Validator();
    }

    @Test
    public void validateContactNameEmptyName() {
        Assert.assertThat(validator.validateContactName(""), is(false));
    }

    @Test
    public void validateContactName_ValidName() {
        Assert.assertThat(validator.validateContactName("John Lennon"), is(true));
    }

    @Test
    public void validateContactEmail_EmptyEmail() {
        Assert.assertThat(validator.validateContactEmail(""), is(false));
    }

    @Test
    public void validateContactEmail_InvalidEmail() {
        Assert.assertThat(validator.validateContactEmail("lalala@"), is(false));
    }

    @Test
    public void validateContactEmail_InvalidEmail2() {
        Assert.assertThat(validator.validateContactEmail("99887766"), is(false));
    }

    @Test
    public void validateContactEmail_ValidEmail() {
        Assert.assertThat(validator.validateContactEmail("example@email.com"), is(true));
    }

    @Test
    public void validateContactPhoneNumber_EmptyPhoneNumber() {
        Assert.assertThat(validator.validateContactPhone(""), is(false));
    }

    @Test
    public void validateContactPhoneNumber_InvalidPhoneNumber() {
        Assert.assertThat(validator.validateContactPhone("9988a7766"), is(false));
    }

    @Test
    public void validateContactPhoneNumber_ValidPhoneNumber() {
        Assert.assertThat(validator.validateContactPhone("99887766"), is(true));
    }
}
