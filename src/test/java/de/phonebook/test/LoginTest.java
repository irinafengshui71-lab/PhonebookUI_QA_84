package de.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginRegisteredUserPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("irinafengshui71@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());


    } @Test
    public void loginRegisteredUserWithoutEmailNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("irinafengshui71@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());


    }


}
//fillLogiRegisterForm( new User().setPassword("Aa12345!"));