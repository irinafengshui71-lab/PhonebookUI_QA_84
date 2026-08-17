package de.phonebook.core;

import de.phonebook.fw.ContactHelper;
import de.phonebook.fw.HomePageHelper;
import de.phonebook.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class ApplicationManager{
    String browser;
    UserHelper user;
    ContactHelper contact;
    HomePageHelper homePage;

    WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser =browser;
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromiumdriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
   }
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homePage = new HomePageHelper(driver);

    }

    public void stop() {
        if (driver != null){
            driver.quit();
        }
    }

}
//gradle -Pbrowser=firfox clean qa
//./gradlew qa -Pbrowser=firefox

