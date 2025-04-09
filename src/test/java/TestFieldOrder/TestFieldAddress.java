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
public class TestFieldAddress {
    private String address;
    private String testName;
    private boolean isCheck;

    public TestFieldAddress(String address, String testName, boolean isCheck) {
        this.address = address;
        this.testName = testName;
        this.isCheck = isCheck;
    }

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
    }
    @Parameterized.Parameters
    public static Object[][] parameters(){
        return new Object[][]{
                {"АдресАдрес", "Русские символы 10", true},
                {"Адрес", "Русские символы 5", true},
                {"АдресА", "Русские символы 6", true},
                {"АдресАдресАдресАдресАдресАдресАдресАдресАдресАдре", "Русские символы 49", true},
                {"АдресАдресАдресАдресАдресАдресАдресАдресАдресАдрес", "Русские символы 50", true},
                {"А", "Русские символы 1 ", false},
                {"Ад", "Русские символы 2 ", false},
                {"Адр", "Русские символы 3 ", false},
                {"Адре", "Русские символы 4 ", false},
                {"АдресАдресАдресАдресАдресАдресАдресАдресАдресАдресАдресАдрес", "Русские символы 60", false},
                {"АдресАдресАдресАдресАдресАдресАдресАдресАдресАдресА", "Русские символы 51", false},
                {"Адрес-Адрес", "дефис", true},
                {"Адрес,", "знаки пунктуации", true},
                {"Адрес.", "знаки пунктуации", true},
                {"Адрес адрес", "Ввод пробела в середине текста", true},
                {"Адрес 12", "Ввод цифр", true},
                {"АДРЕС", "заглавные", true},
                {"адрес", "прописные", true},
                {"address", "английские буквы", false},
                {"     ", "пробелы", false},
                {"", "пустая строка", false}
        };

    }

    @Test
    public void TestFieldAddress(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        PageObjectAddTask task = new PageObjectAddTask(driver);
        task.clickFieldAddres();
        task.setFieldAddres(address);
        assertNotEquals(testName, isCheck, task.isFieldAddres());
        driver.quit();
    }
}
