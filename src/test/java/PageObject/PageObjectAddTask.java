package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectAddTask {
    private WebDriver driver;
    private By logoScooter = By.xpath(".//img[@alt='Scooter']");
    private By headerScooter = By.xpath(".//div[text()='Самокат ']");


    public PageObjectAddTask(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    public String getHeaderScooter() {
        return driver.findElement(headerScooter).getText();
    }



}
