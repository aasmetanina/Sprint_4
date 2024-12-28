package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private final WebDriver driver;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //поле Имя в Форме заказа
    public WebElement name() {
        return driver.findElement(By.xpath(".//input[@placeholder='* Имя']"));
    }

    //поле Фамилия в Форме заказа
    public WebElement fullName() {
        return driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']"));
    }

    //поле Адрес в Форме заказа
    public WebElement address() {
        return driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"));
    }

    //поле Станция метровв  Форме заказа
    public WebElement metro() {
        return driver.findElement(By.xpath(".//input[@placeholder='* Станция метро']"));
    }

    public WebElement metroOption(String text) {
        return driver.findElement(By.xpath(String.format(".//li[@class='select-search__row']/button/div[text() = '%s']", text)));
    }

    //поле Телефон в Форме заказа
    public WebElement phoneNumber() {
        return driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"));
    }

    // кнопка "далее" в форме заказа
    public WebElement buttonNext() {
        return driver.findElement(By.className("Button_Middle__1CSJM"));
    }

    //Когда привезти самокат
    public WebElement pikUpTime() {
        return driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']"));
    }

    //Срок аренды
    public WebElement timeToRentOptions() {
        return driver.findElement(By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']"));
    }

    public WebElement timeToRentOption(String text) {
        return driver.findElement(By.xpath(String.format(".//div[@class='Dropdown-option' and text() = '%s']", text)));
    }

    //цвет самоката
    public WebElement color(String text) {
        return driver.findElement(By.xpath(String.format(".//label[@class='Checkbox_Label__3wxSf' and text()='%s']", text)));
    }

    //комментарий для курьера
    public WebElement commentForCourier() {
        return driver.findElement(By.xpath(".//input[@placeholder='Комментарий для курьера']"));
    }

    // кнопка "заказать" в форме заказа
    public WebElement buttonFinishOrder() {
        return driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    }

    // "ДА" в подтверждении заказа
    public WebElement buttonYes() {
        return driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"));
    }

    // "нет" в подтверждении заказа
    public WebElement buttonNo() {
        return driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Нет']"));
    }

    //попап об успешном заказе
    public WebElement successPopUp() {
        return driver.findElement(By.className("Order_ModalHeader__3FDaJ"));
    }

}
