package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_09 {
    HomePage homePage=new HomePage();
    CoursesDetailsPage detailsPage=new CoursesDetailsPage();
    Actions actions= new Actions(Driver.getDriver());
    ShoppingCartPage shop=new ShoppingCartPage();
    AllCourseAllCategoryPage allCourse= new AllCourseAllCategoryPage();

    @BeforeTest
    public void giris(){
        HomePage.login();
        actions.moveToElement(homePage.category).moveToElement(homePage.allCourseCategory).click().perform();
        try {
            Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            ReusableMethods.clickWithJS(Driver.getDriver(),allCourse.nextPageButton);
            Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
        }
        detailsPage.addToCartButonu.click();
        detailsPage.buyNowButonu.click();
    }
    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test
    public void TC_001(){
        shop.sayfadakiIlkKursunRemoveButonu.click();
        //burada BUG olarak remove butonu calismiyor ve test fail veriyor
        Assert.assertFalse(shop.sayfadakiIlkKurs.isDisplayed());
    }

    @Test
    public void TC_02(){
        shop.CouponBox.sendKeys(ConfigReader.getProperty("discount10"));
        shop.applyButton.click();
        Assert.assertTrue(shop.couponAppliedYazisi.isDisplayed());
    }

    @Test
    public void TC_03(){
        String ilkFiyat=shop.totalPrice.getText();
        shop.CouponBox.sendKeys(ConfigReader.getProperty("invalid"));
        shop.applyButton.click();
        String ikinciFiyat=shop.totalPrice.getText();
        Assert.assertEquals(ikinciFiyat, ilkFiyat);
    }

    @Test
    public void TC_04() {
        String shopPageTitle=Driver.getDriver().getTitle();
        shop.checkoutButton.click();
        String paymentTitle=Driver.getDriver().getTitle();
        ReusableMethods.waitFor(3);
        Assert.assertNotEquals(paymentTitle, shopPageTitle);
    }

}