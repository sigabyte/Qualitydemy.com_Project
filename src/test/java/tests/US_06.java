package tests;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.CorruptedFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import pages.TempMailPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

/*
    When the correct data is entered and the sign up button is pressed,
    it should redirect to the verification_code page and
    a green verification message should appear in the corner.

    user should be able to enter the correct data,
    press the register button and see that they have registered
 */
public class US_06 {
    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();
    LoginPage loginPage = new LoginPage();

    public static String emailAdress;

    Faker faker = new Faker();


    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
    }

    @Test
    public void tc_06_001() throws IOException, UnsupportedFlavorException, InterruptedException {
        //The user goes to the home page.

        String qdHomePageWHD = Driver.getDriver().getWindowHandle();

        //Accepts the cookies.
        homePage.cookies.click();

        //Clicks on the Signup button.
        homePage.signUpButton.click();

        //Fills in the Name field.
        signUpPage.firstNameInput.sendKeys("Team7");

        //Fills in the last name field.
        signUpPage.lastNameInput.sendKeys("Proje");


        //User enters their email address
        emailAdress = faker.internet().emailAddress();
        signUpPage.emailInput.sendKeys(emailAdress);


        //Creates a password.
        signUpPage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));

        //Presses the register button.
        signUpPage.registrationSignUpButton.click();
        Thread.sleep(5000);


        //The user sees that he is on the login page.

        String expectedKelime = "Login";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

    }

    @Test
    public void tc_06_02() {


        //Clicks the login button.
        homePage.logInLinki.click();

        //User enters their e-mail and password and
        loginPage.logInEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        loginPage.logInPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        loginPage.loginButonu.click();

        //.User sees the Qulitydemy homepage
        String expectedKelime = "home";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

    }

    @Test
    public void tc_06_03() {


        //Clicks on the sign up button.
        homePage.signUpButton.click();

        //At least two letters must be entered in the name field.
        signUpPage.firstNameInput.sendKeys("a");
        signUpPage.lastNameInput.sendKeys("b");
        signUpPage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        signUpPage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));

        String expectedKelime = "sign_up";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));
    }

    @Test
    public void tc_06_04() {


        //Clicks on the sign up button
        homePage.signUpButton.click();

        //.Fills in the first name, last name and email address fields.
        signUpPage.firstNameInput.sendKeys("Admin");
        signUpPage.lastNameInput.sendKeys("Admin");
        signUpPage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        signUpPage.passwordInput.sendKeys("admin");
        signUpPage.registrationSignUpButton.click();

        String expectedUrlKelime = "sign_up";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlKelime));

    }

    @Test
    public void tc_06_05() {


        //Clicks on the -Register button
        homePage.signUpButton.click();

        //Fills in the first and last name fields.
        signUpPage.firstNameInput.sendKeys("Admin");
        signUpPage.lastNameInput.sendKeys("admin");


        //Enters values without @ and .com in the Email field
        signUpPage.emailInput.sendKeys("admingmailcom");

        //Fills in the password field
        signUpPage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));

        //Clicks the Register button
        signUpPage.registrationSignUpButton.click();

        //Gets a warning that he/she did not enter they e-mail address in the correct format
        String expectedurlKelime = "sign_up";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedurlKelime));
    }

    @Test
    public void tc_06_06() {


        //Clicks on the Register button.
        homePage.signUpButton.click();

        //Fills in the name, surname, password fields.
        signUpPage.firstNameInput.sendKeys("Addmin");
        signUpPage.lastNameInput.sendKeys("admin");
        signUpPage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));

        //Enter the e-mail address that the email addressee has previously registered.
        signUpPage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));

        //The user sees a warning that they have already registered
        String expectedurlKelime = "sign_up";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedurlKelime));

    }


   /*@AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
    }

    */


}
