package pages;

import constants.Role;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojos.Registrant;
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


    @FindAll({@FindBy(xpath = "//*[@class='btn-group flex-btn-group-container']//*[text()='Edit']")})
    public List<WebElement> editButtons ;

    @FindBy(xpath = "//*[@name='authorities']")
    public WebElement roleDropdown;



    public WebElement getLastPage(){

        return allPages.get(allPages.size()-1);
    }

    public void findAndActiveUser(){

        WDController.waitAndClick(userActivations.get(allUsers.size()-1));
    }

    public void findUserAndActivate(Registrant registrant){
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getText().equalsIgnoreCase(
                    registrant.getUserName())){
                WDController.waitAndClick(userActivations.get(i));
            }
        }
    }

    public void findUserAndEditActions(Registrant registrant){
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getText().equalsIgnoreCase(
                    registrant.getUserName())){
                WDController.waitAndClick(editButtons.get(i));
            }
        }
    }

    public void selectUserRole(String role){

        if(role.equalsIgnoreCase(Role.ROLE_USER.toString())){
            WDController.selectAnItemFromDropdown(roleDropdown,Role.ROLE_USER.toString() );
        }else if(role.equalsIgnoreCase(Role.ROLE_ADMIN.toString())){
            WDController.selectAnItemFromDropdown(roleDropdown,Role.ROLE_ADMIN.toString() );
        }else if(role.equalsIgnoreCase(Role.ROLE_CUSTOMER.toString())){
            WDController.selectAnItemFromDropdown(roleDropdown,Role.ROLE_CUSTOMER.toString() );
        }else if(role.equalsIgnoreCase(Role.ROLE_EMPLOYEE.toString())){
            WDController.selectAnItemFromDropdown(roleDropdown,Role.ROLE_EMPLOYEE.toString() );
        }else if(role.equalsIgnoreCase(Role.ROLE_MANAGER.toString())){
            WDController.selectAnItemFromDropdown(roleDropdown,Role.ROLE_MANAGER.toString() );
        }else {
            Role.getRoleFromString(role);
        }

    }



}
