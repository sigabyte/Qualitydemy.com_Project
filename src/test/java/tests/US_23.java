package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.AddNewCoursePage;
import pages.CourseManagerPage;
import pages.HomePage;
import pages.InstructorPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_23 {
    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage= new CourseManagerPage();

    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();

    @BeforeTest
    public void setUpAndGoToRequirementsSection(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        homePage.instructorLink.click();
        instructorPage.courseManager.click();
        courseManagerPage.courseListTitle.click();
        courseManagerPage.requirementsSection.click();

    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001(){
        courseManagerPage.requirementsFirstTextBox.clear();
        courseManagerPage.requirementsFirstTextBox.sendKeys("Test");
        courseManagerPage.requirementsAppendButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.requirementsSection.click();


        Assert.assertEquals(courseManagerPage.requirementsFirstTextBox.getAttribute("value"),"Test");
        Assert.assertTrue(courseManagerPage.requirementsRemoveButton.isEnabled());

    }

    @Test
    public void TC_002(){
        courseManagerPage.requirementsAppendButton.click();
        courseManagerPage.requirementsSecondTextBox.clear();
        courseManagerPage.requirementsSecondTextBox.sendKeys("Java, Python, C, C++, etc.");

        courseManagerPage.requirementsRemoveButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.requirementsSection.click();


        Assert.assertFalse(courseManagerPage.requirementsSecondTextBox.isDisplayed());

    }
}
