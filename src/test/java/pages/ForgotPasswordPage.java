package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {

    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Forgot password?")
    public WebElement ForgotPassword;

    @FindBy(tagName = "h1")
    public WebElement ForgotPasswordPageTitle;

    @FindBy(xpath = "//input[@id='forgot-password-email']")
    public WebElement forgotPasswordEmailInput;

    @FindBy(xpath = "//button[text()='Send request']")
    public WebElement forgotPasswordSendRequestButton;

    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement SuccessMessage;

}
