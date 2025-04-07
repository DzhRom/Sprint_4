import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestImportantQuestionsChrome {
    private final String answer;
    private final String locatorQuestion;
    private final String locatorAnswer;

    public TestImportantQuestionsChrome(String answer, String locatorQuestion, String locatorAnswer) {
        this.answer = answer;
        this.locatorQuestion = locatorQuestion;
        this.locatorAnswer = locatorAnswer;
    }

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
    }
    @Parameterized.Parameters
    public static Object[][] parametrsCheckList(){
        return new Object[][]{
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "accordion__heading-0", ".//div[@id='accordion__panel-0']/p"},
                { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "accordion__heading-1", ".//div[@id='accordion__panel-1']/p"},
                { "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "accordion__heading-2", ".//div[@id='accordion__panel-2']/p"},
                { "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "accordion__heading-3", ".//div[@id='accordion__panel-3']/p"},
                { "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "accordion__heading-4", ".//div[@id='accordion__panel-4']/p"},
                { "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "accordion__heading-5", ".//div[@id='accordion__panel-5']/p"},
                { "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "accordion__heading-6", ".//div[@id='accordion__panel-6']/p"},
                { "Да, обязательно. Всем самокатов! И Москве, и Московской области.", "accordion__heading-7", ".//div[@id='accordion__panel-7']/p"},
        };

    }

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Скролл вниз экрана
        ((JavascriptExecutor)driver). executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.id(locatorQuestion)).click();
        assertEquals(answer, driver.findElement(By.xpath(locatorAnswer)).getText());
        driver.quit();
    }

}
