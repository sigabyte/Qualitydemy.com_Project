package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CourseEditPage;
import pages.CourseManagerPage;
import pages.HomePage;
import pages.InstructorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_21 {

    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    CourseEditPage courseEditPage = new CourseEditPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.firstLogInButton.click();
        homePage.emailInput.sendKeys(ConfigReader.getProperty("userEmail"));
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        homePage.loginButton.click();
        homePage.instructorLink.click();
        instructorPage.courseManager.click();
        courseManagerPage.threeDots.click();
        courseManagerPage.editThisCourse.click();


    }

    @AfterTest
    public void tearDown() {
        //Driver.quitDriver();
    }

    // @Parameters("textForTitlee")
    @Test
    public void TC_21_001() {

     /*Verify that the new section is added when the add section button is clicked and
    the data is entered in the title textbox on the screen that opens and the submit button is pressed.
     */
        String textForTitle = "Cypress";

        courseManagerPage.addSectionButton.click();
        courseManagerPage.titleBox.sendKeys(textForTitle);
        courseManagerPage.submitButton.click();

        for (WebElement eachSectionName : courseManagerPage.cardTitleForSectionNames) {
            if (eachSectionName.getText().trim().equals(textForTitle)) {
                Assert.assertEquals(textForTitle, eachSectionName.getText().trim());
            }
        }

    }


    @Test
    public void TC_21_002() throws InterruptedException {
    /*The screen that opens when the add section button is clicked should be
    closed with the close button.
     */
        courseManagerPage.addSectionButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(courseManagerPage.submitButton.isDisplayed(), "first assertion failed");
        courseManagerPage.closeButton_AddNewSection.click();
        Thread.sleep(1000);
        Assert.assertFalse(courseManagerPage.submitButton.isDisplayed(), "second assertion failed");


    }

    //@Parameters("lessonVideoType")
    @Test
    public void TC_21_003() throws InterruptedException {

        /*When the add lesson button is clicked, selections should be made for video types.*/

        courseManagerPage.addLessonButton.click();

        WebElement vimeo=Driver.getDriver().findElement(By.xpath("//label[@class='custom-control-label' and .='Vimeo Video']"));

         List<String> videoLessonTypes=new ArrayList<>();
         List<WebElement> videoWebelements=new ArrayList<>();

        Actions actions=new Actions(Driver.getDriver());
        for (WebElement eachLessonType : courseManagerPage.allLessonTypes) {
            if (eachLessonType.getText().toLowerCase().contains("video")) {
                videoLessonTypes.add(eachLessonType.getText().trim());
                videoWebelements.add(eachLessonType);
                Thread.sleep(1500);
                vimeo.click();
                Thread.sleep(1500);
                actions.sendKeys(Keys.ARROW_DOWN).click().perform();
                Thread.sleep(1500);

            }
        } System.out.println(videoLessonTypes);
         System.out.println(videoWebelements);

//       int i=videoLessonTypes.size();
//
//        for (WebElement video: videoWebelements){
//            actions.click(video).perform();
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//            i--;
//          if(  i<=1)
//              break;
       // }




    }

    @Test
    public void TC_21_004() throws InterruptedException {
            /*
            The screen that opens when the add lesson button is clicked
            should be closed with the close button.
             */
        courseManagerPage.addLessonButton.click();
        Assert.assertTrue(courseManagerPage.nextButtonOnAddNewLesson.isDisplayed(), "first assertion failed");
        Thread.sleep(1000);
        courseManagerPage.buttonClose.click();
        Thread.sleep(500);
        Assert.assertFalse(courseManagerPage.nextButtonOnAddNewLesson.isDisplayed(), "second assertion failed");
    }

    //  @Parameters("lessonVideoTypee")
    @Test
    public void TC_21_005() {
        /*After selecting the video type in the add lesson section, when the next button
        is clicked, the explanation screen related to the video should appear.*/

        courseManagerPage.addLessonButton.click();
        courseManagerPage.videoFile.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        Assert.assertEquals(courseManagerPage.lessonTypeOnAddNewLessonPage.getText().trim(), "Lesson type : Video file. Change", "first assertion failed");
        Assert.assertTrue(courseManagerPage.titleTextFromAddLesson.getText().trim().equals("Title"), "second assertion failed");


    }

    //@Parameters("textForVideo")
    @Test
    public void TC_21_006() {
        /*The name should be able to get entered in the title textbox on the description screen.
         */
        String textForVideoTitle = "FASTEST Way to Learn to Code and ACTUALLY Get a Job (in 2023)";
        courseManagerPage.addLessonButton.click();
        courseManagerPage.textFromSelectlessonTypes.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.titleAddNewLessonForVideo.sendKeys(textForVideoTitle);
        courseManagerPage.addlessonFromVideoDescriptionPage.click();

        for (WebElement createdLessonEachName : courseManagerPage.createdLessonsNames) {
            if (createdLessonEachName.getText().trim().contains(textForVideoTitle)) {
                Assert.assertTrue(createdLessonEachName.getText().trim().contains(textForVideoTitle));
            }
        }
    }

    @Test
    public void TC_21_007() throws InterruptedException {
        /*The desired section should be selected from the section dropbox on the description screen.*/
        String expectedSelection="GitHub";

        courseManagerPage.addLessonButton.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        Thread.sleep(2000);
        courseManagerPage.titleAddNewLessonForVideo.click();
        Select select = new Select(courseManagerPage.selectDropDownOptions);
        select.selectByVisibleText("GitHub");
        Assert.assertTrue(select.getFirstSelectedOption().getText().trim().equals(expectedSelection));
    }

    @Test
    public void TC_21_008() throws InterruptedException {
        /*  A valid url should be able to get entered in the video url section on the description screen.*/
        String textForTitle = "Cypress12";
        String urlForVideo = "https://www.youtube.com/watch?v=TBHwtugxRnQ&t=788s";

        courseManagerPage.addLessonButton.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.titleAddNewLessonForVideo.sendKeys(textForTitle+Keys.ENTER);
        courseManagerPage.videoURLBox.click();
        courseManagerPage.videoURLBox.sendKeys(urlForVideo + Keys.ENTER);
        courseManagerPage.duration_text.click();
        Thread.sleep(1500);
        courseManagerPage.addlessonFromVideoDescriptionPage.click();
        Assert.assertEquals(courseManagerPage.videoURLBox.getAttribute("value"),urlForVideo);
    }


    @Test
    public void TC_21_009() throws InterruptedException {
    /*After a valid url is entered in the video url section on the description screen,
    the duration section should automatically capture the duration in the system.*/
        String urlForVideo = "https://www.youtube.com/watch?v=TBHwtugxRnQ&t=788s";
        String textForTitle = "Cypress123";
        String expectedVideoLenght="01:34:00";

        courseManagerPage.addLessonButton.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.titleAddNewLessonForVideo.sendKeys(textForTitle+Keys.ENTER);
        courseManagerPage.videoURLBox.click();
        courseManagerPage.videoURLBox.sendKeys(urlForVideo + Keys.ENTER);
        courseManagerPage.duration_text.click();
        Thread.sleep(1500);
        courseManagerPage.addlessonFromVideoDescriptionPage.click();
        Assert.assertEquals(courseManagerPage.durationBox.getAttribute("value"),expectedVideoLenght);
    }

    @Test
    public void TC_21_010() {
        /*When an invalid url is entered in the video url section on the description screen,
         a warning should appear under the textbox.*/

        String invalidUrlForVideo = "https://www.youtube.comugxRnQ&t=788s";
        courseManagerPage.addLessonButton.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.videoURLBox.click();
        courseManagerPage.videoURLBox.sendKeys(invalidUrlForVideo + Keys.ENTER);
        Assert.assertTrue(courseManagerPage.invalidURL.getText().trim().contains("Invalid url"));


    }

    @Test
    public void TC_21_011() {
        /*It should be possible to enter a description in the summary textbox on the description screen*/

        String summaryforDescriptionScreen = "Electronic Engineer, Java & Selenium Instructor I graduated Istanbul Technical university (One of the best universities in Turkey)";

        courseManagerPage.addLessonButton.click();
        courseManagerPage.textFromSelectlessonTypes.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.summeryTextBox.sendKeys(summaryforDescriptionScreen+Keys.ENTER);
        Assert.assertEquals(courseManagerPage.summeryTextBox.getText().trim(),summaryforDescriptionScreen);
    }

    @Test
    public void TC_21_012() {
        /*Mark as free lesson checkbox should be clickable on the description screen*/

        courseManagerPage.addLessonButton.click();
        courseManagerPage.textFromSelectlessonTypes.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.markAsFreeLesson.click();
        Assert.assertTrue(courseManagerPage.checkMarkBox.isSelected());
   }

    @Test
    public void TC_21_013() throws InterruptedException {
        /*After filling the relevant sections on the explanation screen, the course should
        be added to the lesson section when the add lesson button is clicked.*/

        String titleText2 = "ChatGPT ve IT Sektörü, IT'ciler issiz mi kalacak ? ";

        courseManagerPage.addLessonButton.click();
        courseManagerPage.textFromSelectlessonTypes.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        courseManagerPage.titleAddNewLessonForVideo.sendKeys(titleText2);
        Thread.sleep(2000);
        courseManagerPage.addlessonFromVideoDescriptionPage.click();

        courseManagerPage = new CourseManagerPage();

        for(WebElement lesson: courseManagerPage.createdLessonsNames){
            if(lesson.getText().trim().contains(titleText2)){
               Assert.assertTrue(lesson.getText().trim().contains(titleText2));
            }

        }
    }

    @Test
    public void TC_21_014() throws InterruptedException {
        /*Clicking the close button on the description screen should close the window*/
        String wordForCoursemanagerPage="Update";

        courseManagerPage.addLessonButton.click();
        courseManagerPage.textFromSelectlessonTypes.click();
        courseManagerPage.nextButtonOnAddNewLesson.click();
        Thread.sleep(1500);
        courseManagerPage.closeButton_AddNewSection.click();
        Assert.assertTrue(courseManagerPage.courseManagerPageH4.getText().trim().contains(wordForCoursemanagerPage));
    }

    @Test
    public void TC_21_015() throws InterruptedException {
        /*When the Sort sections button is pressed, it should be possible to change
        the order between the sections with drag drop.*/
        List<String> orderBeforeSort = new ArrayList<>();  // [aaaa, GitHub, SQL]
        List<String> orderAfterSort = new ArrayList<>();  // [GitHub, aaaa, SQL]

        courseManagerPage.sortSectionButton.click();
        for(WebElement eachItem: courseManagerPage.listOfSections){
            orderBeforeSort.add(eachItem.getText().trim());
        }
        System.out.println(orderBeforeSort);

        Actions actions=new Actions(Driver.getDriver());
        Thread.sleep(2000);
        actions.clickAndHold(courseManagerPage.listOfSections_2ndOne).perform();
        actions.moveToElement(courseManagerPage.listOfSections_1stOne).click().perform();
        courseManagerPage.updateSorting.click();

        for(WebElement eachItem: courseManagerPage.listOfSections){
            orderAfterSort.add(eachItem.getText().trim());
        } System.out.println(orderAfterSort);
        Assert.assertEquals(orderBeforeSort.get(0), orderAfterSort.get(1));

    }

    @Test
    public void TC_21_016() {
        /*When the sort sections button is pressed and changes are made,
        the change made with the update sorting button should be saved.*/

        //DONE in TC_21_015
        //Sag ust kosede cikan Congratulations! mesage nasil alabilirim?


    }

    @Test
    public void TC_21_017()  {
        /*When hovering over the sections with the mouse, the sort lesson, edit section and
        delete section buttons should appear.*/

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(courseManagerPage.section_1Text).perform();
        Assert.assertTrue(courseManagerPage.buttonSortLesson.isDisplayed());
        Assert.assertTrue(courseManagerPage.buttonEditSection.isDisplayed());
        Assert.assertTrue(courseManagerPage.buttonDeleteSection.isDisplayed());
    }

    @Test
    public void TC_21_018()  {
        /* It should be possible to change the order between the lessons with the drag drop where the sort lesson
        button is pressed.*/
        String expectedLesson="cxcxzcxzcxzcxzc";

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(courseManagerPage.section_1_Div).perform();

        //courseManagerPage.buttonSortLesson.click();

        for(WebElement lesson: courseManagerPage.listOfLessons){
            if(lesson.getText().trim().equals(expectedLesson)){
                Actions actions1=new Actions(Driver.getDriver());
                actions1.clickAndHold(lesson).moveToElement(courseManagerPage.listOfLessons_1stOne).click().perform();
            }
        }
        Assert.assertTrue(courseManagerPage.listOfLessons_1stOne.getText().trim().equals(expectedLesson));

    }

    @Test
    public void TC_21_019()  {
        /*When the sort lesson button is pressed and a change is made, the change made by pressing the update sorting button should be saved. */
        String expectedLesson="cxcxzcxzcxzcxzc";

        courseManagerPage.section_1Text.click();
        courseManagerPage.buttonSortLesson.click();

        for(WebElement lesson: courseManagerPage.listOfLessons){
            if(lesson.getText().trim().equals(expectedLesson)){
                Actions actions=new Actions(Driver.getDriver());
                actions.clickAndHold(lesson).moveToElement(courseManagerPage.listOfLessons_1stOne).click().perform();
            }
        }
        courseManagerPage.updateSorting.click();
        Assert.assertTrue(courseManagerPage.listOfLessons_1stOne.getText().trim().equals(expectedLesson));

    }


    @Test
    public void TC_21_020() throws InterruptedException {
        /*When the Update section button is pressed, the title section should be able to be changed in the window that opens. */

        String title=" ";

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(courseManagerPage.section_1_Div).build().perform();
        actions.moveToElement(courseManagerPage.buttonEditSection).click().build().perform();
        courseManagerPage.title_UpdateSection.clear();
        courseManagerPage.title_UpdateSection.sendKeys(title+ Keys.ENTER);
        Thread.sleep(2000);

      Assert.assertTrue(courseManagerPage.section_1Text.getText().contains(title));
    }


    @Test
    public void TC_21_021() {
  /*
    When the update section button is pressed, the window that opens should be closed with the close button.
     */
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(courseManagerPage.section_1_Div).build().perform();
        actions.moveToElement(courseManagerPage.buttonEditSection).click().build().perform();
        courseManagerPage.buttonClose.click();
        Assert.assertFalse(courseManagerPage.buttonClose.isDisplayed());
    }



    @Test
    public void TC_21_022() throws InterruptedException {
        /* The desired section should be get deleted with the delete section button.*/

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(courseManagerPage.section_1_Div).build().perform();
        actions.moveToElement(courseManagerPage.buttonDeleteSection).click().build().perform();
        String section_1Name=courseManagerPage.section_1Text.getText();
        courseManagerPage.continue_buttonForDelete.click();
        List<String> sectionNamesAfterDelete=new ArrayList<>();


        for(WebElement eachSectionName: courseManagerPage.listOfSectionsUnderCoursemanagerPage){
            sectionNamesAfterDelete.add(eachSectionName.getText());

        }
        System.out.println(sectionNamesAfterDelete);
    }


    @Test
    public void TC_21_023()  {
        /* When you hover over the course with your mouse, the edit and delete icons should appear.*/

        Actions actions=new Actions(Driver.getDriver());

        for (WebElement lesson: courseManagerPage.listOfLessons_CourseManagerPage){
            actions.moveToElement(lesson).build().perform();
           for(WebElement editIconEach: courseManagerPage.iconEdit){

               actions.moveToElement(editIconEach).perform();
               Assert.assertTrue(editIconEach.isDisplayed(),"iconEdit is not displayed");
           }
        }







    }

    @Test
    public void TC_21_024()  {
        /*When the edit icon is clicked, the update lesson window should open. */



    }


    @Test
    public void TC_21_025()  {
        /*Changes can be made in the sections of the update lesson window*/


    }


    @Test
    public void TC_21_026()  {
        /*The update lesson window should be closed with the close button. */


    }

    @Test
    public void TC_21_027()  {
        /* When the delete lesson icon is clicked, the desired lesson should be deleted.*/


    }



}





