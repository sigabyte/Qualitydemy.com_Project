package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UpdateUserPhotoPage {
    public UpdateUserPhotoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement updatePhotoTitle;

    @FindBy(xpath = "//input[@id='user_image']")
    public WebElement chooseButton;

    @FindBy(xpath = "//input[@id='user_image']")
    public WebElement imagePath;

    @FindBy (xpath = "//input[@id='user_image']")
    public WebElement uploadButton;

    @FindBy(xpath = "//div/div[@class='toast-message']")
    public WebElement toastMessage;

    @FindBy(xpath = "//div/div[@class='toast-message']")
    public WebElement toastMessage2;


}
