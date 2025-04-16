package test.add.task;

import page.object.OrderPageOne;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestNoFoundOrder {
    private WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }
// Тест: если ввести в поле ввода номер существующего заказа, то попадем на страницу Статус заказа
    @Test
    public void testFoundOrder() {
        OrderPageOne task = new OrderPageOne(driver);
        task.pageOneOder();
        task.clickAndSetWhenArrive("20.08.2025");
        task.clickAndSetRentalPeriod();
        task.choiceColor("grey");
        task.clickButtonEndOrder();
        task.clickButtonYesOrder();
        task.showOrder();
        String number = task.getNumberOrder();
       assertEquals(task.isFoundOeder(), number);
    }

    //Тест на появление картинки с надписью "Такого заказа нет", если ввести неверный номер заказа
    @Test
    public void testNoFoundOrder() {
        OrderPageOne task = new OrderPageOne(driver);
        task.getUrl(driver);
        task.setStatusOrder("1");
        assertTrue("Картинка не найдена",task.isImgNoFound());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}