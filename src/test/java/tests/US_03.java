package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_03 {

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
    public void TC_03_001(){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Assert.assertTrue(homePage.twitterIcon.isDisplayed(),"twitter is failed");

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Assert.assertTrue(homePage.facebookIcon.isDisplayed(),"facebook is failed");

        JavascriptExecutor js3 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        Assert.assertTrue(homePage.linkedInIcon.isDisplayed(),"linkedInButton is failed");

    }
    @Test
    public void TC_03_002(){
        Assert.assertTrue(homePage.twitterIcon.isDisplayed());
        Assert.assertTrue(homePage.twitterIcon.isEnabled());
        ReusableMethods.clickWithJS(Driver.getDriver(), homePage.twitterIcon);
        ReusableMethods.waitFor(3);
        String twitterTitle=Driver.getDriver().getTitle();
        String beklenen="Twitter";
        Assert.assertTrue(twitterTitle.contains(beklenen));

        Driver.getDriver().navigate().back();

        Assert.assertTrue(homePage.facebookIcon.isDisplayed());
        Assert.assertTrue(homePage.facebookIcon.isEnabled());
        ReusableMethods.clickWithJS(Driver.getDriver(), homePage.facebookIcon);
        ReusableMethods.waitFor(3);
        String facebookTitle=Driver.getDriver().getTitle();
        String beklenenKelime="Facebook";
        Assert.assertTrue(facebookTitle.contains(beklenenKelime));


        Driver.getDriver().navigate().back();

        Assert.assertTrue(homePage.linkedInIcon.isDisplayed());
        Assert.assertTrue(homePage.linkedInIcon.isEnabled());
        ReusableMethods.clickWithJS(Driver.getDriver(), homePage.linkedInIcon);
        ReusableMethods.waitFor(3);
        String linkedinTitle=Driver.getDriver().getTitle();
        String beklenenTitle="linkedIn";
        Assert.assertTrue(twitterTitle.contains(beklenen));

        Driver.getDriver().navigate().back();

















    }









    }

















