package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class US_33 {
    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    CourseEditPage courseEditPage = new CourseEditPage();
    CoursesDetailsPage coursesDetailsPage = new CoursesDetailsPage();
    SoftAssert softAssert= new SoftAssert();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        homePage.instructorLink.click();
        instructorPage.courseManager.click();
    }
    @Test
    public void tc_001(){
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(5).click();
        courseManagerPage.courseOverviewProviderDropDown.click();
        String text=courseManagerPage.outcomesFirstTextBox.getText();
        softAssert.assertTrue(text.contains("Youtube"));

    }
    @Test
    public void tc_002(){
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(5).click();
        courseManagerPage.courseOverviewUrl.clear();
        courseManagerPage.courseOverviewUrl.sendKeys(ConfigReader.getProperty("URLYoutubeLesson") + Keys.ENTER);
        Assert.assertTrue(courseManagerPage.courseOverviewUrl.isDisplayed(),"URLYoutubeLesson");
    }

 }
