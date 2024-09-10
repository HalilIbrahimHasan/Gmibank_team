package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WDController;

public class RegistrationPage extends CommonPageElements{

    public RegistrationPage(){

        PageFactory.initElements(WDController.getDriver(), this);
    }
    @FindBy(id = "ssn")
    public WebElement ssnTextbox;

    @FindBy(id = "firstname")
    public WebElement firstnameTextbox;

    @FindBy(id = "lastname")
    public WebElement lastnameTextbox;

    @FindBy(id = "address")
    public WebElement addressTextbox;

    @FindBy(id = "mobilephone")
    public WebElement mobilephoneTextbox;

    @FindBy(id = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextbox;

    @FindBy(id = "secondPassword")
    public WebElement newPasswordTextbox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[contains(text(),'translation-not-foun'")
    public WebElement toastContainer;

    @FindBy(xpath = "//*[contains(text(),'Registration saved!')]")
    public WebElement successMessage;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerNavigation;

    @FindBy(xpath = "//*[@name='ssn']/following::div")
    public WebElement ssnInvalidFeedback;


    @FindBy(xpath = "//*[@name='firstname']/following::div")
    public WebElement firstnameInvalidFeedback;

    @FindBy(xpath = "//*[@name='lastname']/following::div")
    public WebElement lastnameInvalidFeedback;

    @FindBy(xpath = "//*[@name='address']/following::div")
    public WebElement addressInvalidFeedback;

    @FindBy(xpath = "//*[@name='mobilephone']/following::div")
    public WebElement mobilephoneInvalidFeedback;

    @FindBy(xpath = "//*[@name='username']/following::div")
    public WebElement usernameInvalidFeedback;

    @FindBy(xpath = "//*[@name='email']/following::div")
    public WebElement emailInvalidFeedback;

}
