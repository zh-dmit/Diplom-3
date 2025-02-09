import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import practicum.api.UserActionPrepare;
import practicum.pages.LoginPageObject;
import practicum.pages.MainPageObject;
import practicum.pages.RegisterPageObject;

import static org.junit.Assert.assertEquals;

public class RegistrationTests extends BaseTestCase {

    MainPageObject mainPageObject = new MainPageObject(driver);
    LoginPageObject loginPageObject = new LoginPageObject(driver);
    RegisterPageObject registerPageObject = new RegisterPageObject(driver);
    UserActionPrepare userActionPrepare = new UserActionPrepare();

    @Before
    public void deleteUser() {
        userActionPrepare.deleteUserIfExists();
    }

    @Test
    public void registerUser() {
        mainPageObject.logInButtonClick();
        loginPageObject.registerButtonClick();
        registerPageObject.nameFieldSendName(userName);
        registerPageObject.emailFieldSendEmail(userEmail);
        registerPageObject.passwordFieldSendPassword(userPassword);
        registerPageObject.registerButtonClick();
        loginPageObject.signInButtonIsDisplayed();

        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @Test
    public void registerUserIncorrectPassword() {
        mainPageObject.logInButtonClick();
        loginPageObject.registerButtonClick();
        registerPageObject.nameFieldSendName(userName);
        registerPageObject.emailFieldSendEmail(userEmail);
        registerPageObject.passwordFieldSendPassword(userWrongPassword);
        registerPageObject.registerButtonClick();
        registerPageObject.incorrectPasswordIsDisplayed();
    }
}
