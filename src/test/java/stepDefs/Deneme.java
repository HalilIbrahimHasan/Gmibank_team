package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import utilities.WDController;

public class Deneme {


    public static void main(String[] args) {

        WDController.getDriver().get("https://gmibank.com/");
        LoginPage login = new LoginPage();

        WDController.waitAndClick(login.loginDropdown);

        WDController.waitAndClick(login.signInButton, 10);











    }


    public static WebDriver getDriver(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }

        return null;


    }






}
