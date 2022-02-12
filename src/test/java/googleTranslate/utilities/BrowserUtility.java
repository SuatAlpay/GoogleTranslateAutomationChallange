package googleTranslate.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {

    public static WebElement waitForVisibility(WebElement element, int  timeToWait){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeToWait);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element, int timeToWait){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeToWait);

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitFor(int timeToWait){

        try {
            Thread.sleep(timeToWait * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
