
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
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

}
