package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CourcesListPage;
import pages.NumberCoursesPage;
import pages.ThreeDotsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_19 {

    CourcesListPage qualty=new CourcesListPage();
    NumberCoursesPage qualtyy= new NumberCoursesPage();
    ThreeDotsPage qualtye=new ThreeDotsPage();


    @Test
    public void test02(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //cookies i kabul et
        qualty.cookies.click();
        //login linkine tiklayin
        qualty.loginLinki.click();
        //email i girin
        qualty.emailLinki.sendKeys(ConfigReader.getProperty("userEmail"));
        //passwordu girin
        qualty.passwordLinki.sendKeys(ConfigReader.getProperty("userPassword"));
        //login butonuna basin
        qualty.loginButonu.click();
        //instroctur a tiklayin
        qualty.instroctur.click();
        //corse manager e gelin
        qualty.courseManager.click();
        // click  the  Mark as drafted link
        //three dots u tiklayin
        qualtye.threeDots.click();
        qualtye.markAsDraftedLinki.click();
        ReusableMethods.waitFor(2);
        //cources sayfasina geri don
        ReusableMethods.switchToWindow("Courses");
        ReusableMethods.waitFor(2);
        //three dots u tiklayin
        qualtye.threeDots.click();
        //click Publish this course link And test that this section is not
        ReusableMethods.waitFor(2);

        //click on the delete link
        qualtye.deleteLinki.click();
        //and click the Cancel button
        qualtye.cancelButonu.click();
        //cources sayfasina geri don
        ReusableMethods.switchToWindow("Courses");

        //click the  +Add new course
        qualtye.addNewCourse.click();

        //addNewCoursePageTitlenin gorunur oldugunu test et
       // Assert.assertTrue(qualty.addNewCoursePageTitle.isDisplayed());
    }
}
