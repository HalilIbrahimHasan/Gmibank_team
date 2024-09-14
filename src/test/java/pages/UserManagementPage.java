package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WDController;

import java.util.List;

public class UserManagementPage {

    public UserManagementPage(){
        super();
        PageFactory.initElements(WDController.getDriver(), this);

    }

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administratorDropdownMenu;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagementPortal;

    @FindAll({@FindBy(xpath = "//*[@class='page-item']")})
    public List<WebElement> allPages ;


    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[2]")})
    public List<WebElement> allUsers ;


    @FindAll({@FindBy(xpath = "//table/tbody/tr/td[4]")})
    public List<WebElement> userActivations ;




    public WebElement getLastPage(){
        WebElement element = null;

        for (int i = 0; i < allPages.size(); i++) {
            if(WDController.waitAndGetText(allPages.get(i),7).
                    equalsIgnoreCase(">")) {
                element = allPages.get(i-1);
            }
        }

        return element;

    }

    public void findAndActivateUser(){
        WDController.scrollEndOfPage();
        WDController.waitAndClick(userActivations.get(allUsers.size()-1));
    }

    public void editLastUser(){

        WDController.getDriver().findElement(
                By.xpath("(//*[text()''])["+(allUsers.size()-1)+"]"));
    }

}
