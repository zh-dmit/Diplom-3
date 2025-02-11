package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageObject extends BasePageObject {

    //Кнопка войти
    private By signInButton = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке входа")
    public void signInButtonClick() {
        driver.findElement(signInButton).isDisplayed();
        driver.findElement(signInButton).click();
    }
}
