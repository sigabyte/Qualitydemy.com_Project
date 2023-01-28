package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_34 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    CourseEditPage courseEditPage = new CourseEditPage();
    CoursesDetailsPage coursesDetailsPage = new CoursesDetailsPage();

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
        courseManagerPage.courseUpdatePageHeaderTags.get(6).click();
        courseManagerPage.metaKeywordsTextbox.clear();
        courseManagerPage.metaKeywordsTextbox.sendKeys(ConfigReader.getProperty("metaKeywords") + Keys.ENTER);
        courseManagerPage.metaDescriptionTextbox.clear();
        courseManagerPage.metaDescriptionTextbox.sendKeys(ConfigReader.getProperty("metaDescription") + Keys.ENTER);

        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        courseManagerPage.lessonUpdatePageSubmitButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(6).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(courseManagerPage.metaKeywordsText.getText(), ConfigReader.getProperty("metaKeywords"));
        softAssert.assertEquals(courseManagerPage.metaDescriptionTextbox.getText(), ConfigReader.getProperty("metaDescription"));
        softAssert.assertAll();

    }
}
