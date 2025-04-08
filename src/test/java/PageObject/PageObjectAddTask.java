package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectAddTask {
    private WebDriver driver;
    private By logoScooter = By.xpath(".//img[@alt='Scooter']");
    private By headerScooter = By.xpath(".//div[text()='Самокат ']");
    private By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']");


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



}
