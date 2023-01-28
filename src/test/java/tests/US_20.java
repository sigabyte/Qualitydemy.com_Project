package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class US_20 {
    /*
    When the Back to course list button is clicked, it should redirect to the course manager page.
    When the View on frontend button is clicked, it should redirect to the page of the relevant course content.
    It should be possible to switch between the menus with the arrows at the bottom of the page
     */
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
    public void tc_001() {
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();
        courseEditPage.backToCourseList.click();
        String actualH4TitleStr = courseManagerPage.courseManagerPageH4.getText();
        Assert.assertTrue(actualH4TitleStr.contains("Courses"));
    }

    @Test
    public void tc_002() throws InterruptedException {
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(1).click();
        String title = courseManagerPage.courseTitleTextInput.getAttribute("value");
        courseEditPage.viewOnFrontEnd.click();
        ReusableMethods.switchToWindow(title.substring(0, 1).toUpperCase() + title.substring(1) + " | QualityDemy");
        Assert.assertTrue(coursesDetailsPage.courseH5Title.getText().contains(title));
    }

    @Test
    public void tc_003() {
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();
        courseEditPage.rightArrow.click();
        String visibleText= courseEditPage.courseTitel.getText();
        softAssert.assertTrue(visibleText.contains("Course Title"),"The requested text is not visible");
        String visibleSection= courseEditPage.addSection.getText();
        softAssert.assertTrue(visibleSection.contains("Add Section"), "The requested section is not visible");
    }
}
