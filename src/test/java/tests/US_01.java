package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ForgotPasswordPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_01 {
    HomePage homePage=new HomePage();

    @Test
    public void TC_001(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        String homeTitle=Driver.getDriver().getTitle();
        String beklenenKelime="Home";
        Assert.assertTrue(homeTitle.contains(beklenenKelime));










    }


}





















