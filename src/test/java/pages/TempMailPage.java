package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TempMailPage {
    public TempMailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "click-to-copy")
    public WebElement copyEmail;

    @FindBy(xpath = "(//a[@class='viewLink title-subject'])[2]")
    public WebElement verificationMail;

    @FindBy(css = "b>u")
    public WebElement verificationCode;
}
