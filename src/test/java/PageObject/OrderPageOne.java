package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageOne {
    private WebDriver driver;
    private By UpButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By fieldName = By.xpath(".//Input[@placeholder='* Имя']");
    private By fieldSurname = By.xpath(".//Input[@placeholder='* Фамилия']");
    private By fieldAddres = By.xpath(".//Input[@placeholder='* Адрес: куда привезти заказ']");
    private By fieldPhone = By.xpath(".//Input[@placeholder='* Телефон: на него позвонит курьер']");
    private By fieldMetro = By.xpath(".//Input[@placeholder='* Станция метро']");
    private By buttonNextStepOrder = By.xpath(".//button[text()='Далее']");
    private By fieldWhenArrive = By.xpath(".//input[@placeholder=\"* Когда привезти самокат\"]");
    private By rentalPeriod = By.xpath(".//div[text()='* Срок аренды']");
    private By commentOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By buttonEndOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By buttonYesOrder = By.xpath(".//button[text()='Да']");
    private By orderCreated = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public OrderPageOne(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUpButtonOder(){
        driver.findElement(UpButtonOrder).click();
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

    public void clickAndSetWhenArrive(String dataArrive){
        driver.findElement(fieldWhenArrive).sendKeys(dataArrive);
        driver.findElement(By.xpath(".//div[text()='Про аренду']")).click();
    }

    public void clickAndSetRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']")).click();
    }

    public void choiceColor(String color){
        if(color.equals("black")){
            driver.findElement(By.xpath(".//input[@id='black']")).click();
        } else if (color.equals("grey")){
            driver.findElement(By.xpath(".//input[@id='grey']")).click();
        }
    }

    public void clickAndSetCommentOrder(String comment){
        driver.findElement(commentOrder).click();
        driver.findElement(commentOrder).sendKeys(comment);
    }

    public void clickButtonEndOrder(){
        driver.findElement(buttonEndOrder).click();
    }

    public void clickButtonYesOrder(){
        driver.findElement(buttonYesOrder).click();
    }

    public String getOrderCreated(){
        return driver.findElement(orderCreated).getText();
    }


}

