import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import practicum.api.UserActionPrepare;
import practicum.pages.ForgotPasswordPageObject;
import practicum.pages.LoginPageObject;
import practicum.pages.MainPageObject;
import practicum.pages.RegisterPageObject;

import static org.junit.Assert.assertEquals;

public class SignInTests extends BaseTestCase {

    MainPageObject mainPageObject = new MainPageObject(driver);
    UserActionPrepare userActionPrepare = new UserActionPrepare();
    LoginPageObject loginPageObject = new LoginPageObject(driver);
    RegisterPageObject registerPageObject = new RegisterPageObject(driver);
    ForgotPasswordPageObject forgotPasswordPageObject = new ForgotPasswordPageObject(driver);

    @Before
    public void createUser() {
        userActionPrepare.createUserIfNonExists();
    }

    @Test
    public void signInMainPageLogInButton() {
        mainPageObject.logInButtonClick();
        loginPageObject.emailFieldSendEmail(userEmail);
        loginPageObject.passwordFieldSendPassword(userPassword);
        loginPageObject.signInButtonClick();
        mainPageObject.placeAnOrderIsDisplayed();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    public void signInMainPageProfileButton() {
        mainPageObject.profileButtonClick();
        loginPageObject.emailFieldSendEmail(userEmail);
        loginPageObject.passwordFieldSendPassword(userPassword);
        loginPageObject.signInButtonClick();
        mainPageObject.placeAnOrderIsDisplayed();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    public void signInRegisterPageLogInButton() {
        mainPageObject.logInButtonClick();
        loginPageObject.registerButtonClick();
        registerPageObject.signInButtonClick();
        loginPageObject.emailFieldSendEmail(userEmail);
        loginPageObject.passwordFieldSendPassword(userPassword);
        loginPageObject.signInButtonClick();
        mainPageObject.placeAnOrderIsDisplayed();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    public void signInLoginPageRestorePassword() {
        mainPageObject.logInButtonClick();
        loginPageObject.restorePasswordClick();
        forgotPasswordPageObject.signInButtonClick();
        loginPageObject.emailFieldSendEmail(userEmail);
        loginPageObject.passwordFieldSendPassword(userPassword);
        loginPageObject.signInButtonClick();
        mainPageObject.placeAnOrderIsDisplayed();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @After
    public void deleteUser() {
        userActionPrepare.deleteUserIfExists();
    }
}
