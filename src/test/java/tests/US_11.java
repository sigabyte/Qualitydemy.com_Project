package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class US_11 {

    Actions actions= new Actions(Driver.getDriver());
    HomePage homePage = new HomePage();
    CoursesDetailsPage course= new CoursesDetailsPage();
    WishlistPage wish=new WishlistPage();

    @BeforeClass
    public void wishlistegit() {
        HomePage.login();
        ReusableMethods.waitFor(8);
        actions.clickAndHold(homePage.wishListKalp).perform();
        homePage.gotoWishListLinki.click();
    }
    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void TC_01(){
        ReusableMethods.clickWithJS(Driver.getDriver(),wish.compare);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Compare"));
    }

    @Test
    public void TC_02_03() {
        ReusableMethods.clickWithJS(Driver.getDriver(),wish.ilkkursAdi);
        String kursIsmi = course.courseH1Title.getText();
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(kursIsmi));

        Driver.getDriver().navigate().back();
        wish.seacrMycoursesBox.click();
        wish.seacrMycoursesBox.sendKeys(kursIsmi + Keys.ENTER);
        ReusableMethods.waitFor(4);
        Assert.assertTrue(wish.ilkkursAdi.isDisplayed());
    }

    @Test
    public void TC_04(){
        ReusableMethods.clickWithJS(Driver.getDriver(),wish.ilkInstructorImg);
        Assert.assertTrue(wish.instructorYazisi.isDisplayed());
    }

    @Test
    public void TC_05(){
        ReusableMethods.clickWithJS(Driver.getDriver(),wish.ilkkursAdi);
        String numberofCourse=course.numberOfCourse.getText();
        String c=numberofCourse.substring(0,1);
        int number=Integer.parseInt(c);
        Assert.assertTrue(number>=0);
        Assert.assertTrue(course.durationOfCourse.isDisplayed());
    }

}
