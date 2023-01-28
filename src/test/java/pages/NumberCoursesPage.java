package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NumberCoursesPage {
    public NumberCoursesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//div[@class='card-body text-center'][1])")
    public WebElement numberOfCources;
    @FindBy(xpath = "//h1[@class='title']")
    public WebElement courseTitleCourse;

}
