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


     //When I use git, I need to use only my branch and make updates on my branch
    // Sabah ilk is checkout to master/develop
    //git pull yapiyoruz: dikkat etmemiz gereken yeni updateler var mi?
    //Eger varsa checkout to my branch / then git merge master, calismaya devam veya kendi kodumuzu remote branchimize tasiyoruz
    //Eger update yoksa, calismaya devam ve kendi updatelerimizi kendi remote branchimize push ediyoruz

    ///Komutlar ile
    //ilk is
    // git checkout master
    //2
    //git pull
    //3. eger master da yeni update varsa
    //git checkout myBranch
    //git merge master
    //4.eger master da update yoksa
    //git checkout myBranch
    //kodlarimiz hazir ise
    //git push

    //Note: yukaridaki bilgileri git kullaniminda  surekli kullanacagimiz icin not dustuk



}
