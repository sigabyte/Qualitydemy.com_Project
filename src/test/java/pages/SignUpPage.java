package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {
    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@class='btn btn-sign-up']")
    public WebElement SignUpButton;

    @FindBy(tagName = "h1")
    public WebElement SignUPPageTitle;

    @FindBy(name = "first_name")
    public WebElement firstNameInput;

    @FindBy(name = "last_name")
    public WebElement lastNameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement registrationSignUpButton;

    @FindBy(css = "input.form-control:last-child")
    public WebElement verificationInput;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement continueButton;

}


