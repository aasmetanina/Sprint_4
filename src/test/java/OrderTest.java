import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;
import pom.OrderPage;
import utils.WebUtils;


@RunWith(Parameterized.class)
public class OrderTest {

    private final String name;
    private final String fullName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String pikUpTime;
    private final String timeToRent;
    private final String color;
    private final String commentForCourier;
    private final String button;

    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;
    private WebUtils webUtils;


    public OrderTest(String button, String name, String fullName, String address, String metro, String phoneNumber, String pikUpTime, String timeToRent, String color, String commentForCourier) {
        this.button = button;
        this.name = name;
        this.fullName = fullName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.pikUpTime = pikUpTime;
        this.timeToRent = timeToRent;
        this.color = color;
        this.commentForCourier = commentForCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getFormData() {
        return new Object[][]{
                {"buttonTop", "Анна", "Иванова", "Гагарина 10", "Черкизовская", "+79877656556", "30.12.2024", "трое суток", "чёрный жемчуг", "спасибо"},
                {"buttonBottom", "Анна", "Иванова", "Гагарина 10", "Черкизовская", "+79877656556", "30.12.2024", "трое суток", "чёрный жемчуг", "спасибо"},
                {"buttonTop", "Яна", "Петрова", "Ленина 20", "Комсомольская", "+79200656556", "31.12.2024", "сутки", "серая безысходность", "до встречи"},
                {"buttonBottom", "Яна", "Петрова", "Ленина 20", "Комсомольская", "+79200656556", "31.12.2024", "сутки", "серая безысходность", "до встречи"}
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        webUtils = new WebUtils(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void positiveOrder() {
        WebElement button = this.button.equals("buttonTop") ? mainPage.buttonOrderTop() : mainPage.buttonOrderBottom();
        webUtils.scrollTo(button);
        button.click();

        WebElement name = orderPage.name();
        webUtils.scrollTo(name);
        name.sendKeys(this.name);
        WebElement fullName = orderPage.fullName();
        fullName.sendKeys(this.fullName);
        WebElement address = orderPage.address();
        address.sendKeys(this.address);
        WebElement metro = orderPage.metro();
        metro.click();
        WebElement metroOption = orderPage.metroOption(this.metro);
        webUtils.scrollTo(metroOption);
        metroOption.click();
        WebElement phoneNumber = orderPage.phoneNumber();
        phoneNumber.sendKeys(this.phoneNumber);
        WebElement buttonNext = orderPage.buttonNext();
        buttonNext.click();

        WebElement pikUpTime = orderPage.pikUpTime();
        pikUpTime.sendKeys(this.pikUpTime);
        pikUpTime.sendKeys(Keys.ENTER);
        WebElement timeToRent = orderPage.timeToRentOptions();
        webUtils.waitUntilClickable(timeToRent);
        timeToRent.click();
        WebElement timeToRentOption = orderPage.timeToRentOption(this.timeToRent);
        timeToRentOption.click();
        WebElement color = orderPage.color(this.color);
        color.click();
        WebElement commentForCourier = orderPage.commentForCourier();
        commentForCourier.sendKeys(this.commentForCourier);
        WebElement buttonFinishOrder = orderPage.buttonFinishOrder();
        buttonFinishOrder.click();

        WebElement buttonYes = orderPage.buttonYes();
        webUtils.waitUntilClickable(buttonYes);
        buttonYes.click();

        Assert.assertTrue(orderPage.successPopUp().isDisplayed());
    }

}

