package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ThreeDotsPage {
   public ThreeDotsPage (){
       PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//i[@class='mdi mdi-dots-vertical'])[1]")
    public WebElement threeDots;
    @FindBy(xpath = "(//a[text()='View course on frontend'])[1]")
    public WebElement frontendLink;
    @FindBy(xpath = "(//a[text()='Go to course playing page'])[1]")
    public WebElement gotoCoursePlayingPageLink;
    @FindBy(xpath = "(//a[text()='Edit this course'])[1]")
    public WebElement editThisCourseLinki;
    @FindBy(xpath = "(//a[text()='Section and lesson'])[1]")
    public WebElement sectionAndLessonLink;
    @FindBy(xpath = "(//a[text()='Mark as drafted'])[1]")
    public WebElement markAsDraftedLinki;
    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    public WebElement deleteLinki;
    @FindBy(xpath = "(//button[text()='Cancel'])[1]")
    public WebElement cancelButonu;
    @FindBy(xpath = "//a[@class='btn btn-outline-primary btn-rounded alignToTitle']")
    public WebElement  addNewCourse;
    @FindBy(xpath = "//h4[@class='page-title']")
    public WebElement  addNewCoursePageTitle;
    @FindBy(xpath = "//a[@class='alignToTitle btn btn-outline-secondary btn-rounded btn-sm my-1']")
    public WebElement backToCourseListButton;
}
