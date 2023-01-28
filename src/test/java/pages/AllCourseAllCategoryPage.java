package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AllCourseAllCategoryPage {
    public AllCourseAllCategoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//span[@class='badge badge-primary'])[1]") //her sayfada 6 adet kurs var
    // toplamda 3 sayfa var simdilik
    public WebElement sayfadakiILkKurs;

    @FindBy(xpath = "//a[@class='course-title']")
    public WebElement CourseTitles;

    @FindBy(xpath = "(//button[@class='btn-compare-sm'])[1]")
    public WebElement compareButton;

    @FindBy(css = "[for='price_free']")
    public WebElement freeRadioButton;

    @FindBy(css = "[for='price_paid']")
    public WebElement paidRadioButton;

    @FindBy(xpath = "//a[@rel='next']")
    public WebElement nextPageButton;


    public static String getLocator() {
        // Driver.getDriver().get(ConfigReader.getProperty("url"));
        //HomePage homePage=new HomePage();
        //Actions actions= new Actions(Driver.getDriver());
        // homePage.cookies.click();
        // actions.moveToElement(homePage.category).moveToElement(homePage.allCourseCategory).click().perform();

        List<WebElement> courseTitlesElement = Driver.getDriver().findElements(By.xpath("//a[@class='course-title']"));
        int sayi = 1;
        for (WebElement each : courseTitlesElement) {
            if (each.getText().contains("purchased")) {
                sayi++;
            } else {
                break;
            }
        }
        String dinamikLocator = "(//a[@class='course-title'])[" + sayi + "]";

        return dinamikLocator;
    }
    @FindBy(xpath = "//div[@class='col-md-6 col-lg-3 px-2']")
    public List<WebElement> lessonsList;

    @FindBy(linkText = "Already purchased")
    public WebElement alreadyPurchasedCourse;

}