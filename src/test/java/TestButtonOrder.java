import PageObject.OrderPageOne;
import PageObject.OrderPageTwo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class TestButtonOrder {

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @Test
    public void testUpButtonOrderChrome(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
        orderPageOne.clickUpButtonOder();
        MatcherAssert.assertThat(orderPageTwo.getHeaderlyKogoSamokat(), startsWith("Для кого самокат"));
        driver.quit();
    }


    @Test
    public void testDownButtonOrderChrome(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
        ((JavascriptExecutor)driver). executeScript("window.scrollTo(0, document.body.scrollHeight)");
        orderPageOne.clickDownButtonOrder();
        MatcherAssert.assertThat(orderPageTwo.getHeaderlyKogoSamokat(), startsWith("Для кого самокат"));
        driver.quit();
    }

    @Test
    public void testUpButtonOrderFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
        orderPageOne.clickUpButtonOder();
        MatcherAssert.assertThat(orderPageTwo.getHeaderlyKogoSamokat(), startsWith("Для кого самокат"));
        driver.quit();
    }

    @Test
    public void testDownButtonOrderFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
        ((JavascriptExecutor)driver). executeScript("window.scrollTo(0, document.body.scrollHeight)");
        orderPageOne.clickDownButtonOrder();
        MatcherAssert.assertThat(orderPageTwo.getHeaderlyKogoSamokat(), startsWith("Для кого самокат"));
        driver.quit();
    }
}
