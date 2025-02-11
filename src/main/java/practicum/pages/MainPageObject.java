package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject extends BasePageObject {

    //Кнопка личный кабинет
    private By profileButton = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка войти в аккаунт
    private By logInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка оформить заказ (появляется после логина)
    private By placeAnOrder = By.xpath(".//button[text()='Оформить заказ']");
    //Кнопка вкладок ингридиентов
    private By sections = By.xpath(".//div[@style='display: flex;']");
    //Вкладка булки
    private By bunsSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    //Вкладка соусы
    private By sauceSection = By.xpath(".//span[text()='Соусы']");
    //Вкладка начинки
    private By fillingSection = By.xpath(".//span[text()='Начинки']");
    //Секция булок
    private By bunsSectionName = By.xpath(".//h2[text()='Булки']");
    //Секция соусов
    private By sauceSectionName = By.xpath(".//h2[text()='Соусы']");
    //Секция начинок
    private By fillingSectionName = By.xpath(".//h2[text()='Начинки']");

    public MainPageObject (WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке профиля")
    public void profileButtonClick() {
        driver.findElement(profileButton).isDisplayed();
        driver.findElement(profileButton).click();
    }

    @Step("Клик по кнопке логина")
    public void logInButtonClick() {
        driver.findElement(logInButton).isDisplayed();
        driver.findElement(logInButton).click();
    }

    @Step("Кнопка разместить заказ отображается")
    public void placeAnOrderIsDisplayed() {
        driver.findElement(placeAnOrder).isDisplayed();
    }

    @Step("Клик по кнопке секции булок")
    public void bunsSectionClick() {
        driver.findElement(sections).click();
        driver.findElement(bunsSection).isDisplayed();
        driver.findElement(bunsSection).click();
    }

    @Step("Секция булок отображается")
    public void bunsSectionNameIsDisplayed() {
        driver.findElement(bunsSectionName).isDisplayed();
    }

    @Step("Клик по кнопке секции соуса")
    public void sauceSectionClick() {
        driver.findElement(sections).click();
        driver.findElement(sauceSection).isDisplayed();
        driver.findElement(sauceSection).click();
    }

    @Step("Секция соусов отображается")
    public void sauceSectionNameIsDisplayed() {
        driver.findElement(sauceSectionName).isDisplayed();
    }

    @Step("Клик по кнопке секции начинки")
    public void fillingSectionClick() {
        driver.findElement(sections).click();
        driver.findElement(fillingSection).isDisplayed();
        driver.findElement(fillingSection).click();
    }

    @Step("Секция начинки отображается")
    public void fillingSectionNameIsDisplayed() {
        driver.findElement(fillingSectionName).isDisplayed();
    }
}
