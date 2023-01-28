package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CompareCoursePage {

    public CompareCoursePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Select a course'])[1]")
    public WebElement selectaCourse;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//li[@role='treeitem']")
    public WebElement aratilanKurs;

    @FindBy(xpath = "//a[@class='text-danger fw-500 pt-3 d-inline-block']")
    public WebElement learMoreLink;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    public WebElement ilkKutu;

    @FindBy(xpath = "//li[@role='treeitem']")
    public List<WebElement> dropBoxCoursList;



}
