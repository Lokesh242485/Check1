package Framework;

import Framework.Util.ConfigurationManager;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class Browser {

    public static void waitForElementToDisplay(WebElement element){
        Retry(()->element.isDisplayed() && element.isEnabled());
    }

    public static void waitForTitle(String title){
        Retry(()->
                DriverManager.getInstance().getPageTitle().contains(title));
    }

    public static void clickOnElement(WebElement element){
        waitForElementToDisplay(element);
        element.click();
    }

    public static void enterValue(WebElement element, String str){
        waitForElementToDisplay(element);
        element.clear();
        element.sendKeys(str);
    }
    public static void waitUntilAttributeValueIs(WebElement element, String propertyName, String expectedValue){
        Retry(()->element.getAttribute(propertyName).equals(expectedValue));
    }

    public static String getTextFromElement(WebElement element){
        Retry(()-> element.isDisplayed() && element.isEnabled());
        return element.getText();
    }

    public static void WaitForReady(){
        DriverManager.getInstance().pageReady();
    }

    public static void GenerateRendomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();


    }
    private static void Retry(BooleanSupplier function)
    {
        int count = 0;
        Exception exception = null;
        String exceptionMessage = "";
        int retryInterval = Integer.parseInt(ConfigurationManager.getInstance().getProperty("Polling"));
        int timeOut = Integer.parseInt(ConfigurationManager.getInstance().getProperty("Timeout"));
        float temp = ((float) retryInterval/1000) % 60;
        int retryCount = (int) (timeOut/ temp);
        do
        {
            try
            {
                if (function.getAsBoolean()) {
                    return;
                }
                else{
                    Thread.sleep(retryInterval);
                    count++;
                }
            }
            catch (Exception ex)
            {
                exception = ex;
                count++;
            }
        } while (count != retryCount);
        System.out.println(exceptionMessage = "Retry Timed Out while trying to execute - " + new Throwable().getStackTrace()[1].getMethodName());
        throw new RuntimeException(exceptionMessage + exception);
    }

    public static String generateRandomString() {
        // Define the character set from which to generate the random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Initialize a random number generator
        Random random = new Random();

        // Create a StringBuilder to store the random string
        StringBuilder sb = new StringBuilder(8);

        // Generate random characters and append them to the StringBuilder
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        sb= new StringBuilder(sb + "@gmail.com");
        // Convert StringBuilder to a String and return
        return sb.toString();
    }

    public static void selectByVisibleText(WebElement dropdownElement,String visibleText) {
        Select select = new Select(dropdownElement);

        // Select the option with visible text "ABC"
        select.selectByVisibleText(visibleText);
        // Optionally, you can retrieve the selected option to verify
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());
    }

    public static void selectByVisibleTextForDivTypeDropDown (WebElement divDropdown,String visibleText) {


        // Click on the div to open the dropdown (or perform any necessary interactions)
        divDropdown.click();

        // Locate and click on the specific option (e.g., by text) within the div dropdown
        WebElement optionToSelect = divDropdown.findElement(By.xpath("//li[text()="+visibleText+"]"));
        optionToSelect.click();



    }
    public static boolean selectByIndex(WebElement ele,int indexVal) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByIndex(indexVal);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText");
            } else {
                System.out.println("Option not selected by VisibleText");
            }
        }
    }



}