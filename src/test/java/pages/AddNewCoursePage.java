package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AddNewCoursePage {
    public AddNewCoursePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // BASIC SECTION LOCATORS

    @FindBy(xpath = "//input[@id='course_title']")
    public WebElement courseTitleTextBox;

    @FindBy(xpath = "//textarea[@id='short_description']")
    public WebElement shortDescriptionTextBox;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement description;

    @FindBy(xpath = "//span[@id='select2-sub_category_id-container']")
    public WebElement categoryDropDownMenu;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement categoryDropDownMenuSearchInput;

    @FindBy(xpath = "//span[@id='select2-level-container']")
    public WebElement levelDropDownMenu;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement levelDropDownMenuSearchInput;

    @FindBy(xpath = "//span[@id='select2-language_made_in-container']")
    public WebElement languageMadeInDropDownMenu;

    @FindBy(css = "input.select2-search__field")
    public WebElement languageMadeInDropDownMenuSearchInput;

    @FindBy(xpath = "(//label[@for='enable_drip_content'])[2]")
    public WebElement enableDripContentButton;

    @FindBy(xpath = "//label[text()='Check if this course is top course']")
    public WebElement checkIfThisCourseIsTopCourseCheckbox;

    @FindBy(xpath = "//li[@class='next list-inline-item']")
    public WebElement nextPageButton;

    @FindBy(xpath = "//input[@id='requirements']")
    public List<WebElement> requirementsSelectionsAmount;


    // REQUIREMENTS SECTION LOCATORS

    @FindBy(xpath = "//a[@href='#requirements']")
    public WebElement requirementsButton;

    @FindBy(xpath = "//li[@class='previous list-inline-item']")
    public WebElement previousPageButton;

    @FindBy(xpath = "(//input[@id='requirements'])[1]" )
    public WebElement requirementsTextBox;

    @FindBy(xpath = "//button[@onclick='appendRequirement()']")
    public WebElement addRequirementButton;

    @FindBy(xpath = "(//button[@onclick='removeRequirement(this)'])[2]")
    public WebElement deleteRequirementButton;


    // OUTCOMES SECTION LOCATORS

    @FindBy(xpath = "//a[@href='#outcomes']")
    public WebElement outcomesButton;

    @FindBy(xpath = "(//input[@id='outcomes'])[1]")
    public WebElement outcomesTextBox;

    @FindBy(xpath = "//button[@onclick='appendOutcome()']")
    public WebElement addOutcomesButton;

    @FindBy(xpath = "(//button[@onclick='removeOutcome(this)'])[2]")
    public WebElement deleteOutcomesButton;

    @FindBy(xpath = "//input[@placeholder='Provide outcomes']")
    public List<WebElement> outcomesSelectionAmount1;

    @FindBy(xpath = "//input[@placeholder='Provide outcomes']")
    public List<WebElement> outcomesSelectionAmount2;


    // PRICING SECTION LOCATORS


    @FindBy(xpath = "//a[@href='#pricing']")
    public WebElement pricingButton;

    @FindBy(xpath = "//label[@for='is_free_course']")
    public WebElement checkIfThisIsAFreeCourseCheckbox;

    @FindBy(xpath = "//input[@id='is_free_course']")
    public WebElement checkBoxValueCheck;
    @FindBy(xpath = "//input[@id='price']")
    public WebElement coursePriceTextBox;

    @FindBy(xpath = "//label[@for='discount_flag']")
    public WebElement checkIfThisCourseHasDiscountCheckbox;

    @FindBy(xpath = "//input[@id='discount_flag']")
    public WebElement discountValueCheck;

    @FindBy(xpath = "//input[@id='discounted_price']")
    public WebElement discountedPriceTextBox;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement discountPercentage;


    // FINISH SECTION LOCATORS

    @FindBy(xpath = "//i[@class='mdi mdi-checkbox-marked-circle-outline']")
    public WebElement finishButton;

    @FindBy(xpath = "//button[@onclick='checkRequiredFields()']")
    public WebElement submitButton;

    @FindBy(id = "enable_drip_content")
    public WebElement switchBtnValue;

    @FindBy(xpath = "(//label[@for='enable_drip_content'])[2]")
    public WebElement switchBtnText;

    @FindBy(xpath = "(//input[@class='custom-control-input'])[1]")
    public WebElement checkbox;

    @FindBy(xpath = "(//label[@class='custom-control-label'])[1]")
    public WebElement checkboxText;






}
