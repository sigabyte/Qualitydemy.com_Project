package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_39 {

    HomePage homePage=new HomePage();

    PaymentPage paymentPage=new PaymentPage();









    @Test
    public void TC_001(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        paymentPage.SearchBox.sendKeys("piano course"+Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        paymentPage.AddToCart.click();
        paymentPage.ShoppingCart.click();
        paymentPage.CheckoutBtn.click();
        paymentPage.StripeBtn.click();
        paymentPage.StripePayBtn.isDisplayed();
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
        paymentPage.SearchBox.sendKeys("piano course"+Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        paymentPage.AddToCart.click();
        paymentPage.ShoppingCart.click();
        paymentPage.CheckoutBtn.click();
        paymentPage.StripeBtn.click();
        paymentPage.StripePayBtn.click();
        Driver.getDriver().navigate().to("https://checkout.stripe.com");


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
        paymentPage.SearchBox.sendKeys("piano course"+Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        paymentPage.AddToCart.click();
        paymentPage.ShoppingCart.click();
        paymentPage.CheckoutBtn.click();
        paymentPage.CloseIcon.click();

        Driver.closeDriver();


    }

    @Test
    public void TC_004(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        paymentPage.SearchBox.sendKeys("piano course"+Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        paymentPage.AddToCart.click();
        paymentPage.ShoppingCart.click();
        paymentPage.CheckoutBtn.click();
        paymentPage.StripeBtn.click();
        paymentPage.StripePayBtn.click();
        paymentPage.MailBox.sendKeys(ConfigReader.getProperty("userEmail"));
        paymentPage.CardNumberBox.sendKeys(ConfigReader.getProperty("creditCardNumber"));
        paymentPage.CardMMYY.sendKeys(ConfigReader.getProperty("mmyy"));
        paymentPage.CVC.sendKeys(ConfigReader.getProperty("CVC"));
        paymentPage.NameOnCard.sendKeys(ConfigReader.getProperty("NameOnCard"));
        paymentPage.Country.sendKeys(ConfigReader.getProperty("country"));


        Driver.closeDriver();



    }

    @Test
    public void TC_005() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        paymentPage.SearchBox.sendKeys("piano course" + Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        paymentPage.AddToCart.click();
        paymentPage.ShoppingCart.click();
        paymentPage.CheckoutBtn.click();
        paymentPage.StripeBtn.click();
        paymentPage.StripePayBtn.click();
        paymentPage.MailBox.sendKeys(ConfigReader.getProperty("userEmail"));
        paymentPage.CardNumberBox.sendKeys(ConfigReader.getProperty("creditCardNumber"));
        paymentPage.CardMMYY.sendKeys(ConfigReader.getProperty("mmyy"));
        paymentPage.CVC.sendKeys(ConfigReader.getProperty("CVC"));
        paymentPage.NameOnCard.sendKeys(ConfigReader.getProperty("NameOnCard"));
        paymentPage.Country.sendKeys(ConfigReader.getProperty("country"));
        paymentPage.SubmitPayBtn.click();

        ReusableMethods.waitFor(3);


        Driver.closeDriver();


    }

    @Test
    public void TC_006() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        paymentPage.SearchBox.sendKeys("Disney Magic English" + Keys.ENTER);
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/disney-magic-english/7");
        paymentPage.AddToCart.click();
        paymentPage.ShoppingCart.click();
        paymentPage.CheckoutBtn.click();
        paymentPage.StripeBtn.click();
        paymentPage.StripePayBtn.click();
        paymentPage.MailBox.sendKeys(ConfigReader.getProperty("userEmail"));
        paymentPage.CardNumberBox.sendKeys(ConfigReader.getProperty("creditCardNumber"));
        paymentPage.CardMMYY.sendKeys(ConfigReader.getProperty("mmyy"));
        paymentPage.CVC.sendKeys(ConfigReader.getProperty("CVC"));
        paymentPage.NameOnCard.sendKeys(ConfigReader.getProperty("NameOnCard"));
        paymentPage.Country.sendKeys(ConfigReader.getProperty("country"));
        paymentPage.SubmitPayBtn.click();
        paymentPage.PaymentSucces.isDisplayed();
        String actualMyCoursesTitle=paymentPage.MyCourses.getText();
        String expectedMyCoursesTitle = "My courses";
        Assert.assertTrue(actualMyCoursesTitle.contains(expectedMyCoursesTitle));


        ReusableMethods.waitFor(3);


        Driver.closeDriver();


    }



}
