package page.object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageOne {
    private WebDriver driver;
    private final String URL= "https://qa-scooter.praktikum-services.ru/";
    private final String URL_ORDER= "https://qa-scooter.praktikum-services.ru/order";

    private By upButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By downButtonOrder = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private By fieldName = By.xpath(".//Input[@placeholder='* Имя']");
    private By fieldSurname = By.xpath(".//Input[@placeholder='* Фамилия']");
    private By fieldAddress = By.xpath(".//Input[@placeholder='* Адрес: куда привезти заказ']");
    private By fieldPhone = By.xpath(".//Input[@placeholder='* Телефон: на него позвонит курьер']");
    private By fieldMetro = By.xpath(".//Input[@placeholder='* Станция метро']");
    private By buttonNextStepOrder = By.xpath(".//button[text()='Далее']");
    private By headerKogoSamokat = By.xpath(".//div[@class='Order_Header__BZXOb']");
    private By choiseMetro = By.xpath(".//div[@class='select-search__select']");

    // вторая страница заказа Про аренду
    private By fieldWhenArrive = By.xpath(".//input[@placeholder=\"* Когда привезти самокат\"]");
    private By rentalPeriod = By.xpath(".//div[text()='* Срок аренды']");
    private By commentOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By buttonEndOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By buttonYesOrder = By.xpath(".//button[text()='Да']");
    private By orderCreated = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    private By proArendy = By.xpath(".//div[text()='Про аренду']");
    private By colorBlack = By.xpath(".//input[@id='black']");
    private By colorGrey = By.xpath(".//input[@id='grey']");
    private By rentalList = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']");

    // Главная страница
    private String locatorQuestion = "accordion__heading-";
    private String locatorAnswer = ".//div[@id='accordion__panel-";
    private String locator;

    public void getUrl(WebDriver driver){
        driver.get(URL);
    }

    public void getUrlOrder(WebDriver driver){
        driver.get(URL_ORDER);
    }

    public void clickQuestionLocator(Integer questionNumber) {
        locator = locatorQuestion + questionNumber;
        driver.findElement(By.id(locator)).click();
    }

    public void scrollPage(WebDriver driver) {
        ((JavascriptExecutor)driver). executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String answerLocator(Integer answerNumber) {
        locator = locatorAnswer + answerNumber + "']/p";
        return driver.findElement(By.xpath(locator)).getText();
    }



    public OrderPageOne(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUpButtonOder() {
        driver.findElement(upButtonOrder).click();
    }

    public void clickDownButtonOrder() {
        driver.findElement(downButtonOrder).click();
    }

    public void fillingName(String name) {
        Assert.assertTrue(driver.findElement(fieldName).isEnabled());
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
    }

    public void fillingSurname(String surname) {
        Assert.assertTrue(driver.findElement(fieldSurname).isEnabled());
        driver.findElement(fieldSurname).clear();
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    public void fillingAddres(String addres) {
        Assert.assertTrue(driver.findElement(fieldAddress).isEnabled());
        driver.findElement(fieldAddress).clear();
        driver.findElement(fieldAddress).sendKeys(addres);
        driver.findElement(fieldPhone).click();
    }

    public void fillingPhone(String phone) {
        Assert.assertTrue(driver.findElement(fieldPhone).isEnabled());
        driver.findElement(fieldPhone).clear();
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    public void fillingMetro(String metro) {
        Assert.assertTrue(driver.findElement(fieldMetro).isEnabled());
        driver.findElement(fieldMetro).sendKeys(metro);
        driver.findElement(choiseMetro).click();
    }

    public void clickNextStepOrder() {
        driver.findElement(buttonNextStepOrder).click();
    }

    public String getHeaderKogoSamokat() {
        return driver.findElement(headerKogoSamokat).getText();
    }

    public void order(String name, String surname, String address,
                      String phone, String metro, String dataArrive, String color, String comment) {
        clickUpButtonOder();
        fillingName(name);
        fillingSurname(surname);
        fillingAddres(address);
        fillingPhone(phone);
        fillingMetro(metro);
        clickNextStepOrder();

        clickAndSetWhenArrive(dataArrive);
        clickAndSetRentalPeriod();
        choiceColor(color);
        clickAndSetCommentOrder(comment);
        clickButtonEndOrder();
        clickButtonYesOrder();
    }

    public void clickAndSetWhenArrive(String dataArrive) {

        driver.findElement(fieldWhenArrive).sendKeys(dataArrive);

        driver.findElement(proArendy).click();
    }

    public void clickAndSetRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalList).click();
    }

    public void choiceColor(String color) {
        if (color.equals("black")) {
            driver.findElement(colorBlack).click();
        } else if (color.equals("grey")) {
            driver.findElement(colorGrey).click();
        }
    }

    public void clickAndSetCommentOrder(String comment) {
        driver.findElement(commentOrder).click();
        driver.findElement(commentOrder).sendKeys(comment);
    }

    public void clickButtonEndOrder() {
        driver.findElement(buttonEndOrder).click();
    }

    public void clickButtonYesOrder() {
        driver.findElement(buttonYesOrder).click();
    }

    public String getOrderCreated() {
        return driver.findElement(orderCreated).getText();
    }


// Доп задания

    private By logoScooter = By.xpath(".//img[@alt='Scooter']");
    private By headerScooter = By.xpath(".//div[text()='Самокат ']");
    private By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']");
    private By errorName = By.xpath(".//div[text()='Введите корректное имя']");
    private By messageErrorSurname = By.xpath(".//div[text()='Введите корректную фамилию']");
    private By messageErrorAddress = By.xpath(".//div[text()='Введите корректный адрес']");
    private By messageErrorPhone = By.xpath(".//div[text()='Введите корректный номер']");
    private By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By errorMessageMetro = By.xpath(".//div[text()='Выберите станцию']");
    private By imgNoFound = By.cssSelector("img[alt='Not found']");
    private By fieldStatusOrder = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private By buttonStatusOrder = By.xpath(".//button[text()='Статус заказа']");
    private By buttonGo = By.xpath(".//button[text()='Go!']");
    private By orderText = By.className("Order_Text__2broi");
    private By buttonShowStatus = By.xpath(".//button[text()='Посмотреть статус']");
    private By getNumberOrder = By.xpath(".//input[@class='Input_Input__1iN_Z Track_Input__1g7lq Input_Filled__1rDxs Input_Responsible__1jDKN']");


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
        driver.findElement(headerKogoSamokat).click();
    }

    public boolean isErrorName() {
        return driver.findElement(errorName).isDisplayed();
    }

    public void clickFieldSurname() {
        driver.findElement(fieldSurname).click();
    }

    public void setFieldSurname(String Surname) {
        driver.findElement(fieldSurname).sendKeys(Surname);
        driver.findElement(headerKogoSamokat).click();
    }

    public boolean isErrorSurname() {
        return driver.findElement(messageErrorSurname).isDisplayed();
    }

    public void clickFieldAddres() {
        driver.findElement(fieldAddress).click();
    }

    public void setFieldAddres(String Addres) {
        driver.findElement(fieldAddress).sendKeys(Addres);
        driver.findElement(headerKogoSamokat).click();
    }

    public boolean isErrorAddres() {
        return driver.findElement(messageErrorAddress).isDisplayed();
    }

    public void clickFieldPhone() {
        driver.findElement(fieldPhone).click();
    }

    public void setFieldPhone(String Phone) {
        driver.findElement(fieldPhone).sendKeys(Phone);
        driver.findElement(headerKogoSamokat).click();
    }

    public boolean isFieldPhone() {
        return driver.findElement(messageErrorPhone).isDisplayed();
    }

    public void pageOneOder() {
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys("Роман");
        driver.findElement(fieldSurname).click();
        driver.findElement(fieldSurname).sendKeys("Роман");
        driver.findElement(fieldAddress).click();
        driver.findElement(fieldAddress).sendKeys("Москва Большая 14");
        driver.findElement(fieldPhone).click();
        driver.findElement(fieldPhone).sendKeys("89996662233");
        orderPageOne.fillingMetro("Лубянка");
        orderPageOne.clickNextStepOrder();
    }

    public String getValueComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
        return driver.findElement(fieldComment).getAttribute("value");
    }

    public void clickHead() {
        driver.findElement(headerKogoSamokat).click();
    }

    public Object isErrorMessageMetro() {
        driver.findElement(errorMessageMetro).isDisplayed();
        return driver.findElement(errorMessageMetro).isDisplayed();
    }

    public boolean isImgNoFound() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(imgNoFound));
        return driver.findElement(imgNoFound).isDisplayed();
    }

    public void setStatusOrder(String number) {

        driver.findElement(buttonStatusOrder).click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(fieldStatusOrder)));
        driver.findElement(fieldStatusOrder).sendKeys(number);
        driver.findElement(buttonGo).click();
    }

    public void showOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderText));
        driver.findElement(buttonShowStatus).click();
    }

    public String isFoundOeder() {
        String numberOder = driver.findElement(getNumberOrder).getAttribute("value");
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(buttonStatusOrder).click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(fieldStatusOrder)));
        driver.findElement(fieldStatusOrder).sendKeys(numberOder);
        driver.findElement(buttonGo).click();
        return driver.findElement(getNumberOrder).getAttribute("value");
    }
     public String getNumberOrder() {
         return  driver.findElement(getNumberOrder).getAttribute("value");
     }

}