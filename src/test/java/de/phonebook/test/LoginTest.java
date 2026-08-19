package de.phonebook.test;

import de.phonebook.core.TestBase;
import de.phonebook.data.UserData;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test
    public void loginRegisteredUserPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL).setPassword(UserData.PASSWORT));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());


    } @Test
    public void loginRegisteredUserWithoutEmailNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User()
                .setEmail("").setPassword(UserData.PASSWORT));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());


    }


}
//fillLogiRegisterForm( new User().setPassword("Aa12345!"));