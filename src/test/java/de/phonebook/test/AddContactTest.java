package de.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{


   @BeforeMethod
   public void precondition(){
       clickOnLoginLink();
       fillLoginRegisterForm("irinafengshui71@gmail.com", "Aa12345!");
       clickLoginButton();
   }
   @Test
    public void addContactPositiveTest(){
       clickOnAddLink();
       fillAddContactForm("Oliver", "Kan", "123456782390", "kan@gmail.com", "TelAviv", "QA");
       clickOnSaveButton();
       Assert.assertTrue(verifyByName("Oliver"));

   }

    @AfterMethod
    public void postConditions(){

        removeContact();
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
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