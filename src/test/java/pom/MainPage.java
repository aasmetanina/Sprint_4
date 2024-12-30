
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Вопросы
    public WebElement question(String text) {
        return driver.findElement(By.xpath(String.format(".//div[@class='accordion__button' and text()='%s']", text)));
    }

    //Ответы на вопросы
    public WebElement answer(String text) {
        return driver.findElement(By.xpath(String.format(".//div[@class='accordion__panel']/p[text()='%s']", text)));
    }

    //кнопка "Заказать" в шапке
    public WebElement buttonOrderTop() {
        return driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']"));
    }

    //кнопка "Заказать" в "Как это работает" ()
    public WebElement buttonOrderBottom() {
        return driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    }

    //клик на кнопку "Заказть" в шапке
    public void clickOrderButtonTop() {
        WebElement button = buttonOrderTop();
        scrollTo(button);
        button.click();
    }

    //клик на кнопку "Заказть" в вопросах
    public void clickOrderButtonBottom() {
        WebElement button = buttonOrderBottom();
        scrollTo(button);
        button.click();
    }

}
