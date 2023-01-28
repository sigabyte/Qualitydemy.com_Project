package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ShoppingCartPage {

    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath  ="(//div[@class='name'])[1]")
    public WebElement sayfadakiIlkKurs;

    @FindBy(xpath = "(//div[@onclick='removeFaFromCartList(this)'])[1]")
    public WebElement sayfadakiIlkKursunRemoveButonu;

    @FindBy(xpath = "//input[@id='coupon-code']")
    public WebElement CouponBox;

    @FindBy(xpath ="//div[@class='total-price']")
    public WebElement totalPrice;

    @FindBy(xpath = "//*[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@onclick='applyCoupon()']")
    public WebElement applyButton;

    @FindBy(xpath = "//span[@class='discount-rate']")
    public WebElement couponAppliedYazisi;

    @FindBy(xpath = "//li[@class='breadcrumb-item active text-light display-6 fw-bold']")
    public WebElement shoppingCartHeader;

    @FindBy(xpath = "(//ul[@class='cart-course-list']/li/div/div/a/div[1])")
    public List<WebElement> itemList;

}
