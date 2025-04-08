import PageObject.PageObjectAddTask;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class TestLogoScooter {

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void TestLogoSccoterChrome(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        PageObjectAddTask task = new PageObjectAddTask(driver);
        task.clickLogoScooter();
        MatcherAssert.assertThat(task.getHeaderScooter(), startsWith("Самокат"));
        driver.quit();
    }

    @Test
    public void TestLogoSccoterFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        PageObjectAddTask task = new PageObjectAddTask(driver);
        task.clickLogoScooter();
        MatcherAssert.assertThat(task.getHeaderScooter(), startsWith("Самокат"));
        driver.quit();
    }

    @Test
    public void TestLogoYandexChrome(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        PageObjectAddTask task = new PageObjectAddTask(driver);
        task.clickLogoYandex();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        MatcherAssert.assertThat("Ссылка логотипа Яндекс не верна",driver.getTitle(), startsWith("Яндекс — быстрый поиск в интернете"));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        driver.quit();

    }

}
