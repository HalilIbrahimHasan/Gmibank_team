package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojos.Account;
import utilities.WDController;



public class AccountManagementPage extends CommonPageElements{



    public AccountManagementPage(){
        super();
        PageFactory.initElements(WDController.getDriver(), this);

    }

    @FindBy(xpath = "//*[@name='accountType']")
    public WebElement accountTypeDropdown;

    @FindBy(xpath = "//*[@name='accountStatusType']")
    public WebElement accountStatus;


    public static void setDescription(String header, String input, Account account){
        if(header.equalsIgnoreCase("Description")){
            account.setDescription(input);
        }
    }

    public static void setBalance(String header, String input, Account account){
        if(header.equalsIgnoreCase("Balance")){
            account.setBalance(input);
        }
    }
}
