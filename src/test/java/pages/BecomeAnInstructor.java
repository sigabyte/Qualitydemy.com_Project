package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BecomeAnInstructor {
    public BecomeAnInstructor() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input#name")
    public WebElement name;

    @FindBy(css = "input#email")
    public WebElement email;

    @FindBy(css = "textarea#address")
    public WebElement address;

    @FindBy(css = "input#phone")
    public WebElement phone;

    @FindBy(css = "textarea#message")
    public WebElement anyMessage;

    @FindBy(css = "input#document")
    public WebElement document;

    @FindBy(css = "[onclick='checkRequiredFields()']")
    public WebElement applyButton;

    @FindBy(css = "a.btn.btn-primary")
    public WebElement applicationDetails;

    @FindBy(css = "table.table-bordered>tbody>tr:nth-child(3)>td:last-child")
    public WebElement phoneVerifyText;

    @FindBy(css = "table.table-bordered>tbody>tr:nth-child(4)>td:last-child")
    public WebElement addressVerifyText;

    @FindBy(css = "table.table-bordered>tbody>tr:nth-child(5)>td:last-child")
    public WebElement anyMessageVerifyText;

    @FindBy(css = "button.btn.btn-secondary")
    public WebElement closeDetailyPage;

    @FindBy(partialLinkText = "Click to activate")
    public WebElement clickToActivateButton;

    @FindBy(css = "div.badge")
    public WebElement approvedText;

    @FindBy(id = "document")
    public WebElement documentInput;
}
