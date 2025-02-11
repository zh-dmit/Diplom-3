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
    UserActionPrepare userActionPrepare = new UserActionPrepare(stellarburgersApi);

    @Before
    public void preparationOfConditions() {
        stellarburgersApi.generateUserData();
        userActionPrepare.deleteUserIfExists();
    }

    @Test
    public void registerUser() {
        mainPageObject.logInButtonClick();
        loginPageObject.registerButtonClick();
        registerPageObject.nameFieldSendName(stellarburgersApi.getUserName());
        registerPageObject.emailFieldSendEmail(stellarburgersApi.getUserEmail());
        registerPageObject.passwordFieldSendPassword(stellarburgersApi.getUserPassword());
        registerPageObject.registerButtonClick();
        loginPageObject.signInButtonIsDisplayed();

        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @Test
    public void registerUserIncorrectPassword() {
        mainPageObject.logInButtonClick();
        loginPageObject.registerButtonClick();
        registerPageObject.nameFieldSendName(stellarburgersApi.getUserName());
        registerPageObject.emailFieldSendEmail(stellarburgersApi.getUserEmail());
        registerPageObject.passwordFieldSendPassword(stellarburgersApi.getUserWrongPassword());
        registerPageObject.registerButtonClick();
        registerPageObject.incorrectPasswordIsDisplayed();
    }

    @After
    public void dataCleaning() {
        userActionPrepare.deleteUserIfExists();
    }
}
