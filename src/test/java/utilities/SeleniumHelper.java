package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;

public class SeleniumHelper {

    WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Method for handling dropdown
    public void selectDropdownByValue(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public void selectDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Method for handling alerts
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    // Method for mouse actions (hover, right-click, double-click)
    public void hoverOnElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void rightClickOnElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).perform();
    }

    public void doubleClickOnElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.doubleClick(element).perform();
    }

    // Method for handling multiple windows
    public void switchToWindowByTitle(String windowTitle) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(windowTitle)) {
                return;
            }
        }
        driver.switchTo().window(currentWindow);  // Switch back if no match found
    }

    public void switchToWindowByIndex(int index) {
        Set<String> allWindows = driver.getWindowHandles();
        int count = 0;
        for (String window : allWindows) {
            if (count == index) {
                driver.switchTo().window(window);
                break;
            }
            count++;
        }
    }

    // Method for handling iframes
    public void switchToIframeByIdOrName(String idOrName) {
        driver.switchTo().frame(idOrName);
    }

    public void switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToIframeByElement(By locator) {
        WebElement iframeElement = driver.findElement(locator);
        driver.switchTo().frame(iframeElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}

