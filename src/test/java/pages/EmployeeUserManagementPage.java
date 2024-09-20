package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WDController;

import java.util.List;

public class EmployeeUserManagementPage {

    public EmployeeUserManagementPage() {
        super();
        PageFactory.initElements(WDController.getDriver(), this);
    }


    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement employeeOperationsDropdownMenu;

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement employeeManageCustomersPortal;

 //   @FindBy(xpath = "//*[text()='Create a new Customer']")
    @FindBy(id = "jh-create-entity")
    public WebElement employeeCreateCustomerPortal;

    @FindAll({@FindBy(xpath = "//*[@class='page-item']")})
    public List<WebElement> allPages ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[1]")})
    public List<WebElement> allID ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[2]")})
    public List<WebElement> allFirsName ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[3]")})
    public List<WebElement> allLastName ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[4]")})
    public List<WebElement> allMiddleInitial ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[5]")})
    public List<WebElement> allEmail ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[6]")})
    public List<WebElement> allMobile ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[7]")})
    public List<WebElement> allPhone ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[8]")})
    public List<WebElement> allAddress ;

    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[9]")})
    public List<WebElement> allCreateDate ;

    @FindAll({@FindBy(xpath = "//*[@class='btn-group flex-btn-group-container']//*[text()='View']")})
    public List<WebElement> allViewButtons ;

    @FindAll({@FindBy(xpath = "//*[@class='btn-group flex-btn-group-container']//*[text()='Edit']")})
    public List<WebElement> allEditButtons ;

    @FindAll({@FindBy(xpath = "//*[@class='btn-group flex-btn-group-container']//*[text()='Delete']")})
    public List<WebElement> allDeleteButtons ;

    @FindBy(id = "search-ssn")
    public WebElement searchSsnTextbox;

   @FindBy(xpath = "//*[text()='Search']")
   public WebElement searchButton;

    @FindBy(name = "firstName")
    public WebElement firstNameTextbox;

    @FindBy(name = "lastName")
    public WebElement lastNameTextbox;

    @FindBy(name = "middleInitial")
    public WebElement middleInitialTextbox;

    @FindBy(name = "email")
    public WebElement emailTextbox;

    @FindBy(name = "mobilePhoneNumber")
    public WebElement mobilePhoneNumberTextbox;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberTextbox;

    @FindBy(name = "zipCode")
    public WebElement zipCodeTextbox;

    @FindBy(name = "address")
    public WebElement addressTextbox;

    @FindBy(name = "city")
    public WebElement cityTextbox;

    @FindBy(id = "tp-customer-ssn")
    public WebElement ssnTextbox;

    @FindBy(name = "createDate")
    public WebElement createDateTextbox;

    @FindBy(xpath = "//*[@name='country.id']/following::div[1]")
    public WebElement countryDropdown;

    @FindBy(name = "state")
    public WebElement stateTextbox;

    @FindBy(xpath = "//*[@name='user.id']/following::div[1]")
    public WebElement userDropdown;

    @FindBy(xpath = "//*[@name='accounts.id']/following::div[1]")
    public WebElement accountsDropdown;

    @FindBy(name = "zelleEnrolled")
    public WebElement zelleEnrolledCheckbox;

    @FindBy(id = "cancel-save")
    public WebElement backButton;

    @FindBy(id = "save-entity")
    public WebElement saveButton;



}