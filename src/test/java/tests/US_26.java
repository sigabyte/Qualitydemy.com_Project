package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class US_26 {
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
        courseManagerPage.courseUpdatePageHeaderTags.get(5).click();

    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001(){
        courseManagerPage.mediaDropdownElement.click();
        courseManagerPage.mediaDropdownSelect.get(1).click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(5).click();

        Assert.assertEquals(courseManagerPage.mediaCourseOverviewProviderBox
                .getAttribute("title"),"Vimeo");
    }

    @Test
    public void TC_002(){
        courseManagerPage.mediaCourseOverviewUrlTextbox.clear();
        courseManagerPage.mediaCourseOverviewUrlTextbox.sendKeys("https://vimeo.com/169971886");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(5).click();
        Assert.assertEquals(courseManagerPage.mediaCourseOverviewUrlTextbox
                .getAttribute("value"),"https://vimeo.com/169971886");
    }

    @Test
    public void TC_003(){
        courseManagerPage.mediaCourseThumbnail.click();
        WebElement uploadElement =courseManagerPage.mediaUploadImage;
        //SOR

    }


}
