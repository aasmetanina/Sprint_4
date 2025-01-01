import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class OrderTest extends BaseScooterTest {

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

    @Test
    public void positiveOrder() {
        if (this.button.equals("buttonTop")) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        orderPage.fillPersonDetailsForm(name, fullName, address, metro, phoneNumber);
        orderPage.fillRentDetailsForm(pikUpTime, timeToRent, color, commentForCourier);
        orderPage.confirmOrder();

        Assert.assertTrue(orderPage.orderSuccessful());
    }
}

