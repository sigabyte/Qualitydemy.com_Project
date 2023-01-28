package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddNewCoursePage;
import pages.CourseManagerPage;
import pages.HomePage;
import pages.InstructorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.SQLOutput;

public class US_22 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();

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
        courseManagerPage.exampleCourseLink.click();
        courseManagerPage.basicButton.click();
    }

    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void tc_22_001(){
        courseManagerPage.addNewInstructorTextbox.sendKeys("Admin User" + Keys.ENTER);
        String expectedStr = "Admin";
        String actualStr = courseManagerPage.addNewInstructorTextbox.getText();
        Assert.assertTrue(actualStr.contains(expectedStr));
    }

    @Test
    public void tc_22_002(){
        courseManagerPage.courseTitleTextInput.clear();
        courseManagerPage.courseTitleTextInput.sendKeys("New name");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(1).click();
        Assert.assertEquals(courseManagerPage.courseTitleTextInput.getAttribute("value"), "New name");
        courseManagerPage.courseTitleTextInput.clear();
        courseManagerPage.courseTitleTextInput.sendKeys("Example Course");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
    }

    @Test
    public void tc_22_003() {
        String expectedStr = "HTML5 and CSS";
        addNewCoursePage.categoryDropDownMenu.click();
        addNewCoursePage.categoryDropDownMenuSearchInput.sendKeys(expectedStr + Keys.ENTER);
        Assert.assertEquals(addNewCoursePage.categoryDropDownMenu.getAttribute("title"), expectedStr);
    }

    @Test
    public void tc_22_004() {
        String expectedStr = "Advanced";
        addNewCoursePage.levelDropDownMenu.click();
        addNewCoursePage.levelDropDownMenuSearchInput.sendKeys(expectedStr + Keys.ENTER);
        Assert.assertEquals(addNewCoursePage.levelDropDownMenu.getAttribute("title"), expectedStr);
    }

    @Test
    public void tc_22_005() {
        boolean firstValue = addNewCoursePage.switchBtnValue.isSelected();
        addNewCoursePage.switchBtnText.click();
        boolean secondValue = addNewCoursePage.switchBtnValue.isSelected();
        Assert.assertNotEquals(firstValue, secondValue);
    }

    @Test
    public void tc_22_006() {
        boolean firstValue = addNewCoursePage.checkbox.isSelected();
        addNewCoursePage.checkboxText.click();
        boolean secondValue = addNewCoursePage.checkbox.isSelected();
        Assert.assertNotEquals(firstValue, secondValue);
    }
}
