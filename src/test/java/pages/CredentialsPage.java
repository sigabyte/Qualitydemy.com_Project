package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CredentialsPage {

    public CredentialsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement credentialTitle;

    @FindBy(xpath = "//input[@id='current_password']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@id='new_password']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@id='confirm_password']")
    public WebElement confirmPassword;







}
