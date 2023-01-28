package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddNewCoursePage;
import pages.CourseManagerPage;
import pages.HomePage;
import pages.InstructorPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_28 {

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
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();

    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001(){
        courseManagerPage.finishSubmitButton.click();
    }
}
