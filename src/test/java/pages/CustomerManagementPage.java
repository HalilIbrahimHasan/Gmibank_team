package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojos.Account;
import utilities.WDController;

import java.util.List;

public class CustomerManagementPage {


    public CustomerManagementPage(){
        super();
        PageFactory.initElements(WDController.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name='accounts']")
    public WebElement userAccounts;

    public void selectAccounts(List<Account> accounts){

        WDController.sleep(3000);
        for (Account acc : accounts){
            if(acc.getDescription() != null)
        WDController.selectAnItemFromDropdown(userAccounts,acc.getDescription() );
            System.out.println("accounts: " +acc);
        }}


}
