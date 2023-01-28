package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import java.util.List;


public class US_29 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();

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
    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001(){
        /*
        Verify Description input is functional
        Verify Course title input is functional
        Verify Short description input is functional
         */
        addNewCoursePage.description.sendKeys("Learn how to code");
        String actualDescription = addNewCoursePage.description.getText();
        String expectedDescription = "Learn how to code";
        Assert.assertTrue(actualDescription.contains(expectedDescription));

        addNewCoursePage.courseTitleTextBox.sendKeys("Trial course");
        addNewCoursePage.shortDescriptionTextBox.sendKeys("This is an example course");
        addNewCoursePage.categoryDropDownMenu.click();
        addNewCoursePage.categoryDropDownMenuSearchInput.sendKeys("HTML5 and CSS" + Keys.ENTER);
        addNewCoursePage.finishButton.click();
        addNewCoursePage.submitButton.click();
        instructorPage.courseManager.click();
        int i = 0;
        for (WebElement e : courseManagerPage.courseListElements) {
            if(e.getText().contains("Trial course")) {
                e.click();
                break;
            }
            i++;
        }
        courseManagerPage.courseUpdatePageHeaderTags.get(1).click();
        String actualCourseTitle = addNewCoursePage.courseTitleTextBox.getAttribute("value");
        String expectedCourseTitle = "Trial course";
        Assert.assertTrue(actualCourseTitle.contains(expectedCourseTitle));
        String actualShortDescription = addNewCoursePage.shortDescriptionTextBox.getText();
        String expectedShortDescription = "This is an example course";
        Assert.assertTrue(actualShortDescription.contains(expectedShortDescription));
        instructorPage.courseManager.click();
        courseManagerPage.selectedElementThreeDots.get(i).click();
        courseManagerPage.threeDotAllElements.get(5).click();
        courseManagerPage.continueButton.click();


    }

    @Test
    public void TC002(){
        addNewCoursePage.categoryDropDownMenu.click();
        addNewCoursePage.categoryDropDownMenuSearchInput.sendKeys("Web Design" + Keys.ENTER);
        String actualStr = addNewCoursePage.categoryDropDownMenu.getText();
        String expectedStr = "Web Design";
        Assert.assertTrue(actualStr.contains(expectedStr));
    }

    @Test
    public void TC003() {
        addNewCoursePage.levelDropDownMenu.click();
        addNewCoursePage.levelDropDownMenuSearchInput.sendKeys("Advanced" + Keys.ENTER);
        String actualStr =addNewCoursePage.levelDropDownMenu.getText();
        String expectedStr = "Advanced";
        Assert.assertTrue(actualStr.contains(expectedStr));
    }

    @Test
    public void TC004(){
        addNewCoursePage.languageMadeInDropDownMenu.click();
        addNewCoursePage.languageMadeInDropDownMenuSearchInput.sendKeys("English" + Keys.ENTER);
        String actualStr = addNewCoursePage.languageMadeInDropDownMenu.getText();
        String expectedStr = "English";
        Assert.assertTrue(actualStr.contains(expectedStr));
    }

    @Test
    public void TC_005(){
       // if (ReusableMethods.elementIsVisible(courseManagerPage.addNewCourseButton)){courseManagerPage.addNewCourseButton.click();}
        boolean firstValue = addNewCoursePage.switchBtnValue.isSelected();
        addNewCoursePage.switchBtnText.click();
        boolean secondValue = addNewCoursePage.switchBtnValue.isSelected();
        Assert.assertNotEquals(firstValue, secondValue);

    }

    @Test
    public void TC_OO6(){
        boolean firstValue = addNewCoursePage.checkbox.isSelected();
        addNewCoursePage.checkboxText.click();
        boolean secondValue = addNewCoursePage.checkbox.isSelected();
        Assert.assertNotEquals(firstValue, secondValue);
    }
}