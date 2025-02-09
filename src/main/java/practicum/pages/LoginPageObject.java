package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject  {

    //Кнопка регистрации
    private By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    //Кнопка входа
    private By signInButton = By.xpath(".//button[text()='Войти']");
    //Поле ввода email
    private By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //Поле ввода пароля
    private By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    //Кнопка восстановить пароль
    private By restorePassword = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке регистрации")
    public void registerButtonClick() {
        driver.findElement(registerButton).isDisplayed();
        driver.findElement(registerButton).click();
    }

    @Step("Кнопка входа отображается")
    public void signInButtonIsDisplayed() {
        driver.findElement(signInButton).isDisplayed();
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

    @Step("Клик по кнопке входа")
    public void signInButtonClick() {
        signInButtonIsDisplayed();
        driver.findElement(signInButton).click();
    }

    @Step("Клик по кнопке восстановить пароль")
    public void restorePasswordClick() {
        driver.findElement(restorePassword).isDisplayed();
        driver.findElement(restorePassword).click();
    }
}
