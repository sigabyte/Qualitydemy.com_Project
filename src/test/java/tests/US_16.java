package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CredentialsPage;
import pages.HomePage;
import pages.UserProfilePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_16 {

    HomePage homePage = new HomePage();
    UserProfilePage userProfilePage = new UserProfilePage();
    CredentialsPage credentialsPage = new CredentialsPage();


    @BeforeTest
    public void setup() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown(){

        Driver.quitDriver();
    }

    @Test
    public void TC_001() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();

        userProfilePage.accountButton.click();
        String pageTitle = credentialsPage.credentialTitle.getText();
        Assert.assertEquals("Credentials", pageTitle);

        Thread.sleep(2000);

    }
    @Test
    public void TC_002() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();
        userProfilePage.accountButton.click();


        credentialsPage.currentPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        credentialsPage.newPassword.sendKeys("145300");
        credentialsPage.confirmPassword.sendKeys("145300");

        String newPswrd = credentialsPage.newPassword.getAttribute("value");
        String confirmPswrd = credentialsPage.confirmPassword.getAttribute("value");

        Assert.assertEquals("145300", newPswrd);
        Assert.assertEquals("145300" , confirmPswrd);

    }

    @Test
    public void TC_003(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();
        userProfilePage.accountButton.click();

        credentialsPage.currentPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        credentialsPage.newPassword.sendKeys("145300");
        credentialsPage.confirmPassword.sendKeys("145300");

        String newPswrd = credentialsPage.newPassword.getAttribute("value");
        String confirmPswrd = credentialsPage.confirmPassword.getAttribute("value");
        Assert.assertEquals(newPswrd, confirmPswrd, "New password and Confirm password are same");


        System.out.println("There is no SAVE BUTTON to click for further proceeding");

    }

    @Test
    public void TC_004(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();
        userProfilePage.accountButton.click();

        credentialsPage.currentPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        credentialsPage.newPassword.sendKeys("145300");
        credentialsPage.confirmPassword.sendKeys("1453000");

        String newPswrd = credentialsPage.newPassword.getAttribute("value");
        String confirmPswrd = credentialsPage.confirmPassword.getAttribute("value");
        Assert.assertNotEquals(newPswrd, confirmPswrd, "New password and Confirm password are different");

        System.out.println("There is no SAVE BUTTON to click for further proceeding");

    }
}
