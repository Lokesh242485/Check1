package StepDefinitions;

import Framework.Root.AdminDemoUIApp;
import Framework.Util.LoggingUtils;
import io.cucumber.java.en.*;

public class PageNavigationStepDefinition {
    @When("I click on {string} link on MainNavTreeMenu")
    public void i_click_on_link_on_main_nav_tree_menu(String link) {
        switch (link) {
            case "Products":
                AdminDemoUIApp.navigationPane().expandMainNavTreeInSideMenu("Catalog");
                LoggingUtils.debug("Catalog is selected");
                AdminDemoUIApp.navigationPane().clickOnPageNavigationLinkInMainNavTreeMenu(link);
                LoggingUtils.debug("Products is selected");
                break;
            case "Tax settings":
                AdminDemoUIApp.navigationPane().expandMainNavTreeInSideMenu("Configuration");
                LoggingUtils.debug("Configuration is selected");
                AdminDemoUIApp.navigationPane().expandSubNavTreeInSideMenu("Settings");
                LoggingUtils.debug("Settings is selected");
                AdminDemoUIApp.navigationPane().clickOnPageNavigationLinkInSubNavTreeMenu(link);
                LoggingUtils.debug("Tax setting is selected ");
                break;
            case "Customers":
                AdminDemoUIApp.navigationPane().expandMainNavTreeInSideMenu("Customers");
                LoggingUtils.debug("Customers is selected");
                AdminDemoUIApp.navigationPane().clickOnPageNavigationLinkInMainNavTreeMenu(link);
                LoggingUtils.debug("Customers--> Customers is selected");
                break;
        }
    }

    @And("I am navigate to {string} page")
    public void i_am_navigate_to_link_page(String page) {
        switch (page){
            case "Products":
                AdminDemoUIApp.productsPage().VerifyProductsPageIsDisplayed();
                LoggingUtils.debug("Product Page is Reached");
                break;
            case "Tax settings":
                AdminDemoUIApp.taxSettingsPage().VerifyTaxSettingsPageIsDisplayed();
                LoggingUtils.debug("Tax settings Page is Reached");
                break;
            case "Customers":
                AdminDemoUIApp.customersPage().VerifyCustomersPageIsDisplayed();
                LoggingUtils.debug("Customers Page is Reached");
                break;
        }

    }

}
