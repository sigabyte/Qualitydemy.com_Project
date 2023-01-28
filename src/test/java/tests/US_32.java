package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import utilities.ReusableMethods;

public class US_32 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        if (homePage.cookies.isDisplayed()) {homePage.cookies.click();}
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        homePage.instructorLink.click();
        instructorPage.courseManager.click();
        courseManagerPage.addNewCourseButton.click();
        addNewCoursePage.pricingButton.click();
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void TC_001(){

        //Check if this is a free course checkbox should be selectable

        boolean firstValue = addNewCoursePage.checkBoxValueCheck.isSelected();
        addNewCoursePage.checkIfThisIsAFreeCourseCheckbox.click();
        boolean secondValue = addNewCoursePage.checkBoxValueCheck.isSelected();
        Assert.assertFalse(firstValue == secondValue);
        ReusableMethods.waitFor(1);
        addNewCoursePage.checkIfThisIsAFreeCourseCheckbox.click();
    }

    @Test
    public void TC_002(){

        addNewCoursePage.coursePriceTextBox.sendKeys("50"); // Actual course price
        addNewCoursePage.discountedPriceTextBox.sendKeys("40"); // Discounted course price
        String actualDiscountPercentage = addNewCoursePage.discountPercentage.getText(); // Expected discount percentage 20.00%
        String expectedDiscountPercentage = "20";
        Assert.assertTrue(actualDiscountPercentage.contains(expectedDiscountPercentage));
    }

    @Test
    public void TC_003(){

        boolean firstValue = addNewCoursePage.discountValueCheck.isSelected();
        addNewCoursePage.checkIfThisCourseHasDiscountCheckbox.click();
        boolean secondValue = addNewCoursePage.discountValueCheck.isSelected();
        Assert.assertFalse(firstValue == secondValue);
    }

    @Test
    public void TC_004(){

        addNewCoursePage.coursePriceTextBox.sendKeys("50"); // Actual course price
        addNewCoursePage.discountedPriceTextBox.sendKeys("40"); // Discounted course price
        String actualDiscountPercentage = addNewCoursePage.discountPercentage.getText(); // Expected discount percentage 20.00%
        String expectedDiscountPercentage = "20";
        Assert.assertTrue(actualDiscountPercentage.contains(expectedDiscountPercentage));
    }

}
