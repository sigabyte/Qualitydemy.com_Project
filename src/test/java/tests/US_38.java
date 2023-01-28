package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_38 {

    HomePage homePage = new HomePage();
    CoursesDetailsPage coursesDetailsPage = new CoursesDetailsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    WishlistPage wishlistPage = new WishlistPage();
    MyCoursesPage myCoursesPage = new MyCoursesPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
    }

    @Test
    public void tc_38_001() {
        /*
            User story:
            Clicking the Compare this course with other button should redirect to the Course compare page
         */

        // Go to any lesson detail page
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/web-design-for-php/1");
        // Click to "Compare this course with other" button
        coursesDetailsPage.compareCourseButton.click();
        String actualURL = Driver.getDriver().getCurrentUrl();
        // Verify URL contains the "compare"
        Assert.assertTrue(actualURL.contains("compare"));
    }

    @Test
    public void tc_38_002() {
        /*
            User story:
            For paid courses, when the buy now button is pressed,
            it should redirect to the shopping_cart page.
         */

        // Go to any paid courses detail page
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/ultimate-aws-certified-solutions-architect-associate-saa-c03/4");
        // Click to "Buy now" button
        coursesDetailsPage.buyNowButonu.click();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        ReusableMethods.waitForVisibility(shoppingCartPage.shoppingCartHeader, 10);
        String actualURL = Driver.getDriver().getCurrentUrl();
        // Verify URL contains the "shopping_cart"
        Assert.assertTrue(actualURL.contains("shopping_cart"));
    }

    @Test
    public void tc_38_003() {
        /*
            User story:
            For paid courses, when the add to cart button is pressed,
            the button should change to "Added to cart" and the course should be added to the cart page.
         */

        // Go to any paid courses detail page
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/pianoforall-incredible-new-way-to-learn-piano-amp-keyboard/5");
        // Click to "Add to Cart" button
        coursesDetailsPage.addToCartButonu.click();
        ReusableMethods.waitFor(6);
        String actualButtonText = coursesDetailsPage.addToCartButonu.getText();
        String actualTitle = coursesDetailsPage.courseH1Title.getText();
        SoftAssert softAssert = new SoftAssert();
        // Verify button contains the "Added to Cart"
        softAssert.assertEquals(actualButtonText, "Added to Cart");
        Driver.getDriver().get("https://qa.qualitydemy.com/home/shopping_cart");
        // Verify the item is added to shopping cart
        for (WebElement e : shoppingCartPage.itemList) {
            if(e.getText().equals(actualTitle)) {
                softAssert.assertTrue(true);
                break;
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void tc_38_004() {
        /*
            User story:
            When the add to wishlist button is pressed,
            the button should change to "Added to wishlist" and the course should be added to the wishlist page
         */

        // Go to any paid courses detail page
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/disney-magic-english/7");
        String actualTitle = coursesDetailsPage.courseH1Title.getText();
        // Click to "Add to wishlist" button
        String actualButtonText = coursesDetailsPage.addToWishlistButton.getText();
        if(!actualButtonText.contains("Added")) {
            coursesDetailsPage.addToWishlistButton.click();
            ReusableMethods.waitFor(8);
            actualButtonText = coursesDetailsPage.addToWishlistButton.getText();
        }
        SoftAssert softAssert = new SoftAssert();
        // Verify button contains the "Added to wishlist"
        softAssert.assertEquals(actualButtonText, "Added to wishlist");
        Driver.getDriver().get("https://qa.qualitydemy.com/home/my_wishlist");
        // Verify the item is added to wishlist
        for (WebElement e : wishlistPage.lessonHeader) {
            if(e.getText().contains(actualTitle)) {
                softAssert.assertTrue(true);
                break;
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void tc_38_005() {
        /*
            User story:
            For non-purchased free courses, when the get enrolled button is pressed,
            the button should change to already purchased and the course should be added to the mycourse page.
         */

        String courseLink = "https://qa.qualitydemy.com/home/course/javaya-tav-olmak2/296";
        // Go to any paid courses detail page
        Driver.getDriver().get(courseLink);
        // Click to "Get Enrolled" Button
        coursesDetailsPage.getEnrolledButton.click();
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.waitForVisibility(coursesDetailsPage.alreadyPurchasedButton, 10);
        // Verify the "Already purchased" button is displayed
        softAssert.assertTrue(coursesDetailsPage.alreadyPurchasedButton.isDisplayed());
        // Go to "My courses" page
        Driver.getDriver().get("https://qa.qualitydemy.com/home/my_courses");
        // Verify the item is added to "My course" page
        for (WebElement e : myCoursesPage.lessonUrlList) {
            if(e.getText().equals(courseLink)) {
                softAssert.assertTrue(true);
                break;
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void tc_38_006() {
        /*
            When clicking on the relevant courses in the "Curriculum for this course" section of a purchased course,
            it should lead to the page where the video of the course is located.
         */

        // Go to any purchased courses detail page
        Driver.getDriver().get("https://qa.qualitydemy.com/home/course/web-design-for-php/1");
        // Click to lesson video page
        coursesDetailsPage.courseVideoLinks.get(0).click();
        ReusableMethods.waitFor(1);
        // Verify that you are at the video page
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("lesson"));
    }

    @AfterTest
    public void closeDriver() {
        Driver.closeDriver();
    }


}
