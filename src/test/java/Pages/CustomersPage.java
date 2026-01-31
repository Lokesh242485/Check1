package Pages;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomersPage extends BasePage{
    private WebElement custEmail= DriverManager.getInstance().Driver.findElement(By.id("SearchEmail"));
    private WebElement firstName= DriverManager.getInstance().Driver.findElement(By.id("SearchFirstName"));
    private WebElement lastName= DriverManager.getInstance().Driver.findElement(By.id("SearchLastName"));
    private WebElement brithMonth= DriverManager.getInstance().Driver.findElement(By.id("SearchMonthOfBirth"));
    private WebElement birthDate= DriverManager.getInstance().Driver.findElement(By.id("SearchDayOfBirth"));
    private WebElement regDateFrom= DriverManager.getInstance().Driver.findElement(By.id("SearchRegistrationDateFrom"));
    private WebElement regDateTo= DriverManager.getInstance().Driver.findElement(By.id("SearchRegistrationDateTo"));
    private WebElement lastActivityFrom= DriverManager.getInstance().Driver.findElement(By.id("SearchLastActivityFrom"));
    private WebElement lastActivityTo= DriverManager.getInstance().Driver.findElement(By.id("SearchLastActivityTo"));
    private WebElement companyName= DriverManager.getInstance().Driver.findElement(By.id("SearchCompany"));
    private WebElement ipAddress= DriverManager.getInstance().Driver.findElement(By.id("SearchIpAddress"));
    private WebElement customerRole= DriverManager.getInstance().Driver.findElement(By.id("SelectedCustomerRoleIds"));
    private WebElement addNewBtn= DriverManager.getInstance().Driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
    private WebElement dashboard = DriverManager.getInstance().Driver.findElement(By.xpath("//h1[@class='float-left' and contains(text(),'Customers')]"));


    public CustomersPage(String title){
        super(title);
        Browser.WaitForReady();
    }
    public void VerifyCustomersPageIsDisplayed(){

        Browser.waitForElementToDisplay(dashboard);
    }
    public void enterCustEmail(String email){

        Browser.enterValue(custEmail,email);
    }

    public void enterCustFirstName(String fname){

        Browser.enterValue(firstName,fname);
    }
    public void enterCustLastName(String lname){

        Browser.enterValue(lastName,lname);
    }

    public void enterBrithMonth(String bmonth){

        Browser.selectByVisibleText(brithMonth,bmonth);
    }

    public void enterBirthDate(String bdate){

        Browser.selectByVisibleText(birthDate,bdate);
    }
    public void enterRegDateFrom(String datefrom){

        Browser.enterValue(regDateFrom,datefrom);
    }
    public void enterRegDateTo(String dateto){

        Browser.enterValue(regDateTo,dateto);
    }
    public void enterLastActivityFrom(String datefrom){

        Browser.enterValue(lastActivityFrom,datefrom);
    }
    public void enterLastActivityTo(String dateto){

        Browser.enterValue(lastActivityTo,dateto);
    }
    public void enterCompanyName(String cmpname){

        Browser.enterValue(companyName,cmpname);
    }
    public void enterIpAddress(String ipadd){

        Browser.enterValue(ipAddress,ipadd);
    }

    public void entercustomerRole(String crole){

        Browser.selectByVisibleText(customerRole,crole);
    }

    public void clickOnAddNewButton(){
        Browser.clickOnElement(addNewBtn);
        System.out.println("Add New button clicked");
    }



}
