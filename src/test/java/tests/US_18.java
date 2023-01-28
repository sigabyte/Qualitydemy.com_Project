package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CourcesListPage;
import pages.NumberCoursesPage;
import pages.ThreeDotsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_18 {
    CourcesListPage qualty=new CourcesListPage();
    NumberCoursesPage qualtyy= new NumberCoursesPage();
    ThreeDotsPage qualtye=new ThreeDotsPage();



    @Test
    public void Test01() {
        //anasayfaya git
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
        //number of cources linkine tiklayin
        qualtyy.numberOfCources.click();
       // Assert.assertTrue(qualty.courseTitleCourse.isDisplayed());
        //pending cources e tiklayin
        qualty.pendingCources.click();
        // Requested withdrawal butonuna tiklayin
        //qualty.requestedWithdrawal.click();


        //filitre butonuna tiklayin
        qualty.filtreButonu.click();
        //course list gorunurlugunu dogrulayin
        Assert.assertTrue(qualty.courcesList.isDisplayed());

        //cources manager e geri gelin
        qualty.courseManager.click();

        //three dots u tiklayin
        qualtye.threeDots.click();
        //go to View course on frontend link
        qualtye.frontendLink.click();
        //3 saniye bekle
        ReusableMethods.waitFor(3);
        //cources sayfasina geri don
        ReusableMethods.switchToWindow("Courses");
        //three dots u tiklayin
        qualtye.threeDots.click();
        //click Go to course playing page link
        qualtye.gotoCoursePlayingPageLink.click();
        //cources sayfasina geri don
        ReusableMethods.switchToWindow("Courses");
        //three dots u tiklayin
        qualtye.threeDots.click();
        // click on the Edit this course link
        qualtye.editThisCourseLinki.click();
        //backToCourseListButton tikla
        qualtye.backToCourseListButton.click();
        //cources sayfasina geri don
        // ReusibleMethods.switchToWindow("Courses");
        //three dots u tiklayin
        qualtye.threeDots.click();
        //click  the Section and lesson link
        qualtye.sectionAndLessonLink.click();
        //cources sayfasina geri don
        ReusableMethods.switchToWindow("Courses");
        //three dots u tiklayin
        // qualty.threeDots.click();
    }
}
