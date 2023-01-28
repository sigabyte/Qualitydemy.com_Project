package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PaymentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_40 {

    HomePage homePage= new HomePage();
    PaymentPage paymentPage= new PaymentPage();

    @Test
    public void TC_001(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        paymentPage.SearchBox.sendKeys("piano course"+ Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");



        ReusableMethods.waitFor(2);

        Driver.closeDriver();


    }
    @Test
    public void TC_002(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        paymentPage.SearchBox.sendKeys("piano course"+ Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        String actualCoursesTitle=paymentPage.PianoCourse.getText();
        String expectedCoursesTitle = "Pianoforall - Incredible New Way To Learn Piano & Keyboard";
        Assert.assertTrue(actualCoursesTitle.contains(expectedCoursesTitle));

        ReusableMethods.waitFor(2);

        Driver.closeDriver();


    }
    @Test
    public void TC_003() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        Driver.getDriver().get("https://qa.qualitydemy.com/user");
        paymentPage.SaleReport.click();
        paymentPage.SelectDate.click();
        paymentPage.SelectDate2.click();
        paymentPage.FilterBtn.click();

        List<WebElement> courseList= Driver.getDriver().findElements(By.cssSelector("strong>a"));

        Assert.assertTrue(courseList.get(0).isDisplayed());

        Driver.closeDriver();
    }

}
