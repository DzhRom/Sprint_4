package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageOne {
    private WebDriver driver;
    private By upButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By downButtonOrder = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private By fieldName = By.xpath(".//Input[@placeholder='* Имя']");
    private By fieldSurname = By.xpath(".//Input[@placeholder='* Фамилия']");
    private By fieldAddres = By.xpath(".//Input[@placeholder='* Адрес: куда привезти заказ']");
    private By fieldPhone = By.xpath(".//Input[@placeholder='* Телефон: на него позвонит курьер']");
    private By fieldMetro = By.xpath(".//Input[@placeholder='* Станция метро']");
    private By buttonNextStepOrder = By.xpath(".//button[text()='Далее']");

    public OrderPageOne(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUpButtonOder(){
        driver.findElement(upButtonOrder).click();
    }

    public void clickDownButtonOrder(){
        driver.findElement(downButtonOrder).click();
    }

    public void fillingName(String name){
        Assert.assertTrue(driver.findElement(fieldName).isEnabled());
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
    }

    public void fillingSurname (String surname){
        Assert.assertTrue(driver.findElement(fieldSurname).isEnabled());
        driver.findElement(fieldSurname).clear();
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    public void fillingAddres(String addres){
        Assert.assertTrue(driver.findElement(fieldAddres).isEnabled());
        driver.findElement(fieldAddres).clear();
        driver.findElement(fieldAddres).sendKeys(addres);
    }

    public void fillingPhone(String phone){
        Assert.assertTrue(driver.findElement(fieldPhone).isEnabled());
        driver.findElement(fieldPhone).clear();
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    public void fillingMetro(String metro){
        Assert.assertTrue(driver.findElement(fieldMetro).isEnabled());
        driver.findElement(fieldMetro).sendKeys(metro);
        driver.findElement(By.xpath(".//div[@class='select-search__select']")).click();
    }

    public void clickNextStepOrder(){
        driver.findElement(buttonNextStepOrder).click();
    }

}

