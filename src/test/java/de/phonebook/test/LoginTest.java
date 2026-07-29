package de.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginRegisteredUserPositiveTest(){
        clickOnLoginLink();
        fillLoginRegisterForm("irinafengshui71@gmail.com", "Aa12345!");
        clickLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());


    }


}
