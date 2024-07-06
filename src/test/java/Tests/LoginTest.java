package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase
{
    LoginPage loginObject;
    HomePage homeObject;
    @BeforeMethod
    public void  login ()
    {
        loginObject = new LoginPage(driver);
    }
    @Test (priority = 1)
    public void testUsernameAndPasswordFieldsAreExists()
    {
        loginObject.usernameAndPasswordFieldsExists();
        Assert.assertTrue(driver.findElement(loginObject.userNameField).isDisplayed());
        Assert.assertTrue(driver.findElement(loginObject.passwordField).isDisplayed());
    }
    @Test (priority = 2)
    public void testLoginButtonExists()
    {
        loginObject.loginButtonExists();
        Assert.assertTrue(driver.findElement(loginObject.loginButton).isDisplayed());
    }
    @Test(priority = 3)
    public void testUseCredentials()
    {
    loginObject.inputFields("standard_user","secret_sauce");
    Assert.assertTrue(driver.findElement(loginObject.swagLabsLogo).getText().contains("Swag Labs"));
    homeObject = new HomePage(driver);
    homeObject.logout();
    }
    @Test (priority = 4)
    public void testUseInvalidCredentials ()
    {
        loginObject.inputFields("omar","123456");
        Assert.assertTrue(driver.findElement(loginObject.errorMsg).getText()
                .contains("Epic sadface: Username and password do not match any user in this service"));
        loginObject.refreshPage();
    }
    @Test (priority = 5)
    public void testEmptyUsername ()
    {
        loginObject.inputFields("","123456");
        Assert.assertTrue(driver.findElement(loginObject.errorMsg).getText()
                .contains("Epic sadface: Username is required"));
        loginObject.refreshPage();
    }
    @Test (priority = 6)
    public void testEmptyPassword()
    {
        loginObject.inputFields("omar","");
        Assert.assertTrue(driver.findElement(loginObject.errorMsg).getText()
                .contains("Epic sadface: Password is required"));
        loginObject.refreshPage();
    }
    @Test (priority = 7)
    public void testEmptyUsernameAndPassword()
    {
        loginObject.inputFields("","");
        Assert.assertTrue(driver.findElement(loginObject.errorMsg).getText()
                .contains("Epic sadface: Username is required"));
    }

}
