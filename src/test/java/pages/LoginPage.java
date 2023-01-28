package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement logInEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement logInPassword;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement WelcomeMessage;


    @FindBy(xpath = "//div[@class='toast toast-error']")
    public WebElement InvalidLoginCredentials;





}
