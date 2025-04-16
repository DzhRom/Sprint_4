package test.add.task;

import page.object.OrderPageOne;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class TestLogoScooter {
    private WebDriver driver;

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void TestLogoSccoterChrome(){
        OrderPageOne task = new OrderPageOne(driver);
        task.getUrl(driver);
        task.clickLogoScooter();
        MatcherAssert.assertThat(task.getHeaderScooter(), startsWith("Самокат"));
    }

    @Test
    public void TestLogoYandexChrome(){
        OrderPageOne task = new OrderPageOne(driver);
        task.getUrl(driver);
        task.clickLogoYandex();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        MatcherAssert.assertThat("Ссылка логотипа Яндекс не верна",driver.getTitle(), startsWith("Яндекс — быстрый поиск в интернете"));
        }

    @After
    public void tearDown(){
        driver.quit();
    }
}
