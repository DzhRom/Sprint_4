import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.OrderPageOne;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestImportantQuestions {
    private WebDriver driver;
    private final String answer;
    private final Integer locatorQuestion;
    private final Integer locatorAnswer;

    public TestImportantQuestions(String answer, Integer locatorQuestion, Integer locatorAnswer) {

        this.answer = answer;
        this.locatorQuestion = locatorQuestion;
        this.locatorAnswer = locatorAnswer;
    }

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
    }
    @Parameterized.Parameters
    public static Object[][] parametrsCheckList(){
        return new Object[][]{
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",0, 0},
                { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1, 1},
                { "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2 , 2},
                { "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3, 3},
                { "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4, 4},
                { "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5, 5},
                { "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6, 6},
                { "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7, 7},
        };
    }

    @Test
    public void testImportantQuestionsChrome() {
        OrderPageOne order = new OrderPageOne(driver);
        order.getUrl(driver);
        order.scrollPage(driver);
        order.clickQuestionLocator(locatorQuestion);
        assertEquals(answer, order.answerLocator(locatorAnswer));
      }

    @After
    public void tearDown(){
        driver.quit();
      }
}
