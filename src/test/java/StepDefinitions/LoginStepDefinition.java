package StepDefinitions;

import Framework.Root.AdminDemoUIApp;
import Framework.Util.ConfigurationManager;
import Framework.Util.LoggingUtils;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.SearchContext;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginStepDefinition {
  // Check Login 1

    Logger logger = Logger.getLogger("LoginStepDefinition.java");// LogManager.getLogManager().getLogger("LoginStepDefinition.java");

@Given("I navigate to admin demo website")
public void i_navigate_to_admin_demo_website() {
    LoggingUtils.debug("User is Navigated to admin demo website");
}

@Given("I enter user credentials")
public void i_enter_user_credentials() {
    //logger.info("Running: given step ####################");
    AdminDemoUIApp.loginPage().enterUsername(ConfigurationManager.getInstance().getProperty("username"));
    AdminDemoUIApp.loginPage().enterPassword(ConfigurationManager.getInstance().getProperty("password"));
    LoggingUtils.debug("User entered user credentials");
}

@When("I click on login button")
public void i_click_on_login_button() {

    AdminDemoUIApp.loginPage().clickOnLoginButton();
    LoggingUtils.debug("User clicked on Login Button");

}

@Then("I am navigated to dashboard page")
public void i_am_navigated_to_dashboard_page() {

    AdminDemoUIApp.dashboardPage().VerifyDashboardPageIsDisplayed();
    LoggingUtils.debug("User is navigated to dashboard page");
}
}
