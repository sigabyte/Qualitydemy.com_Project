package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserProfilePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_15 {

    HomePage homePage = new HomePage();

    UserProfilePage userProfilePage = new UserProfilePage();



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
    public void TC_001(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();
        String titleUserProfilePage = userProfilePage.userProfileTitle.getText();
        Assert.assertEquals("User profile",titleUserProfilePage);

        userProfilePage.firstName.clear();
        userProfilePage.firstName.sendKeys("sana" + Keys.TAB +
                "Ne" + Keys.TAB + "Student" + Keys.TAB + "Test Analyst" + Keys.TAB +
                "NOne" + Keys.TAB + "Twitter" + Keys.TAB + "Facebook" + Keys.TAB + "LinkedIn");
        }

    @Test
    public void TC_002(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();
        String titleUserProfilePage = userProfilePage.userProfileTitle.getText();
        Assert.assertEquals("User profile",titleUserProfilePage);

        userProfilePage.firstName.clear();
        userProfilePage.firstName.sendKeys("sana" + Keys.TAB + "Ne");

        userProfilePage.title.clear();
        userProfilePage.title.sendKeys( "Student");

        userProfilePage.skills.sendKeys("Tester" + Keys.ENTER);

        Driver.getDriver().switchTo().frame("Biography_ifr");
        userProfilePage.biography.clear();
        userProfilePage.biography.sendKeys("Once tester Always tester" + Keys.TAB);
        Driver.getDriver().switchTo().defaultContent();

        userProfilePage.twitter.sendKeys("@sana" + Keys.TAB + "#sana" + Keys.TAB + "$sana");
        userProfilePage.saveButton.submit();

        String toastMessageText = userProfilePage.toastMessage.getText();
        Assert.assertEquals("User update successfully",toastMessageText);
    }

    @Test
    public void TC_003(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();

        userProfilePage.profileButton.click();
        String titleUserProfilePage = userProfilePage.userProfileTitle.getText();
        Assert.assertEquals("User profile",titleUserProfilePage);
    }

}
