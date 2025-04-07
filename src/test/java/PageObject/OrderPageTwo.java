package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageTwo {
    private WebDriver driver;
    private By fieldWhenArrive = By.xpath(".//input[@placeholder=\"* Когда привезти самокат\"]");
    private By rentalPeriod = By.xpath(".//div[text()='* Срок аренды']");
    private By commentOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By buttonEndOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By buttonYesOrder = By.xpath(".//button[text()='Да']");
    private By orderCreated = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderPageTwo(WebDriver driver) {
        this.driver = driver;
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
