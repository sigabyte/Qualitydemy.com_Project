package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_05 {

    HomePage homePage=new HomePage();

    SignUpPage signUpPage=new SignUpPage();

    ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();

    LoginPage loginPage=new LoginPage();


    @Test
     public void TC_001(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        forgotPasswordPage.ForgotPassword.click();
        String actualPageTitle=forgotPasswordPage.ForgotPasswordPageTitle.getText();
        String expectedPageTitle="Forgot password";
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));

        Driver.closeDriver();

    }

    @Test
    public void TC_002(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        signUpPage.SignUpButton.click();
        String actualSignUpTitle=signUpPage.SignUPPageTitle.getText();
        String expectedSignUpTitle = "Sign Up";
        Assert.assertTrue(actualSignUpTitle.contains(expectedSignUpTitle));

        Driver.closeDriver();


    }

    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        loginPage.WelcomeMessage.isDisplayed();

        Driver.closeDriver();


    }
    @Test
    public void TC_004() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail2"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword2"));
        homePage.loginButton.click();
        loginPage.InvalidLoginCredentials.isDisplayed();

        Driver.closeDriver();

    }

    @Test
    public void TC_005() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail2"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        loginPage.InvalidLoginCredentials.isDisplayed();

        Driver.closeDriver();

    }



}
