package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_08 {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    SignUpPage signUpPage=new SignUpPage();
    ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();
    Faker faker=new Faker();
    public static String emailAdress;

    @BeforeTest
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.logInLinki.click();
        homePage.cookies.click();

    }
    @Test
    public void tc_08_02(){
        loginPage.logInEmail.sendKeys("adfsdfa@jdfds.com");
        loginPage.logInPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        loginPage.loginButonu.click();

        Assert.assertTrue(loginPage.loginButonu.isDisplayed(),"Invalid login credentials");

    }
    @Test
    public void tc_08_03() throws InterruptedException {
        loginPage.logInEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        loginPage.logInPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        Thread.sleep(3000);
        loginPage.loginButonu.click();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.WelcomeMessage.isDisplayed(),"Welcome sana Ne");
    }
    @Test
    public void tc_08_04() throws InterruptedException {
         forgotPasswordPage.ForgotPassword.click();
         forgotPasswordPage.forgotPasswordEmailInput.sendKeys(ConfigReader.getProperty("userEmail"));
         Thread.sleep(3000);
         forgotPasswordPage.forgotPasswordSendRequestButton.click();

         Assert.assertTrue(forgotPasswordPage.SuccessMessage.isDisplayed(),"Check your inbox for the request");
    }
    @AfterTest
    public void closeDriver(){
        Driver.closeDriver();
    }
}
