package test.add.task;

import page.object.OrderPageOne;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestErrorMessage {
    private WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Тест на появление ошибки при вводе невалидного значения в поле адрес
    @Test
    public void testErrorMessageAddress(){
        OrderPageOne order = new OrderPageOne(driver);
        order.getUrlOrder(driver);
        order.fillingAddres("1");
        driver.findElement(By.xpath(".//div[text()='Для кого самокат']")).click();
        assertEquals("нет сообщения *Введите корректный адрес*",   true,order.isErrorAddres());

    }

    //Тест на появление ошибки при вводе невалидного значения в поле имя
    @Test
    public void testErrorMessageName(){
        OrderPageOne order = new OrderPageOne(driver);
        order.getUrlOrder(driver);
        order.fillingName("Е");
        order.clickHead();
        assertEquals("нет сообщения *Введите корректное имя*",true, order.isErrorName());

    }

    //Тест на появления ошибки при вводе невалидного значения в поле Фамилия
    @Test
    public void testErrorMessageSurname(){
        OrderPageOne order = new OrderPageOne(driver);
        order.getUrlOrder(driver);
        order.fillingSurname("W");
        order.clickHead();
        assertEquals("нет сообщения *Введите корректную фамилию*",true, order.isErrorSurname());

    }

    //Тест на появление сообщения ошибки при вводе невалидного значения в поле Телефон
    @Test
    public void testErrorMessagePhone(){
        OrderPageOne order = new OrderPageOne(driver);
        order.getUrlOrder(driver);
        order.fillingPhone("1");
        order.clickHead();
        assertEquals(true, order.isFieldPhone());
    }

    @Test
    public void testErrorMessageMetro(){
        OrderPageOne order = new OrderPageOne(driver);
        order.getUrlOrder(driver);
        order.clickNextStepOrder();
        assertEquals("нет сообщения *Введите корректный номер*",true, order.isErrorMessageMetro());
    }

 @After
    public void tearDown() {
        driver.quit();
 }
}
