import page.object.OrderPageOne;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class TestButtonOrder {
    private WebDriver driver;

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

    }
    @Test
    public void testUpButtonOrder(){
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        orderPageOne.getUrl(driver);
        orderPageOne.clickUpButtonOder();
        MatcherAssert.assertThat(orderPageOne.getHeaderKogoSamokat(), startsWith("Для кого самокат"));
    }

    @Test
    public void testDownButtonOrder(){
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        orderPageOne.getUrl(driver);
        ((JavascriptExecutor)driver). executeScript("window.scrollTo(0, document.body.scrollHeight)");
        orderPageOne.clickDownButtonOrder();
        MatcherAssert.assertThat(orderPageOne.getHeaderKogoSamokat(), startsWith("Для кого самокат"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
