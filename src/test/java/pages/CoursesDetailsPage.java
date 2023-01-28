package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CoursesDetailsPage {
    public CoursesDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "button.btn-buy-now")
    public WebElement addToCartButonu;

    @FindBy(xpath = "//*[text()='Buy now']")
    public WebElement buyNowButonu;

    @FindBy(css = "h1.title")
    public WebElement courseH1Title;

    @FindBy(css = "a.badge-sub-warning")
    public WebElement compareCourseButton;

    @FindBy(css = "button.btn-add-wishlist")
    public WebElement addToWishlistButton;

    @FindBy(css = "a.btn-buy-now")
    public WebElement getEnrolledButton;

    @FindBy(css = "div.already_purchased>a")
    public WebElement alreadyPurchasedButton;

    @FindBy(xpath = "(//span[@class='total-lectures'])[1]")
    public WebElement numberOfCourse;

    @FindBy(xpath = "(//span[@class='total-time'])[1]")
    public WebElement durationOfCourse;

    @FindBy(css = "span.lecture-title")
    public List<WebElement> courseVideoLinks;

    @FindBy(css = "div.col-md-12>h5")
    public WebElement courseH5Title;

    @FindBy(css = "Add to Cart")
    public WebElement AddToCart;
}
