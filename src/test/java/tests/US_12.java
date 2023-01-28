package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_12 {
    Actions actions = new Actions(Driver.getDriver());
    HomePage homePage = new HomePage();
    CoursesDetailsPage course = new CoursesDetailsPage();
    WishlistPage wish = new WishlistPage();
    CompareCoursePage compare = new CompareCoursePage();
    AllCourseAllCategoryPage allcourses = new AllCourseAllCategoryPage();
    ShoppingCartPage shop = new ShoppingCartPage();

    @BeforeClass
    public void login() {
        HomePage.login();
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void TC_01() {
        ReusableMethods.waitFor(8);
        actions.clickAndHold(homePage.wishListKalp).perform();
        homePage.gotoWishListLinki.click();
        String kursAdi = wish.ikincikursAdi.getText();
        ReusableMethods.clickWithJS(Driver.getDriver(), wish.compareButton.get(0));
        compare.selectaCourse.click();
        compare.searchBox.sendKeys(kursAdi);
        String arananKursAdi = compare.aratilanKurs.getText();
        Assert.assertTrue(arananKursAdi.contains(kursAdi));

        //CourseDetailePage compare button testi
        actions.moveToElement(homePage.category).moveToElement(homePage.allCourseCategory).click().perform();
        allcourses.sayfadakiILkKurs.click();
        course.compareCourseButton.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Compare"));

        //AllCoursesAllCategoriesPage compare button testi
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        allcourses.compareButton.click(); //burada BUG var clik yapilamiyor locator aldim
        // isenabled ile test ettigimde testi gecti ancak
        //manuel olarak clik yapilamadigi icin click yaptiktan sonra
        // compare sayfasinin title inin Compare icerip icermedigini test ettim
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Compare"));

    }

    @Test
    public void TC_02(){
        actions.moveToElement(homePage.category).moveToElement(homePage.allCourseCategory).click().perform();
        ReusableMethods.clickWithJS(Driver.getDriver(),allcourses.freeRadioButton);

        try {
            Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            try {
                ReusableMethods.clickWithJS(Driver.getDriver(),allcourses.nextPageButton);
                Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
            } catch (Exception ex) {
                try {
                    ReusableMethods.clickWithJS(Driver.getDriver(),allcourses.nextPageButton);
                    Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
                } catch (Exception exc) {
                    ReusableMethods.clickWithJS(Driver.getDriver(),allcourses.nextPageButton);
                    Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
                }
            }
        }
        String course1=course.courseH1Title.getText();
        System.out.println(course1);
        String [] arr=course1.split(" ");
        String courseName=arr[1];
        System.out.println(courseName);
        course.getEnrolledButton.click();
        ReusableMethods.waitFor(2);
        String pageTitle=Driver.getDriver().getTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains(courseName));
    }

    @Test
    public void TC_03() {
        ReusableMethods.waitFor(8);
        actions.clickAndHold(homePage.wishListKalp).perform();
        homePage.gotoWishListLinki.click();
        ReusableMethods.clickWithJS(Driver.getDriver(), wish.compareButton.get(0));
        String course1 = compare.ilkKutu.getText();
        String[] arr = course1.split(" ");
        String courseName = arr[1];
        ReusableMethods.clickWithJS(Driver.getDriver(), compare.learMoreLink);
        String pageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(pageTitle.contains(courseName));
    }

    @Test
    public void TC_04() {
        actions.moveToElement(homePage.category).moveToElement(homePage.allCourseCategory).click().perform();
        ReusableMethods.clickWithJS(Driver.getDriver(), allcourses.paidRadioButton);

        try {
            Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            ReusableMethods.clickWithJS(Driver.getDriver(), allcourses.nextPageButton);
            Driver.getDriver().findElement(By.xpath(AllCourseAllCategoryPage.getLocator())).sendKeys(Keys.ENTER);
        }
        course.buyNowButonu.click();
        Assert.assertTrue(shop.checkoutButton.isDisplayed());
    }
}
