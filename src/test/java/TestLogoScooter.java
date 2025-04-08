import PageObject.PageObjectAddTask;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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





}
