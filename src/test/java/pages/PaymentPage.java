package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentPage {

    public PaymentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy (xpath = "//*[@id='cart_items_details']")
    public WebElement Checkout;

    @FindBy (xpath = "(//input[@type='text'])[2]")
    public WebElement SearchBox;

    @FindBy (xpath = "(//*[@onclick='handleCartItems(this)'])[2]")
    public WebElement AddToCart;

    @FindBy(xpath = "//*[@id='cart_items']")
    public WebElement ShoppingCart;

    @FindBy(xpath = "//*[@class='btn red w-100 radius-10 mb-3']")
    public WebElement CheckoutBtn;

    @FindBy(xpath = "//*[@class='row payment-gateway stripe']")
    public WebElement StripeBtn;

    @FindBy(xpath = "//*[@id='stripePayButton']")
    public WebElement StripePayBtn;

    @FindBy (xpath = "//*[@class='fa fa-times']")
    public WebElement CloseIcon;

    @FindBy (xpath = "(//*[@class='CheckoutInput Input Input--empty'])[1]")
    public WebElement MailBox;

    @FindBy (xpath = "//*[@class='CheckoutInput CheckoutInput--tabularnums Input Input--empty']")
    public WebElement CardNumberBox;

    @FindBy (name = "cardExpiry")
    public WebElement CardMMYY;

    @FindBy (name = "cardCvc")
    public WebElement CVC;

    @FindBy (name="billingName")
    public WebElement NameOnCard;

    @FindBy (xpath = "//*[@class='Select-source']")
    public WebElement Country;

    @FindBy (xpath =" //*[@class='SubmitButton-IconContainer']")
    public WebElement SubmitPayBtn;

    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement PaymentSucces;

    @FindBy (xpath = "//*[@class='page-title py-5 text-white print-hidden']")
    public WebElement MyCourses;

    @FindBy (xpath = "//*[@class='title']")
    public WebElement PianoCourse;

    @FindBy (xpath = "//*[@class='dripicons-to-do']")
    public WebElement SaleReport;

    @FindBy (xpath = "//*[@class='form-control']")
    public WebElement SelectDate;

    @FindBy (xpath = "//*[@class='active']")
    public WebElement SelectDate2;

    @FindBy (xpath = "//*[@class='btn btn-info']")
    public WebElement FilterBtn;







}

