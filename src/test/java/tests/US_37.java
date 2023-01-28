package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyCoursesPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_37 {
    HomePage homePage = new HomePage();
    MyCoursesPage mycourses = new MyCoursesPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        homePage.myCoursesLinki.click();

    }
    @AfterTest
    public void tearDown(){
        Driver.closeDriver();

    }
    @Test
    public void tc_001(){
        List<WebElement> kurselementList=Driver.getDriver().findElements(By.xpath("//span[@class='play-btn']"));
        int ilk= kurselementList.size();
        mycourses.sayfadakiIlkKursLinki.click();
        Assert.assertTrue(MyCoursesPage.compareThisCourseWithOther.isDisplayed(), "Compare this course with other");
    }
    @Test
    public void tc_002(){
        List<WebElement> kurselementList=Driver.getDriver().findElements(By.xpath("//span[@class='play-btn']"));
        int ilk= kurselementList.size();
        mycourses.sayfadakiIlkKursLinki.click();
        Assert.assertTrue(MyCoursesPage.courseOverview.isDisplayed(), "Course overview");
    }
    @Test
    public void tc_003(){
        
    }
    @Test
    public void tc_004(){

    }
}