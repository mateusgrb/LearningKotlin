package com.example.learningkotlin;

import android.support.test.runner.AndroidJUnit4;

import com.example.learningkotlin.utils.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mateus on 27/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class ValidatorInstrumentedTest {

    @Test
    public void validateContactName_EmptyName() {
        Assert.assertThat(Validator.Companion.validateContactName(""), is(false));
    }

    @Test
    public void validateContactName_ValidName() {
        Assert.assertThat(Validator.Companion.validateContactName("John Lennon"), is(true));
    }

    @Test
    public void validateContactEmail_EmptyEmail() {
        Assert.assertThat(Validator.Companion.validateContactEmail(""), is(false));
    }

    @Test
    public void validateContactEmail_InvalidEmail() {
        Assert.assertThat(Validator.Companion.validateContactEmail("lalala@"), is(false));
    }

    @Test
    public void validateContactEmail_InvalidEmail2() {
        Assert.assertThat(Validator.Companion.validateContactEmail("99887766"), is(false));
    }

    @Test
    public void validateContactEmail_ValidEmail() {
        Assert.assertThat(Validator.Companion.validateContactEmail("example@email.com"), is(true));
    }

    @Test
    public void validateContactPhoneNumber_EmptyPhoneNumber() {
        Assert.assertThat(Validator.Companion.validateContactPhone(""), is(false));
    }

    @Test
    public void validateContactPhoneNumber_InvalidPhoneNumber() {
        Assert.assertThat(Validator.Companion.validateContactPhone("9988a7766"), is(false));
    }

    @Test
    public void validateContactPhoneNumber_ValidPhoneNumber() {
        Assert.assertThat(Validator.Companion.validateContactPhone("99887766"), is(true));
    }
}
