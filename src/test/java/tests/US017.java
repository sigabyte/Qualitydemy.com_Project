package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UpdateUserPhotoPage;
import pages.UserProfilePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US017 {
    HomePage homePage = new HomePage();
    UserProfilePage userProfilePage = new UserProfilePage();

    UpdateUserPhotoPage userPhotoPage = new UpdateUserPhotoPage();


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
        action.moveToElement(userProfilePage.userProfile).click().perform();

        userProfilePage.photoButton.click();
        String photoPageTitle = userPhotoPage.updatePhotoTitle.getText();
        Assert.assertEquals("Update user photo", photoPageTitle);

        userPhotoPage.imagePath.submit();

        Thread.sleep(3000);
    }

    @Test
    public void TC_002() throws InterruptedException {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.userMenuIcon).perform();
        action.moveToElement(userProfilePage.userProfile).click().perform();

        userProfilePage.photoButton.click();
        String photoPageTitle = userPhotoPage.updatePhotoTitle.getText();
        Assert.assertEquals("Update user photo", photoPageTitle);

        userPhotoPage.imagePath.sendKeys("C:/Users/NIZAMIYE HOSPITAL/OneDrive/Pictures/Screenshots/2022-08-11.png");
        userPhotoPage.uploadButton.submit();

        String toastMessageTex = userPhotoPage.toastMessage.getText();
        Assert.assertEquals("Updated successfully",toastMessageTex);

        Thread.sleep(3000);

    }



    @Test
    public void TC_003() throws InterruptedException {
            Actions action = new Actions(Driver.getDriver());
            action.moveToElement(homePage.userMenuIcon).perform();
            action.moveToElement(userProfilePage.userProfile).click().perform();

            userProfilePage.photoButton.click();
            String photoPageTitle = userPhotoPage.updatePhotoTitle.getText();
            Assert.assertEquals("Update user photo", photoPageTitle);

            userPhotoPage.imagePath.sendKeys("C:/Users/NIZAMIYE HOSPITAL/OneDrive/Documents/printout.pdf");
            userPhotoPage.uploadButton.submit();

            String toastMessageTex = userPhotoPage.toastMessage2.getText();
            Assert.assertEquals("Please select only jpg/png file.",toastMessageTex);

            Thread.sleep(3000);

    }
}
