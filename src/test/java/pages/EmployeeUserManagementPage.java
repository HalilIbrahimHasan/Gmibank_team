package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WDController;

import java.util.List;

import static stepDefs.BaseSteps.eump;

public class EmployeeUserManagementPage extends CommonPageElements {

    public EmployeeUserManagementPage() {
        super();
        PageFactory.initElements(WDController.getDriver(), this);
    }


    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement employeeOperationsDropdownMenu;

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement employeeManageCustomersPortal;

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

    @FindBy(name = "country.id")
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

    @FindBy(xpath = "//*[text() = 'Customer']/following::b")
    public WebElement viewPageCustomerIdLabel;

    @FindBy(xpath = "//*[text() = 'Back']")
    public WebElement viewPageBackButton;

    @FindBy(xpath = "//*[text() = 'Edit']")
    public WebElement viewPageEditButton;



    public void checkAccountInformation(){
        for (int j = 0; j < Integer.parseInt(allPages.get(allPages.size()-3).getText()); j++) {
            for (int i = 0; i < allID.size(); i++) {
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" ID is EMPTY",allID.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" First name is EMPTY",allFirsName.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" last name is EMPTY",allLastName.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Middle initial is EMPTY",allMiddleInitial.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Email is EMPTY",allEmail.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Mobile phone number is EMPTY",allMobile.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Phone number is EMPTY",allPhone.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Address is EMPTY",allAddress.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Create date is EMPTY",allCreateDate.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" View buttons is EMPTY",allViewButtons.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Edit buttons is EMPTY",allEditButtons.get(i).getText().isEmpty());
                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" Delete buttons is EMPTY",allDeleteButtons.get(i).getText().isEmpty());
           }
            WDController.waitAndClick(allPages.get(allPages.size()-2));
        }
    }


    public void checkViewButtonFunctionality(){
        for (int j = 92; j < Integer.parseInt(allPages.get(allPages.size()-3).getText()); j++) {
                   System.out.println(j);
            //        System.out.println(allPages.get(allPages.size()-3).getText());
            //        allPages.get(allPages.size()-1).click();

            WDController.wait(5);
            for (int i = 19; i < allID.size(); i++) {
                //            System.out.println(allViewButtons.get(i).getText());
                //            System.out.println(allID.get(i).getText().isEmpty());

                for (int k = 0; k < j; k++) {
                    WDController.waitAndClick(allPages.get(allPages.size() - 2));
                    WDController.wait(1);
                }


                String customerID = allID.get(i).getText();

                WDController.waitAndClick(allViewButtons.get(i));
                WDController.wait(5);

                Assert.assertEquals(customerID,viewPageCustomerIdLabel.getText());
                Assert.assertTrue(viewPageEditButton.isDisplayed());

                WDController.waitAndClick(viewPageBackButton);

                //                Assert.assertFalse("Page "+(j+1)+" Row "+(i+1)+" View buttons is EMPTY",allViewButtons.get(i).getText().isEmpty());

                WDController.wait(2);


                System.out.println(i);
                System.out.println(customerID);
            }
            WDController.waitAndClick(allPages.get(allPages.size()-2));
        }
    }


}