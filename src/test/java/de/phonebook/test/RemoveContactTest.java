package de.phonebook.test;

import de.phonebook.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {


    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("irinafengshui71@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new de.phonebook.model.Contact().setName("Oliver")
                .setLastname("Kan").setPhone("123456782390")
                .setEmail("kan@gmail.com").setAddress("TelAviv")
                .setDesk("QA"));
        app.getContact().clickOnSaveButton();

    }
    @Test
    public void removeContactTest(){
       int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().click(By.cssSelector(".contact-item_card__2SOIM"));
        app.getContact().click(By.xpath("//button[.='Remove']"));
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }


}
//before - login, add contact
//click on card
//click on remove button
//assert  by size