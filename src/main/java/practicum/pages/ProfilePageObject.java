package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageObject extends BasePageObject {

    //Поле логина
    private String emailField = ".//input[@value='%s']";
    //Кнопка конструктора
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //Кнопка с логотипом главной страницы
    private By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка выхода
    private By signOutButton = By.xpath(".//button[text()='Выход']");

    public ProfilePageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Поле email отображается")
    public void emailFieldIsDisplayed(String name) {
        driver.findElement(By.xpath(String.format(emailField, name))).isDisplayed();
    }

    @Step("Клик по кнопке конструктора")
    public void constructorButtonClick() {
        driver.findElement(constructorButton).isDisplayed();
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по кнопке лого")
    public void logoButtonClick() {
        driver.findElement(logoButton).isDisplayed();
        driver.findElement(logoButton).click();
    }

    @Step("Клик по кнопке выход")
    public void signOutButtonClick() {
        driver.findElement(signOutButton).isDisplayed();
        driver.findElement(signOutButton).click();
    }

}
