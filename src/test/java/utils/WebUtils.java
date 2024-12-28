package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
    private final WebDriver driver;


    public WebUtils(WebDriver driver) {
        this.driver = driver;
    }

    //скролл до элемента
    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilClickable(WebElement element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
    }

}
