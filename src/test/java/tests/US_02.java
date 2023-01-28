package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_02 {
    HomePage homePage=new HomePage();
    @BeforeTest
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
    }
    @AfterTest
    public void tearDown(){

    }
    @Test
    public void TC_02_002() {

        homePage.logo.isDisplayed();
        Assert.assertTrue(homePage.logo.isDisplayed(), "logo is failed");

        homePage.category.isDisplayed();
        Assert.assertTrue(homePage.category.isDisplayed(), "category is failed");

        homePage.logInLinki.isDisplayed();
        Assert.assertTrue(homePage.logInLinki.isDisplayed(), "login linki is failed");

        homePage.signUpButton.isDisplayed();
        Assert.assertTrue(homePage.signUpButton.isDisplayed(), "signUpButton is failed");

        homePage.LifeTimeText.isDisplayed();
        Assert.assertTrue(homePage.LifeTimeText.isDisplayed(), "lifetime linki is failed");

        homePage.ExpertInstructionText.isDisplayed();
        Assert.assertTrue(homePage.ExpertInstructionText.isDisplayed(), "expertinstruction linki is failed");

        homePage.GetStartedButton.isDisplayed();
        Assert.assertTrue(homePage.GetStartedButton.isDisplayed(),"get started button is failed");


         homePage.shoppingCart.isDisplayed();
         Assert.assertTrue(homePage.shoppingCart.isDisplayed(),"shopping cart is failed");


         homePage.Top10LatestCourses.isDisplayed();
         Assert.assertTrue(homePage.Top10LatestCourses.isDisplayed(),"Top10 Latest courses is failed");

        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Assert.assertTrue(homePage.twitterIcon.isDisplayed(),"twitter is failed");

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Assert.assertTrue(homePage.facebookIcon.isDisplayed(),"facebook is failed");

        JavascriptExecutor js3 = (JavascriptExecutor) Driver.getDriver();
        js3.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Assert.assertTrue(homePage.linkedInIcon.isDisplayed(),"linkedInButton is failed");


    }


        @Test
        public void TC_02_003(){

            JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click()", homePage.aboutUsButton );

            String actual=js.executeScript("return document.title").toString();
            String expected="About Us | QualityDemy";

            Assert.assertEquals(actual,expected);

















        }























}
