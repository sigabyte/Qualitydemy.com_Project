package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserProfilePage {
    public UserProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[5]")
    public WebElement userProfile;

    @FindBy(xpath = "//input [@id='FristName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//textarea[@name='title']")
    public WebElement title;

    @FindBy(xpath = "//tags/div/span")
    public WebElement skills;

    @FindBy(xpath = "//body[@data-id='Biography']")
    public WebElement biography;

    @FindBy(xpath = "//input[@name='twitter_link']")
    public WebElement twitter;
    @FindBy(xpath = "//input[@name='facebook_link']")
    public WebElement faceBook;
    @FindBy(xpath = "//input[@name='linkedin_link']")
    public WebElement linkedIn;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//h1")
    public WebElement userProfileTitle;

    @FindBy(xpath = "//div/div[@class='toast-message']")
    public WebElement toastMessage;

    @FindBy(xpath = "(//a)[52]")
    public WebElement profileButton;

    @FindBy(xpath = " //a[text()=' Account']")
    public WebElement accountButton;

    @FindBy(xpath = " //a[text()=' Photo']")
    public WebElement photoButton;

}
