package Pages;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewCustomerPage extends BasePage{

    private WebElement newCustEmailID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='form-control text-box single-line' and @id='Email']"));
    private WebElement newCustPassword = DriverManager.getInstance().Driver.findElement(By.id("Password"));
    private static WebElement newCustFirstName = DriverManager.getInstance().Driver.findElement(By.id("FirstName"));
    private static WebElement newCustLastName = DriverManager.getInstance().Driver.findElement(By.id("LastName"));
    private static WebElement newCustGenderMale = DriverManager.getInstance().Driver.findElement(By.id("Gender_Male"));
    private static WebElement newCustGenderFemale= DriverManager.getInstance().Driver.findElement(By.id("Gender_Female"));
    private static WebElement newCustDOB = DriverManager.getInstance().Driver.findElement(By.id("DateOfBirth"));
    private static WebElement newCustCompany = DriverManager.getInstance().Driver.findElement(By.id("Company"));
    private static WebElement newCustIsTexExampt = DriverManager.getInstance().Driver.findElement(By.id("IsTaxExempt"));
    private static WebElement newNewsLetter = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='k-reset' and @id='SelectedNewsletterSubscriptionStoreIds_taglist']/parent::div[@class='k-multiselect-wrap k-floatwrap']"));
    private static WebElement newCustRoles = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='k-reset' and @id='SelectedCustomerRoleIds_taglist']/parent::div[@class='k-multiselect-wrap k-floatwrap']"));
    private static WebElement newCustManagerOfVendor = DriverManager.getInstance().Driver.findElement(By.id("VendorId"));
    private static WebElement AdminComment = DriverManager.getInstance().Driver.findElement(By.id("AdminComment"));
    private static WebElement saveBtn = DriverManager.getInstance().Driver.findElement(By.name("save"));

    public static String newCustEmail=Browser.generateRandomString()+"gmail.com";
    public NewCustomerPage(String title) {
        super(title);
        Browser.WaitForReady();
    }



   public void enterNewCustEmail(String emailID) {

        Browser.enterValue(newCustEmailID,emailID);
    }

    public void enterNewCustPassword(String str){

        Browser.enterValue(newCustPassword,str);
    }

    public static void enterNewCustFirstName(String str){

        Browser.enterValue(newCustFirstName,str);
    }

    public static void enterNewCustLastName(String str){

        Browser.enterValue(newCustLastName,str);
    }
    public static void entnewCustGender(String str){

        if(str.equals("Male")) {

            Browser.clickOnElement(newCustGenderMale);
        }
        else {
            Browser.clickOnElement(newCustGenderFemale);
        }
    }



    public static void enternewCustDOB(String str){

        Browser.enterValue(newCustDOB,str);
    }
    public static void enternewCustCompany(String str){

        Browser.enterValue(newCustCompany,str);
    }
    public static void enternewCustIsTexExampt(String str){

        Browser.clickOnElement(newCustIsTexExampt);
    }
    public static void enternewNewsLetter(String str){

        Browser.enterValue(newNewsLetter,str);
    }
    public static void enternewCustRoles(String str){

        Browser.selectByIndex(newCustRoles,2);
    }
    public static void enterNewCustManagerOfVendor(String str){

        Browser.selectByIndex(newCustManagerOfVendor,2);
    }
    public static void enterAdminComment(String str){

        Browser.enterValue(AdminComment,str);
    }
    public static void clickOnSaveBtn(){

        Browser.clickOnElement(saveBtn);
    }
}
