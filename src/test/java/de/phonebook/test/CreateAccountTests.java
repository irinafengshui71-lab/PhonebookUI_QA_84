package de.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {

        clickOnLoginLink();
        fillLoginRegisterForm(newEmail(), "Aa12345!");
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }


    @Test
    public void existedUserRegisterNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(newEmail(), "Aa12345!");
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());


    }

}


//click on Login link

//enters email
//enters password
//click on Registration button
//assert SignOut button