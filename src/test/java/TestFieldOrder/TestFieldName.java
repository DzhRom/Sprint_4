package TestFieldOrder;

import PageObject.PageObjectAddTask;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class TestFieldName {
    private String name;
    private String testName;
    private boolean isCheck;

    public TestFieldName(String name, String testName, boolean isCheck) {
        this.name = name;
        this.testName = testName;
        this.isCheck = isCheck;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {"Роман", "Русские буквы 5 символом", true},
                {"Ро", "Русские буквы 2 символa", true},
                {"Ром", "Русские буквы 3 символa", true},
                {"РоманРоманРома", "Русские буквы  14 символом", true},
                {"РоманРоманРоман", "Русские буквы  15 символом", true},
                {"РОМАН", "Заглавные буквы", true},
                {"роман", "строчные буквы", true},
                {"Роман-Роман", "Дефис в имени ", true},
                {"Роман Роман", "Пробел в тексте", true},
                {"Р", "Русские буквы 1 символ", false},
                {"Романроманроманроман", "Русские буквы 20 символом", false},
                {"РоманРоманРоманР", "Русские буквы 16 символом", false},
                {"Роман12", "Цифры в имени", false},
                {"Roman", "Английские буквы", false},
                {"Ром,ан", "знаки пунктуации в имени", false},
                {"Ром.ан", "знаки пунктуации", false},
                {"Ром@ан", "Спецсимволы в имени", false},
                {"Ром%ан", "Спецсимволы в имени", false},
                {"Ром^ан", "Спецсимволы в имени", false},
                {"Ром&ан", "Спецсимволы в имени", false},
                {"      ", "Одни пробелы в имени", false}
        };
    }

    @Test
    public void checkListFieldName() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        PageObjectAddTask task = new PageObjectAddTask(driver);
        // OrderPageOne orderPageOne = new OrderPageOne(driver);
        task.clickFieldName();
        task.setFieldName(name);
        assertNotEquals(testName, isCheck, task.isErrorName());

        driver.quit();
    }
}