package de.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {


    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillLoginRegisterForm("irinafengshui71@gmail.com", "Aa12345!");
        clickLoginButton();

        clickOnAddLink();
        fillAddContactForm("Oliver", "Kan", "123456782390", "kan@gmail.com", "TelAviv", "QA");
        clickOnSaveButton();

    }
    @Test
    public void removeContactTest(){
       int sizeBefore = sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }


}
//before - login, add contact
//click on card
//click on remove button
//assert  by size