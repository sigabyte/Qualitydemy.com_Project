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

public class US_30 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    SoftAssert softAssert = new SoftAssert();

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
        courseManagerPage.addNewCourseButton.click();
        addNewCoursePage.requirementsButton.click();
    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001() {
        addNewCoursePage.requirementsTextBox.click();
        softAssert.assertTrue(addNewCoursePage.requirementsTextBox.isEnabled());


        addNewCoursePage.addRequirementButton.click();
        softAssert.assertTrue(addNewCoursePage.deleteRequirementButton.isDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void TC_002() {
        addNewCoursePage.addRequirementButton.click();

        int webElementAmount1 = addNewCoursePage.requirementsSelectionsAmount.size(); // List element amount 3
        System.out.println(webElementAmount1);
        addNewCoursePage.deleteRequirementButton.click(); //2 (By clicking actually we are deleting one element from List)

        int webElementAmount2 = addNewCoursePage.requirementsSelectionsAmount.size(); // List element amount 2
        System.out.println(webElementAmount2);
        Assert.assertTrue(webElementAmount1>webElementAmount2);

    }
}