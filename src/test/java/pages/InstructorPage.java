package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InstructorPage {
    public InstructorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//i[@class='dripicons-view-apps']")
    public WebElement dashboard;

    @FindBy(xpath ="//i[@class='dripicons-archive']" )
    public WebElement courseManager;

    @FindBy(xpath = "//i[@class='dripicons-to-do']")
    public WebElement salesReport;

    @FindBy(xpath = "//i[@class='dripicons-shopping-bag']")
    public WebElement payoutReport;

    @FindBy(xpath = "//i[@class='dripicons-mail']")
    public WebElement message;

    @FindBy(xpath = "//i[@class='dripicons-user']")
    public WebElement manageProfile;



}
