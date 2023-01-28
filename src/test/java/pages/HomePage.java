package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Categories']")
    public WebElement category;

    @FindBy(xpath = "(//*[text()='All courses'])[1]")
    public WebElement allCourseCategory;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement cookies;

    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement instructorLink;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement logInLinki;

    @FindBy(xpath = "(//a[text()='My courses'])[1]")
    public WebElement myCoursesLinki;

    @FindBy(xpath = "//*[@class='btn btn-sign-in-simple']")
    public WebElement firstLogInButton;

    @FindBy(xpath = "//*[@id='login-email']")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id='login-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginButton;

    @FindBy(linkText = "Sign Up")
    public WebElement signUpButton;

    @FindBy(xpath = "(//div[@class='icon'])[5]")
    public WebElement userMenuIcon;

    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[4]")
    public WebElement purchaseHistory;

    @FindBy(xpath = "(//i[@class='far fa-heart'])[1]")
    public WebElement wishListKalp;

    @FindBy(xpath = "//*[text()='Go to wishlist']")
    public WebElement gotoWishListLinki;

    @FindBy(xpath = "//*[@class='navbar-brand pt-2 mt-1']")
    public WebElement logo;

    @FindBy(xpath = "//*[text()='title']")
    public WebElement HomePageTitle;

    @FindBy(xpath = "//*[@class='fab fa-facebook-f']")
    public WebElement facebookIcon;

    @FindBy(xpath = "(//i[@class='fas fa-shopping-cart'])[1]")
    public WebElement sepet;

    @FindBy(xpath = "//i[@class='fab fa-twitter']")
    public WebElement twitterIcon;

    @FindBy(xpath = "//*[@class='fab fa-linkedin']")
    public WebElement linkedInIcon;

    @FindBy(xpath ="//*[text()='About Us']")
    public WebElement aboutUsButton;

    @FindBy(xpath = "//*[@class='featured-instructor']")
    public WebElement featuredButton;

   @FindBy(xpath = "//*[@class='header-underline-2']")
    public WebElement Top10LatestCourses;

   @FindBy(xpath ="//*[text()='Lifetime access']")
    public WebElement LifeTimeText;

   @FindBy(xpath = "//*[text()='Expert instruction']")
    public WebElement ExpertInstructionText;

   @FindBy(xpath ="//*[@class='btn btn-primary px-4 py-2']" )
    public WebElement GetStartedButton;


    @FindBy(xpath = "//*[@class='fas fa-shopping-cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//*[@class='footer-area d-print-none mt-5 pt-5']")
    public WebElement siteFooterCart;

    @FindBy(xpath = "(//li[@class='mb-2 mt-1'])")
    public List<WebElement> liHistory;

    public static void login(){
        HomePage homePage=new HomePage();
        LoginPage login=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.cookies.click();
        homePage.logInLinki.click();
        login.logInEmail.sendKeys(ConfigReader.getProperty("emailBrn"));
        login.logInPassword.sendKeys(ConfigReader.getProperty("PswrdBrn"));
        login.loginButonu.click();
    }


    @FindBy(xpath = "//a[@href=\"https://facebook.com\"]")
    public WebElement fb;
}
