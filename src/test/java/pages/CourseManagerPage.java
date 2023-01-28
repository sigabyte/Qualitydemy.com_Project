package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CourseManagerPage {


    //Course Manager

    public CourseManagerPage() {PageFactory.initElements(Driver.getDriver(),this);
    }


    //Course List

    @FindBy(tagName = "strong")
    public WebElement courseListTitle;


    //Requirements Section

    @FindBy(xpath = "//a[@href='#requirements']")
    public WebElement requirementsSection;

    @FindBy(xpath = "(//input[@id='requirements'])[1]")
    public WebElement requirementsFirstTextBox;

    @FindBy(xpath = "(//input[@id='requirements'])[3]")
    public WebElement requirementsSecondTextBox;

    @FindBy(xpath = "//button[@onclick='appendRequirement()']")
    public WebElement requirementsAppendButton;

    @FindBy(xpath = "(//button[@onclick='removeRequirement(this)'])[2]")
    public WebElement requirementsRemoveButton;


    //Outcomes Section

    @FindBy(xpath = "//a[@href='#outcomes']")
    public WebElement outcomesSection;

    @FindBy(xpath = "(//input[@name='outcomes[]'])[1]")
    public WebElement outcomesFirstTextBox;

    @FindBy(xpath = "//button[@onclick='appendOutcome()']")
    public WebElement outcomesAppendButton;

    @FindBy(xpath = "(//input[@name='outcomes[]'])[3]")
    public WebElement outcomesSecondTextBox;

    @FindBy(xpath = "(//button[@onclick='removeOutcome(this)'])[1]")
    public WebElement outcomesRemoveButton;


    //Pricing Section

    @FindBy(xpath = "//a[@href='#pricing']")
    public WebElement pricingSection;

    @FindBy(id = "price")
    public WebElement pricingCoursePriceTextbox;

    @FindBy(xpath = "//label[@for='is_free_course']")
    public WebElement pricingFreeCourseCheckbox;

    @FindBy(xpath = "//label[@for='discount_flag']")
    public WebElement pricingDiscountCheckbox;

    @FindBy(id = "discounted_price")
    public WebElement pricingDiscountPriceTextbox;

    //Media Section
    @FindBy(id = "discount_flag")
    public WebElement pricingDiscountCheckboxText;

    @FindBy(xpath = "(//b[@role='presentation'])[4]")
    public WebElement mediaDropdownElement;

    @FindBy(xpath = "//*[@role='treeitem']")
    public List<WebElement> mediaDropdownSelect;

    @FindBy(xpath = "//span[@title='Vimeo']")
    public WebElement mediaCourseOverviewProviderBox;

    @FindBy(id = "course_overview_url")
    public WebElement mediaCourseOverviewUrlTextbox;

    @FindBy(xpath = "//label[@for='course_thumbnail']")
    public WebElement mediaCourseThumbnail;

    @FindBy(xpath = "//input[@class='image-upload']")
    public WebElement mediaUploadImage;

    //Seo Section

    @FindBy(xpath = "//input[@size='43']")
    public WebElement seoMetaWords;

    @FindBy(id = "meta_keywords")
    public WebElement seoInputMetaWords;

    @FindBy(name = "meta_description")
    public WebElement seoMetaDescription;

    //Finish Section
    @FindBy(xpath = "//button[@onclick='checkRequiredFields()']")
    public WebElement finishSubmitButton;

    @FindBy(xpath = "//h2[@class='jq-toast-heading']")
    public WebElement finishCongrulationsElement;







    //=========================================================

    @FindBy(xpath = "//a[@class='btn btn-outline-primary btn-rounded alignToTitle']")
    public WebElement addNewCourseButton;

    @FindBy(css = "button.btn.btn-sm")
    public WebElement threeDots;

    @FindBy(xpath = "//a[text()='Edit this course']")
    public WebElement editThisCourse;

    @FindBy(xpath = "//h4[@class='page-title']")
    public WebElement courseManagerPageH4;

    @FindBy(linkText = "Example Course")
    public WebElement exampleCourseLink;

    @FindBy(linkText = "Basic")
    public WebElement basicButton;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--multiple']")
    public WebElement addNewInstructorTextbox;

    @FindBy(xpath = "//input[@placeholder='Enter course title']")
    public WebElement courseTitleTextInput;

    @FindBy(xpath = "//a[.=' Add section']")
    public WebElement addSectionButton;

    @FindBy(xpath = "//input[@class='form-control' and  @id='title']")
    public WebElement titleBox;

    @FindBy(xpath = "//button[@name='button' and .='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[@name='button' and .='Submit']")
    public List<WebElement> cardTitleForSectionNames;

    @FindBy(xpath = "//div[@class='modal-footer']//button[.='Close']")
    public WebElement closeButton_AddNewSection;

    @FindBy(xpath = "//a[.=' Add lesson']")
    public WebElement addLessonButton;

    @FindBy(xpath = "//div[@class='custom-control custom-radio']")
    public List<WebElement> allLessonTypes;

    @FindBy(id = "lesson-add-modal")
    public WebElement nextButtonOnAddNewLesson;
    
    @FindBy(xpath = "//div[@class='form-group']//input[@name='title']")
    public WebElement titleAddNewLessonForVideo;

    @FindBy (xpath = "//button[text()='Close']")  //2nd one for '+Add section' close button
    public WebElement buttonClose;

    @FindBy(xpath = "//label[@for='youtube']")
    public WebElement youtube;

    @FindBy(xpath = "//label[@for='video_file']")
    public WebElement videoFile;

    @FindBy(xpath = "//div[@class='form-group']//label[.='Title']")
    public WebElement titleTextFromAddLesson;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement lessonTypeOnAddNewLessonPage;

    @FindBy(xpath = "//div//button[@type='submit']")
    public WebElement addlessonFromVideoDescriptionPage;

    @FindBy(xpath = "//label[@class='custom-control-label' and .='Text']")
    public WebElement textFromSelectlessonTypes;

    @FindBy(xpath = "//div[@class='col-md-12']")
    public List<WebElement> createdLessonsNames;

    @FindBy(xpath= "//span[@id='select2-section_id-gz-container']")
    public WebElement sectionDropDown;

    @FindBy(css = "[name='section_id']")
    public WebElement selectDropDownOptions;

    @FindBy(xpath = "//input[@id='video_url']")
    public WebElement videoURLBox;

    @FindBy(xpath = "//input[@id='duration']")
    public WebElement durationBox;

    @FindBy(xpath = "//label[@id='invalid_url']")
    public WebElement invalidURL ;

    @FindBy(xpath = "(//div[@class='note-editor note-frame card']//div[@class='note-editable card-block' and@role='textbox'])[3]")
    public WebElement summeryTextBox;

    @FindBy(xpath = "//label[.='Mark as free lesson']")
    public WebElement markAsFreeLesson;

    @FindBy(xpath = "//a[.=' Sort sections']")
    public WebElement sortSectionButton;

    @FindBy(xpath = "//div[@id='widgets-of-section-513']//button[.=' Delete section']")
    public WebElement buttonDeleteSection;

    @FindBy(xpath = "//input[@type='checkbox' and @id='free_lesson' and @value='1']")
    public WebElement checkMarkBox;

    @FindBy(xpath = "(//div[@class='card bg-light text-seconday on-hover-action mb-5']//h5)[1]")
    public WebElement section_1Text;

    @FindBy(css = "strong>a")
    public List<WebElement> courseListElements;

    @FindBy(css = "li.nav-item")
    public List<WebElement> courseUpdatePageHeaderTags;

    @FindBy(css = "button.btn.btn-sm")
    public List<WebElement> selectedElementThreeDots;

    @FindBy(css = "ul.show>li>a")
    public List<WebElement> threeDotAllElements;

    @FindBy(css = "[id='update_link']")
    public WebElement continueButton;

    @FindBy(xpath = "(//button[.=' Sort lesson'])[1]")
    public WebElement buttonSortLesson;

    @FindBy(xpath = "(//button[.=' Edit section'])[1]")
    public WebElement buttonEditSection;

    @FindBy(xpath = "//label[.='Duration']")
    public WebElement duration_text;

    @FindBy(xpath = "//div[@class='card mb-0 mt-2 draggable-item']")
    public List<WebElement> listOfSections;

    @FindBy(xpath = "(//div[@class='card mb-0 mt-2 draggable-item'])[2]")
    public WebElement listOfSections_2ndOne;

    @FindBy(xpath = "(//div[@class='card mb-0 mt-2 draggable-item'])[1]")
    public WebElement listOfSections_1stOne;

    @FindBy(xpath = "(//div[@class='card mb-0 mt-2 draggable-item'])[2]")
    public WebElement updateSorting;

    @FindBy(xpath = "//div[@id='lesson-list']//h5")
    public List<WebElement> listOfLessons;

    @FindBy(xpath = "(//div[@id='lesson-list']//h5)[1]")
    public WebElement listOfLessons_1stOne;

    @FindBy(xpath = "//input[@class='form-control' and @id='title']") //title text box inside Update Section after clicked Edit Section
    public WebElement title_UpdateSection;

    @FindBy(xpath = "//input[@name='title' and @id='title']")   //Section 1: text on Course manager Page
    public WebElement section_text;

    @FindBy(xpath = "//div[@class='row']//h5[@class='card-title']")   //div[@class='col-xl-8']//h5[@class='card-title']
    public List<WebElement> listOfSectionsUnderCoursemanagerPage;

    @FindBy(xpath = "//a[@id='update_link']")
    public WebElement continue_buttonForDelete;

    @FindBy (xpath = "//a[@class='nav-link rounded-0 pt-2 pb-2 active']")
    public WebElement Seo;

    @FindBy(css = "div.bootstrap-tagsinput>input")
    public WebElement metaKeywordsTextbox;

    @FindBy (name = "meta_description")
    public WebElement metaDescriptionTextbox;

    @FindBy (css = "span.label-info")
    public WebElement metaKeywordsText;

    @FindBy (css = "[onclick='checkRequiredFields()']")
    public WebElement lessonUpdatePageSubmitButton;

    @FindBy (partialLinkText = "//*[text()='Congratulations!']")
    public WebElement congratulations;

    @FindBy (id = "select2-course_overview_provider-container")
    public WebElement courseOverviewProviderDropDown;

    @FindBy (id = "select2-course_overview_provider-result-xk1c-youtube")
    public WebElement firstCourseOverview;

    @FindBy (id = "course_overview_url")
    public WebElement courseOverviewUrl;



    //hazel calisma: //div[@class='custom-control custom-radio']
    //(//div[@class='custom-control custom-radio'])[i] ilk 5 icin alacagiz


    @FindBy (xpath = "(//div[@class='card bg-light text-seconday on-hover-action mb-5'])[1]")
    public WebElement section_1_Div;

    @FindBy (xpath = "//button[@class='btn btn-success']")
    public WebElement submit_editSectionTitle;


//TC 23: ========================================================
    @FindBy(xpath = "//*[@class='mdi mdi-pencil-outline']" )
    public List<WebElement> iconEdit;

    @FindBy (xpath = "//*[@class='mdi mdi-window-close']")
    public List<WebElement> iconDelete;

    @FindBy(xpath = "//div[@class='card text-secondary on-hover-action mb-2']")
    public List<WebElement> listOfLessons_CourseManagerPage;
//=======================================================================
}
