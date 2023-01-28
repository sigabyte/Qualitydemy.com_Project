package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_10 {

    MyCoursesPage mycourses = new MyCoursesPage();
    Actions actions=new Actions(Driver.getDriver());
    CoursesDetailsPage course=new CoursesDetailsPage();
    HomePage homePage=new HomePage();
    StartLessonPage start=new StartLessonPage();

    @BeforeClass
    public void mycoursesagit() {
        HomePage.login();
        ReusableMethods.waitFor(10);
        homePage.myCoursesLinki.click();
    }
    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void TC_01() {
        int ilk= mycourses.sayfadakiKurslarListesi.size();
        mycourses.sayfadakiIlkKursLinki.click();
        String kursIsmi = course.courseH1Title.getText();
        Driver.getDriver().navigate().back();
        mycourses.seacrMycoursesBox.sendKeys(kursIsmi+Keys.ENTER);
        int iki= mycourses.sayfadakiKurslarListesi.size();
        mycourses.resetlinki.click();
        int uc=mycourses.sayfadakiKurslarListesi.size();
        Assert.assertTrue(ilk!=iki);
        Assert.assertTrue(ilk==uc);
    }

    @Test
    public void TC_02() {
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.sayfadakiIlkKursLinki);
        String kursIsmi = course.courseH1Title.getText();
        Driver.getDriver().navigate().back();
        mycourses.seacrMycoursesBox.click();
        mycourses.seacrMycoursesBox.sendKeys(kursIsmi + Keys.ENTER);
        ReusableMethods.waitFor(4);
        Assert.assertTrue(mycourses.sayfadakiIlkKursLinki.isDisplayed());
    }

    @Test
    public void TC_03() {
        mycourses.categoriesDropDown.click();
        Assert.assertTrue(mycourses.dropDownItems.isDisplayed());
        Assert.assertTrue(mycourses.dropDownItems.isEnabled());
    }


    @Test
    public void TC_04_05() {
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.editRatingLinki1);
        Assert.assertTrue(mycourses.scoreScreen.isDisplayed());
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.cancel1);
        Assert.assertFalse(mycourses.scoreScreen.isDisplayed());
    }

    @Test
    public void TC_06() {
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.editRatingLinki1);
        mycourses.selectScoreRange.click();
        mycourses.option3.click();
        mycourses.option5.click();
        Assert.assertTrue(mycourses.option3.isEnabled());
        Assert.assertTrue(mycourses.option5.isEnabled());
        Driver.quitDriver();
    }

    @Test
    public void TC_07() {
        String mesaj = "merhaba";
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.editRatingLinki1);
        mycourses.messageBox.clear();
        mycourses.messageBox.sendKeys(mesaj);
        String yazi = mycourses.messageBox.getText();
        Assert.assertEquals(mesaj, yazi);
    }

    @Test
    public void TC_08() {
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.editRatingLinki1);
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.selectScoreRange);
        //mycourses.selectScoreRange.click();
        Select select = new Select(mycourses.selectScoreRange);
        select.selectByValue("1");
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.publishRatingButton);
        ReusableMethods.waitFor(5);
        int yildizlar1=mycourses.sayfadakiRatingYildizlarListesi.size();
        System.out.println(yildizlar1);
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.editRatingLinki1);
        mycourses.selectScoreRange.click();
        select.selectByValue("3");
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.publishRatingButton);
        ReusableMethods.waitFor(5);
        int yildizlar2=mycourses.sayfadakiRatingYildizlarListesi.size();
        System.out.println(yildizlar2);
        Assert.assertEquals(yildizlar2 - yildizlar1, 2);
        Driver.quitDriver();
    }

    @Test
    public void TC_09() {
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.sayfadakiIlkKursLinki);
        String kursIsmi = course.courseH1Title.getText();
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(Driver.getDriver(),mycourses.startLessonLink);
        String isim=start.dersIsmiBasligi.getText();
        Assert.assertTrue(isim.contains(kursIsmi));
    }
}
