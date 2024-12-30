package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
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
        return driver.findElement(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']"));
    }

    //ввод данных в форму
    public void fillPersonDetailsForm(String nameText, String fullNameText, String addressText, String metroText, String phoneNumberText) {
        WebElement name = name();
        scrollTo(name);
        name.sendKeys(nameText);
        WebElement fullName = fullName();
        fullName.sendKeys(fullNameText);
        WebElement address = address();
        address.sendKeys(addressText);
        WebElement metro = metro();
        metro.click();
        WebElement metroOption = metroOption(metroText);
        scrollTo(metroOption);
        metroOption.click();
        WebElement phoneNumber = phoneNumber();
        phoneNumber.sendKeys(phoneNumberText);
        WebElement buttonNext = buttonNext();
        buttonNext.click();
    }

    public void fillRentDetailsForm(String pikUpTimeText, String timeToRentText, String colorText, String commentForCourierText) {
        WebElement pikUpTime = pikUpTime();
        pikUpTime.sendKeys(pikUpTimeText);
        pikUpTime.sendKeys(Keys.ENTER);
        WebElement timeToRent = timeToRentOptions();
        waitUntilClickable(timeToRent);
        timeToRent.click();
        WebElement timeToRentOption = timeToRentOption(timeToRentText);
        timeToRentOption.click();
        WebElement color = color(colorText);
        color.click();
        WebElement commentForCourier = commentForCourier();
        commentForCourier.sendKeys(commentForCourierText);
        WebElement buttonFinishOrder = buttonFinishOrder();
        buttonFinishOrder.click();
    }

    public void confirmOrder() {
        WebElement buttonYes = buttonYes();
        waitUntilClickable(buttonYes);
        buttonYes.click();
    }

    public boolean orderSuccessful() {
        return successPopUp().isDisplayed();
    }

}
