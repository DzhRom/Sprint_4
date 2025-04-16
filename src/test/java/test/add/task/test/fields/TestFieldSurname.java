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
public class TestFieldSurname {
    private String surname;
    private String testName;
    private boolean isCheck;
    private WebDriver driver;

    public TestFieldSurname(String surname, String testName, boolean isCheck) {
        this.surname = surname;
        this.testName = testName;
        this.isCheck = isCheck;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public  static Object[][] parametersSurname() {
        return new Object[][]{
                {"Фа", "Русские буквы 2 символа", true},
                {"Фам", "Русские буквы 3 символа", true},
                {"ФамилияФамилия", "Русские буквы 14 символом", true},
                {"ФамилияФамилияФ", "Русские буквы 15 символом", true},
                {"Ф", "Русские буквы 1 символ", false},
                {"ФамилияФамилияФамилия", "Русские буквы 20 символом", false},
                {"ФамилияФамилияФа", "Русские буквы 16 символом", false},
                {"ФамилияФамилияФам", "Русские буквы 17 символом", false},
                {"Фамилия Фами", "Пробел в Фамилии", true},
                {"Фам-Фам", "Дефис в фамилии", true},
                {"Фамилия12", "Цифры в фамилии", false},
                {"Family", "английские буквы", false},
                {"Фамили,я", "знаки препинания", false},
                {"Фамили.я", "знаки препинания", false},
                {"Фам?лилия", "Спецсимволы", false},
                {"Фам@лилия", "Спецсимволы", false},
                {"ФАМИЛИЯ", "заглавные буквы", true},
                {"фамилия", "строчные буквы", true},
                {"     ", "пробелы", false}
        };
    }

    @Test
    public void checkListFielSurname() {
        OrderPageOne task = new OrderPageOne(driver);
        task.getUrlOrder(driver);
        task.clickFieldSurname();
        task.setFieldSurname(surname);
        assertNotEquals(testName, isCheck, task.isErrorSurname());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
