package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;
import pages.AddNewCoursePage;
import pages.CourseManagerPage;
import pages.HomePage;
import pages.InstructorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_25 {
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
        courseManagerPage.courseUpdatePageHeaderTags.get(4).click();

    }

    @AfterTest
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void TC_001(){

        courseManagerPage.pricingFreeCourseCheckbox.click();

        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.pricingSection.click();

        Assert.assertFalse(ReusableMethods.elementIsVisible(courseManagerPage.pricingCoursePriceTextbox));

        courseManagerPage.pricingFreeCourseCheckbox.click();

        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();

    }

    @Test
    public void TC_002(){
        courseManagerPage.pricingCoursePriceTextbox.clear();
        courseManagerPage.pricingCoursePriceTextbox.sendKeys("120");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.pricingSection.click();
        Assert.assertEquals(courseManagerPage.pricingCoursePriceTextbox.getAttribute("value"),"120");
    }

    @Test
    public void TC_003(){
        courseManagerPage.pricingDiscountCheckbox.click();
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.pricingSection.click();

        Assert.assertTrue(courseManagerPage.pricingDiscountCheckboxText.isSelected());
    }

    @Test
    public void TC_004(){
        courseManagerPage.pricingDiscountPriceTextbox.clear();
        courseManagerPage.pricingDiscountPriceTextbox.sendKeys("30");
        courseManagerPage.courseUpdatePageHeaderTags.get(7).click();
        addNewCoursePage.submitButton.click();
        courseManagerPage.pricingSection.click();
        Assert.assertEquals(courseManagerPage.pricingDiscountPriceTextbox.getAttribute("value"),"30");

    }


}

