package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BecomeAnInstructor;
import pages.HomePage;
import pages.SignUpPage;
import pages.TempMailPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_36 {

    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();
    TempMailPage tempMailPage = new TempMailPage();
    Faker faker = new Faker();
    public static String emailAddress;
    BecomeAnInstructor becomeAnInstructor = new BecomeAnInstructor();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();

        homePage.signUpButton.click();
        signUpPage.firstNameInput.sendKeys(faker.name().firstName());
        signUpPage.lastNameInput.sendKeys(faker.name().lastName());

        emailAddress = faker.internet().emailAddress();

        signUpPage.emailInput.sendKeys(emailAddress);
        signUpPage.passwordInput.sendKeys("Password1");
        signUpPage.registrationSignUpButton.click();


        homePage.emailInput.sendKeys(emailAddress);
        homePage.passwordInput.sendKeys("Password1");
        homePage.loginButton.click();
        homePage.instructorLink.click();
    }

    @Test
    public void tc_36_001() {
        String value = becomeAnInstructor.name.getAttribute("value");
        becomeAnInstructor.name.sendKeys("Deneme");
        String newValue = becomeAnInstructor.name.getAttribute("value");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(value, newValue);

        value = becomeAnInstructor.email.getAttribute("value");
        becomeAnInstructor.email.sendKeys("Deneme");
        newValue = becomeAnInstructor.email.getAttribute("value");
        softAssert.assertEquals(value, newValue);

        softAssert.assertAll();
    }

    @Test
    public void tc_36_002() {
        String phone = "1111";
        String address = "aaaa";
        String anyMessage = "bbbb";

        becomeAnInstructor.phone.sendKeys(phone);
        becomeAnInstructor.address.sendKeys(address);
        becomeAnInstructor.anyMessage.sendKeys(anyMessage);
        becomeAnInstructor.applyButton.click();
        becomeAnInstructor.applicationDetails.click();

        ReusableMethods.waitFor(1);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(phone, becomeAnInstructor.phoneVerifyText.getText());
        softAssert.assertEquals(address, becomeAnInstructor.addressVerifyText.getText());
        softAssert.assertEquals(anyMessage, becomeAnInstructor.anyMessageVerifyText.getText());
        softAssert.assertAll();
    }

    @Test
    public void tc_36_003() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(becomeAnInstructor.documentInput.isEnabled());
    }

    @Test
    public void tc_36_004() {
        tc_36_002();
        becomeAnInstructor.closeDetailyPage.click();
        Assert.assertTrue(becomeAnInstructor.clickToActivateButton.isDisplayed());
    }

    @Test
    public void tc_36_005() {
        tc_36_004();
        becomeAnInstructor.clickToActivateButton.click();
        ReusableMethods.waitFor(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Driver.getDriver().switchTo().alert().getText(), "Your application has been approved");
        Driver.getDriver().switchTo().alert().accept();
        softAssert.assertEquals(becomeAnInstructor.approvedText.getText(), "Approved");
        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}
