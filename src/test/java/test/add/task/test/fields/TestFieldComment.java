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
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestFieldComment {
    private String comment, testName, Check;
    private WebDriver driver;

    public TestFieldComment(String comment, String testName, String Check) {
        this.comment = comment;
        this.testName = testName;
        this.Check = Check;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {"Комментарий", "11 символом", "Комментарий"},
                {"Р", "Р1 символ", "Р"},
                {"КомментарийКомментарийК", "23 символa", "КомментарийКомментарийК"},
                {"КомментарийКомментарийКо", "24 символа", "КомментарийКомментарийКо"},
                {"КомментарийКомментарийКом", "25 символом", "КомментарийКомментарийКо"},
                {"КомментарийКомментарийКомм", "26 символов", "КомментарийКомментарийКо"},
                {"КомментарийКомментарийКомментарий", "33 символа", "КомментарийКомментарийКом"},
                {"Роман-Роман", "Дефис в имени ", "Роман-Роман"},
                {"Роман Роман", "Пробел в тексте", "Роман Роман"},
                {"Роман12", "Цифры в имени", "Роман12"},
                {"Roman", "Английские буквы", ""},
                {"Ром,ан", "знаки пунктуации в имени", "Ром,ан"},
                {"Ром.ан", "знаки пунктуации", "Ром.ан"},
                {"Ром@ан", "Спецсимволы в имени", "Роман"},
                {"Ром%ан", "Спецсимволы в имени", "Роман"},
                {"Ром^ан", "Спецсимволы в имени", "Роман"},
                {"Ром&ан", "Спецсимволы в имени", "Роман" },
                {"      ", "Одни пробелы в имени", "      "}
        };
    }

    @Test
    public void checkListFieldComment() {
        OrderPageOne task = new OrderPageOne(driver);
        task.getUrlOrder(driver);
        task.pageOneOder();
        assertEquals(testName, Check, task.getValueComment(comment));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
