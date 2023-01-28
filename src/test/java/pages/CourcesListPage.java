package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CourcesListPage {
    public CourcesListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement cookies;
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLinki;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailLinki;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordLinki;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;
    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement instroctur;
    @FindBy(xpath = "//i[@class='dripicons-archive']")
    public WebElement courseManager;
   // @FindBy(xpath = "//h4[@class='page-title']")
    //public WebElement coursePage;
    @FindBy(xpath = "//p[text()='Pending courses']")
    public WebElement pendingCources;
    @FindBy(xpath = "//p[text()='Requested withdrawal amount']")
    public WebElement requestedWithdrawal;
    @FindBy(xpath = "//h4[@class='page-title']")
    public WebElement courcesPage;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement filtreButonu;
    @FindBy(xpath = "//h4[text()='Course list']")
    public WebElement courcesList;


}
