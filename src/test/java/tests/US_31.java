package tests;

import org.openqa.selenium.By;
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

import java.util.List;

public class US_31 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();
    SoftAssert softAssert = new SoftAssert();


    @BeforeTest
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        homePage.instructorLink.click();
        instructorPage.courseManager.click();
        courseManagerPage.addNewCourseButton.click();
        addNewCoursePage.outcomesButton.click();
    }

    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void TC_001(){
        addNewCoursePage.outcomesTextBox.click();
        softAssert.assertTrue(addNewCoursePage.outcomesTextBox.isEnabled());

        addNewCoursePage.addOutcomesButton.click();
        softAssert.assertTrue(addNewCoursePage.deleteOutcomesButton.isDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void TC_002(){
        addNewCoursePage.addOutcomesButton.click();

        List<WebElement> outcomesSelectionAmount1 = addNewCoursePage.outcomesSelectionAmount1;
        int result1 = outcomesSelectionAmount1.size(); // 3 elements on list

        addNewCoursePage.deleteOutcomesButton.click(); // By clicking actually we are deleting one element from List

        List<WebElement> outcomesSelectionAmount2 = addNewCoursePage.outcomesSelectionAmount2;
        int result2 = outcomesSelectionAmount2.size(); // 2 elements on list

        Assert.assertEquals(result1-1,result2);
    }

}
