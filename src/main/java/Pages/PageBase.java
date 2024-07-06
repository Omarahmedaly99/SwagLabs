package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase
{
    public WebDriver driver ;
    public WebDriverWait wait;
    long seconds = 30;

    public void clickButton (By button)
    {
        driver.findElement(button).click();
    }

    public void setTextElementText(By textElement , String value)
    {
        driver.findElement(textElement).sendKeys(value);
    }
    public void waitForElementWithLocatorToBeVisible(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clearDataFromInputField(By element) {
        driver.findElement(element).clear();
    }

}
