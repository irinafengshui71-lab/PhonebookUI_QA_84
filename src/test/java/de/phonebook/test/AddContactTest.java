package de.phonebook.test;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.utils.MyDataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {


   @BeforeMethod
   public void precondition(){
       if (!app.getUser().isLoginLinkPresent()) {
           app.getUser().clickOnSignOutButton();
       }
       app.getUser().clickOnLoginLink();
       app.getUser().fillLoginRegisterForm( new de.phonebook.model.User()
               .setEmail("irinafengshui71@gmail.com")
               .setPassword("Aa12345!"));
       app.getUser().clickLoginButton();
   }
   @Test(dataProvider = "addNewContactFromCsv", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveTest(Contact contact){
       app.getContact().clickOnAddLink();
       app.getContact().fillAddContactForm(contact);
       app.getContact().clickOnSaveButton();
       Assert.assertTrue(app.getContact().verifyByPhone(contact.getPhone()));

   }

    @AfterMethod
    public void postConditions(){
       app.getContact().removeContact();
    }

    public void removeContact() {
        app.getContact().click(By.cssSelector(".contact-item_card__2SOIM"));
        app.getContact().click(By.xpath("//button[.='Remove']"));
    }



}


