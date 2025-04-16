import page.object.OrderPageOne;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class TestOrder {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String metro;
    private final String dataArrive;
    private final String color;
    private  final String comment;

    public TestOrder(String name, String surname, String address,
                           String phone, String metro, String dataArrive,
                           String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.dataArrive = dataArrive;
        this.color = color;
        this.comment = comment;
    }

    @Before
    public void startUp(){
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Parameterized.Parameters
    public static Object[][] parameters(){
        return new Object[][]{
                {"Роман", "Романов", "Москва ул Большаковой 132", "89209996299",
                        "Раменки", "20.08.2025", "grey",
                        "Первый тестовый заказ"},
                {"Станислав", "Задорнов", "Саратов Ленина 143", "+79998886533",
                        "Чистые пруды", "20.04.2025", "black",
                        "Второй тестовый заказ"}
        };
    }

    @Test
    public void testOrder(){
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        orderPageOne.getUrl(driver);
        orderPageOne.order( name,surname,address,phone,metro, dataArrive,color,comment);
        MatcherAssert.assertThat("Заказ не оформлен: окно Заказ оформлен не появилось", orderPageOne.getOrderCreated(), startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}