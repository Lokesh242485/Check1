package Framework.Root;

import Framework.Util.ConfigurationManager;
import Pages.*;

import java.io.IOException;

public class AdminDemoUIApp {

    public static DashboardPage dashboardPage() {

        return new DashboardPage("Dashboard / nopCommerce administration");
    }

    public static LoginPage loginPage() {
        return new LoginPage("Your store. Login");
    }

    public static ProductsPage productsPage() {
        return new ProductsPage("Products / nopCommerce administration");
    }

    public static TaxSettingsPage taxSettingsPage(){
        return new TaxSettingsPage("Tax settings / nopCommerce administration");
    }

    public static CustomersPage customersPage(){
        return new CustomersPage("Customers / nopCommerce administration");
    }

    public static NewCustomerPage newCustomersPage(){
        return new NewCustomerPage("Add a new customer / nopCommerce administration");
    }


    public static NavigationPane navigationPane(){
        return new NavigationPane();
    }
}
