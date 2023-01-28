package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CourseEditPage {
    public CourseEditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a.alignToTitle.btn.btn-outline-secondary.btn-rounded.btn-sm.my-1:last-child")
    public WebElement backToCourseList;

    @FindBy(css = "a.alignToTitle.btn.btn-outline-secondary.btn-rounded.btn-sm.my-1:first-child")
    public WebElement viewOnFrontEnd;

    @FindBy (xpath = "(//a[@class='btn btn-info'])[2]")
    public WebElement rightArrow;

    @FindBy (xpath = "(//a[@class='btn btn-info'])[1]")
    public WebElement leftArrow;

    @FindBy (xpath = "(//label[@class='col-md-2 col-form-label'])[1]")
    public WebElement courseTitel;

    @FindBy (xpath = "(//i[@class='mdi mdi-plus'])[1]")
    public WebElement addSection;
}
