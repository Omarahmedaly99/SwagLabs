package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase
{
    public HomePage (WebDriver driver){this.driver=driver;}
    private final By menuBtn = By.id("react-burger-menu-btn");
    private final By logout = By.id("logout_sidebar_link");
    public void logout ()
    {
        clickButton(menuBtn);
        clickButton(logout);
    }
}
