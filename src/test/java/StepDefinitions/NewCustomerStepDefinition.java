package StepDefinitions;

import Framework.Browser;
import Framework.Data.DataManager;
import Framework.Root.AdminDemoUIApp;
import Framework.Util.LoggingUtils;
import Pages.NewCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class NewCustomerStepDefinition {
    @And("I enter Email id of New Customer")
    public void iEnterEmailIdOfNewCustomer() throws IOException {
        AdminDemoUIApp.newCustomersPage().enterNewCustEmail(NewCustomerPage.newCustEmail);
        LoggingUtils.info("Performing action: enter Email id of New Customer");
    }
    @And("I enter Password of New Customer")
    public void iEnterPasswordOfNewCustomer() throws IOException {
        AdminDemoUIApp.newCustomersPage().enterNewCustPassword(DataManager.excelReader("Password",1));
        LoggingUtils.info("Performing action: enter Password of New Customer");
    }

    @And("I enter First Name")
    public void iEnterFirstName() throws IOException {
        NewCustomerPage.enterNewCustFirstName(DataManager.excelReader("FirstName",1));
        //AdminDemoUIApp.newCustomersPage().enterNewCustFirstName(DataManager.excelReader("FirstName",1));
        LoggingUtils.info("Performing action: enter First Name");
    }

    @And("I enter Last Name")
    public void iEnterLastName() throws IOException {
        NewCustomerPage.enterNewCustFirstName(DataManager.excelReader("LastName",1));
        //AdminDemoUIApp.newCustomersPage().enterNewCustLastName(DataManager.excelReader("LastName",1));
        LoggingUtils.info("Performing action: enter Last Name");
    }

    @And("I select Gender")
    public void iSelectGender() throws IOException {
        NewCustomerPage.entnewCustGender(DataManager.excelReader("Gender",1));

        //AdminDemoUIApp.newCustomersPage().entnewCustGender(DataManager.excelReader("Gender",1));
        LoggingUtils.info("Performing action: select Gender");
    }

    @And("I enter Date of Birth")
    public void iEnterDateOfBirth() throws IOException {
        NewCustomerPage.entnewCustGender(DataManager.excelReader("RegistrationDateTo",1));

        //AdminDemoUIApp.newCustomersPage().enternewCustDOB(DataManager.excelReader("RegistrationDateTo",1));
        LoggingUtils.info("Performing action: enter Date of Birth");
    }

    @And("I enter Company Name")
    public void iEnterCompanyName() throws IOException {
        NewCustomerPage.entnewCustGender(DataManager.excelReader("CompanyName",1));

        //AdminDemoUIApp.newCustomersPage().enternewCustCompany(DataManager.excelReader("CompanyName",1));
        LoggingUtils.info("Performing action: enter Company Name");
    }

    @And("I select Save Button")
    public void iSelectSaveButton() throws IOException {
        NewCustomerPage.clickOnSaveBtn();
        //AdminDemoUIApp.newCustomersPage().clickOnSaveBtn();
        LoggingUtils.info("Performing action: Save Button");
        DataManager.writeEmailToExcel(NewCustomerPage.newCustEmail);
    }



}
