package test.add.task.test.fields;

import page.object.OrderPageOne;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class TestFieldPhone {
    private String number;
    private String testName;
    private boolean isCheck;
    private WebDriver driver;

    public TestFieldPhone (String number, String testName, boolean isCheck) {
        this.number = number;
        this.testName = testName;
        this.isCheck = isCheck;
    }

    @Before
    public void startUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] parametrs(){
        return new Object[][]{
                {"89998887766", "11 цифр без +", true},
                {"+79998887766", "11 цифр с +", true},
                {"8", "одна цифра", false},
                {"89", "2 цифры", false},
                {"899988877", "9 цифр", false},
                {"8999888776", "10 цифр", false},
                {"89998", "5 цифр", false},
                {"89998887766554433", "17 цифр", false},
                {"899988877665", "12 цифр", false},
                {"8999888776655", "13 цифр", false},
                {"+79998", "5 цифр и +", false},
                {"+", "+", false},
                {"+7", "одна цифра и +", false},
                {"+799988877", "9 цифр и +", false},
                {"+7999888776", "10 цифр и +", false},
                {"+7999888777666555", "16 цифр и +", false},
                {"+799988877665", "12 цифр и +", false},
                {"+7999888776655", "13 цифр и +", false},
                {"+номертелефо", "Русские символы 12", false},
                {"номертелефо", "Русские символы 11", false},
                {"8999 888 77 66", "11 цифр с пробелами", false},
                {"8999@8887766", "спесимволы", false},
                {"8-9998887766", "дефис", false},
                {"8,9998887766", "запятая", false},
                {"8.9998887766", "точка", false},
                {"", "пустая строка", false},
        };
    }

    @Test
    public void testFieldAddress(){
        OrderPageOne task = new OrderPageOne(driver);
        task.getUrlOrder(driver);
        task.clickFieldPhone();
        task.setFieldPhone(number);
        assertNotEquals(testName, isCheck, task.isFieldPhone());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

