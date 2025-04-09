package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectAddTask {
    private WebDriver driver;
    private By logoScooter = By.xpath(".//img[@alt='Scooter']");
    private By headerScooter = By.xpath(".//div[text()='Самокат ']");
    private By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']");

    private By fieldName = By.xpath(".//Input[@placeholder='* Имя']");
    private By errorName = By.xpath(".//div[text()='Введите корректное имя']");
    private By fieldSurname = By.xpath(".//Input[@placeholder='* Фамилия']");
    private By fieldAddres = By.xpath(".//Input[@placeholder='* Адрес: куда привезти заказ']");
    private By fieldPhone = By.xpath(".//Input[@placeholder='* Телефон: на него позвонит курьер']");


    public PageObjectAddTask(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    public String getHeaderScooter() {
        return driver.findElement(headerScooter).getText();
    }

    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    public void clickFieldName() {
        driver.findElement(fieldName).click();
    }

    public void setFieldName(String Name) {
        driver.findElement(fieldName).sendKeys(Name);
        driver.findElement(By.xpath(".//div[text()='Для кого самокат']")).click();
    }

    public boolean isErrorName(){
      return driver.findElement(errorName).isDisplayed();
    }

    public void clickFieldSurname() {
        driver.findElement(fieldSurname).click();
    }

    public void setFieldSurname(String Surname) {
        driver.findElement(fieldSurname).sendKeys(Surname);
        driver.findElement(By.xpath(".//div[text()='Для кого самокат']")).click();
    }

    public boolean isErrorSurname(){
        return driver.findElement(By.xpath(".//div[text()='Введите корректную фамилию']")).isDisplayed();
    }

    public void clickFieldAddres() {
        driver.findElement(fieldAddres).click();
    }

    public void setFieldAddres(String Addres) {
        driver.findElement(fieldAddres).sendKeys(Addres);
        driver.findElement(By.xpath(".//div[text()='Для кого самокат']")).click();
    }

    public boolean isFieldAddres() {
        return driver.findElement(By.xpath(".//div[text()='Введите корректный адрес']")).isDisplayed();
    }

    public void clickFieldPhone() {
        driver.findElement(fieldPhone).click();
    }

    public void setFieldPhone(String Phone) {
        driver.findElement(fieldPhone).sendKeys(Phone);
        driver.findElement(By.xpath(".//div[text()='Для кого самокат']")).click();
    }

    public boolean isFieldPhone() {
        return driver.findElement(By.xpath(".//div[text()='Введите корректный номер']")).isDisplayed();
    }
}

