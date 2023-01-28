package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WishlistPage {
    public WishlistPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "h5.title")
    public List<WebElement> lessonHeader;

    @FindBy(xpath = " (//button[@class='btn-compare-sm float-end'])[1]")
    public WebElement compare;

    @FindBy(xpath = "//h5[1]")
    public WebElement ilkkursAdi;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement seacrMycoursesBox;

    @FindBy(xpath = "(//img[@aria-label='Admin User'])[1]")
    public WebElement ilkInstructorImg;

    //tiklanan instructor img icin acilan sayfadaki instructor yazisi
    @FindBy(xpath = "//h4[text()='Instructor']")
    public WebElement instructorYazisi;

    @FindBy(css = "button.btn-compare-sm")
    public List<WebElement> compareButton;

    @FindBy(xpath = "//h5[2]")
    public WebElement ikincikursAdi;
}
