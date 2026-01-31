package Pages;

import Framework.Browser;
import Framework.Util.ConfigurationManager;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private WebElement username = DriverManager.getInstance().Driver.findElement(By.id("Email"));
    private WebElement password = DriverManager.getInstance().Driver.findElement(By.id("Password"));
    private WebElement loginButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div/button"));


    public LoginPage(String title){
        super(title);
        Browser.WaitForReady();
    }


    public void enterUsername(String uname){
    Browser.enterValue(username,uname);
    }
    public void enterPassword(String pword){
    Browser.enterValue(password,pword);
    }

    public void clickOnLoginButton(){
        Browser.clickOnElement(loginButton);
    }

}
