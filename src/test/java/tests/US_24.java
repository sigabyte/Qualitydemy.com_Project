package tests;

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
import utilities.ReusableMethods;

public class US_24 {
    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage= new CourseManagerPage();
    AddNewCoursePage addNewCoursePage= new AddNewCoursePage();

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
        courseManagerPage.outcomesSection.click();

    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001(){
        courseManagerPage.outcomesFirstTextBox.clear();
        courseManagerPage.outcomesFirstTextBox.sendKeys("Test");
        courseManagerPage.outcomesAppendButton.click();
        courseManagerPage.outcomesSecondTextBox.clear();
        courseManagerPage.outcomesSecondTextBox.sendKeys("Test2");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.outcomesSection.click();


        Assert.assertEquals(courseManagerPage.outcomesFirstTextBox.getAttribute("value"),"Test");
        Assert.assertTrue(courseManagerPage.outcomesSecondTextBox.isEnabled());

        courseManagerPage.outcomesRemoveButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
    }

    @Test
    public void TC_002(){
        courseManagerPage.outcomesFirstTextBox.clear();
        courseManagerPage.outcomesFirstTextBox.sendKeys("Test");
        courseManagerPage.outcomesAppendButton.click();
        courseManagerPage.outcomesSecondTextBox.sendKeys("Test2");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();


        courseManagerPage.courseUpdatePageHeaderTags.get(3).click();
        courseManagerPage.outcomesRemoveButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.outcomesSection.click();


        Assert.assertFalse(ReusableMethods.elementIsVisible(courseManagerPage.outcomesSecondTextBox));

    }
}
