package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class US_35 {
    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    CourseEditPage courseEditPage = new CourseEditPage();
    CoursesDetailsPage coursesDetailsPage = new CoursesDetailsPage();
    SoftAssert softAssert=new SoftAssert();

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
    public void tc_001() throws InterruptedException {
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        courseManagerPage.lessonUpdatePageSubmitButton.click();
        String visibleText = courseEditPage.courseTitel.getText();
        softAssert.assertTrue(visibleText.contains("Congratulations!"));

    }
}
