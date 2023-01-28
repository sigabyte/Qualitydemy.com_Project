package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CoursePage;
import pages.HomePage;
import pages.InvoicePage;
import pages.PurchaseHistoryPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_014 {
    HomePage homePage = new HomePage();
    PurchaseHistoryPage purchaseHistoryPage = new PurchaseHistoryPage();

    InvoicePage invoicePage = new InvoicePage();

    CoursePage coursePage = new CoursePage();


    @BeforeTest
    public void setup() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown(){

        Driver.quitDriver();
    }

    @Test
    public void TC_001() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(homePage.purchaseHistory).click().perform();
        action.moveToElement(purchaseHistoryPage.invoiceButton).click().perform();

        ReusableMethods.switchToWindow("Invoice | QualityDemy");
        String title = invoicePage.invoicePageTitle.getText();
        Assert.assertEquals("invoice", title);
        Thread.sleep(4000);
    }

    @Test
    public void TC_002(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(homePage.purchaseHistory).click().perform();
        String title = purchaseHistoryPage.courseTitleFirstCourse.getText();
        action.moveToElement(purchaseHistoryPage.courseTitleFirstCourse).click().perform();
        String titleCoursePage = coursePage.courseTitleCourse.getText();
        Assert.assertEquals(title,titleCoursePage);

    }
}
