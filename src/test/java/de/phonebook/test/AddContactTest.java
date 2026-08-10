package de.phonebook.test;

import de.phonebook.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {


   @BeforeMethod
   public void precondition(){
       if (!app.getUser().isLoginLinkPresent()) {
           app.getUser().clickOnSignOutButton();
       }
       app.getUser().clickOnLoginLink();
       app.getUser().fillLoginRegisterForm( new de.phonebook.model.User().setEmail("irinafengshui71@gmail.com").setPassword("Aa12345!"));
       app.getUser().clickLoginButton();
   }
   @Test
    public void addContactPositiveTest(){
       app.getContact().clickOnAddLink();
       app.getContact().fillAddContactForm(new de.phonebook.model.Contact().setName("Oliver")
               .setLastname("Kan").setPhone("123456782390")
               .setEmail("kan@gmail.com").setAddress("TelAviv").setDesk("QA"));
       app.getContact().clickOnSaveButton();
       Assert.assertTrue(app.getContact().verifyByName("Oliver"));

   }

    @AfterMethod
    public void postConditions(){

        removeContact();
    }

    public void removeContact() {
        app.getContact().click(By.cssSelector(".contact-item_card__2SOIM"));
        app.getContact().click(By.xpath("//button[.='Remove']"));
    }
}
//before -login

//click on add link

//enter name
//enter lastname
//enter phone
//enter email
//enter address
//enter description
//click on Save button