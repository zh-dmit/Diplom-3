package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePageObject {

    //Поле ввода имени
    private By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    //Поле ввода email
    private By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //После ввода пароля
    private By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    //Кнопка регистрации
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Надпись при некорректном пароле
    private By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    //Кнопка войти, если уже зарегистрированы
    private By signInButton = By.xpath(".//a[text()='Войти']");

    public RegisterPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести имя")
    public void nameFieldSendName(String name) {
        driver.findElement(nameField).isDisplayed();
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email")
    public void emailFieldSendEmail(String email) {
        driver.findElement(emailField).isDisplayed();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void passwordFieldSendPassword(String password) {
        driver.findElement(passwordField).isDisplayed();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке регистрации")
    public void registerButtonClick() {
        driver.findElement(registerButton).isDisplayed();
        driver.findElement(registerButton).click();
    }

    @Step("Надпись неверного пароля отображается")
    public void incorrectPasswordIsDisplayed() {
        driver.findElement(incorrectPassword).isDisplayed();
    }

    @Step("Клик по кнопке войти")
    public void signInButtonClick() {
        driver.findElement(signInButton).isDisplayed();
        driver.findElement(signInButton).click();
    }
}
