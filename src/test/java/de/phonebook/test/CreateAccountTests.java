package de.phonebook.test;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User()
                .setEmail("irinafengshui71@gmail.com")
                .setPassword("Aa12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }


    @Test
    public void existedUserRegisterNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("irinafengshui71@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());


    }

}


//click on Login link

//enters email
//enters password
//click on Registration button
//assert SignOut button