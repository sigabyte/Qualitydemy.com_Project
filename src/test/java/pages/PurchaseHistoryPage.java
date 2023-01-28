package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchaseHistoryPage {

    public PurchaseHistoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div/a[text()='Invoice']")
    public WebElement invoiceButton;

    @FindBy(xpath = "(//a[@class='purchase-history-course-title'])[1]")
    public WebElement courseTitleFirstCourse;

}
