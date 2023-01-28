package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MyCoursesPage {
    public MyCoursesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Reset']")
    public WebElement resetlinki;

    @FindBy(xpath = "//a[@data-bs-toggle='dropdown']")
    public WebElement categoriesDropDown;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement dropDownItems;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement seacrMycoursesBox;

    @FindBy(xpath = "(//a[text()='Edit rating'])[1]")
    public WebElement editRatingLinki1;

    @FindBy(xpath = "(//div[@class='form-group select mb-2'])[1]")
    public WebElement scoreScreen;

    @FindBy(xpath = "(//a[text()='Cancel'])[1]")
    public WebElement cancel1;

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement selectScoreRange;

    @FindBy(xpath = "//option[@value='3']")
    public WebElement option3;

    @FindBy(xpath = "//option[@value='5']")
    public WebElement option5;

    @FindBy(xpath = "(//textarea[@class='form-control'])[1]")
    public WebElement messageBox;

    @FindBy(xpath = "(//button[text()='Publish rating'])[1]")
    public WebElement publishRatingButton;

    @FindBy(xpath = "(//a[text()='Start lesson'])[1]")
    public WebElement startLessonLink;

    @FindBy(css = "div.course-box>a:first-child")
    public List<WebElement> lessonUrlList;

    @FindBy(xpath = "(//div[@class='course-image'])[1]")
    public WebElement sayfadakiIlkKursLinki;


    @FindBy (xpath = "//i[@class='fas fa-balance-scale']")
    public static WebElement compareThisCourseWithOther;

    @FindBy(xpath = "//span[@class='play-btn']")
    public List<WebElement> sayfadakiKurslarListesi;

    @FindBy(xpath = "//i[@class='fas fa-star filled']")
    public  List<WebElement> sayfadakiRatingYildizlarListesi;


    @FindBy (xpath = "//div[@class='description-title']")
    public static WebElement courseOverview;
}
