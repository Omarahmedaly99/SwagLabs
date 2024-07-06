package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase
{
    public LoginPage(WebDriver driver) {this.driver=driver;}
    public By userNameField = By.id("user-name");
    public By passwordField = By.id("password");
    public By loginButton = By.id("login-button");
    public By swagLabsLogo = By.xpath("//*[@class=\"app_logo\"]");
    public By errorMsg = By.xpath("//*[@data-test=\"error\"]");

    public void usernameAndPasswordFieldsExists ()
    {
        waitForElementWithLocatorToBeVisible(driver,userNameField);
        driver.findElement(userNameField).isDisplayed();
        waitForElementWithLocatorToBeVisible(driver,passwordField);
        driver.findElement(passwordField).isDisplayed();
    }
    public void loginButtonExists ()
    {
        waitForElementWithLocatorToBeVisible(driver,loginButton);
        driver.findElement(loginButton).isDisplayed();;
    }
    public void inputFields (String userName , String pass)
    {
        waitForElementWithLocatorToBeVisible(driver,userNameField);
        setTextElementText(userNameField,userName);
        waitForElementWithLocatorToBeVisible(driver,passwordField);
        setTextElementText(passwordField,pass);
        waitForElementWithLocatorToBeVisible(driver,loginButton);
        clickButton(loginButton);
    }
    public void refreshPage ()
    {
        driver.navigate().refresh();
    }
}
