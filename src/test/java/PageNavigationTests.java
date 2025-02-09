import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import practicum.api.UserActionPrepare;
import practicum.pages.LoginPageObject;
import practicum.pages.MainPageObject;
import practicum.pages.ProfilePageObject;

import static org.junit.Assert.assertEquals;

public class PageNavigationTests extends BaseTestCase {

    MainPageObject mainPageObject = new MainPageObject(driver);
    LoginPageObject loginPageObject = new LoginPageObject(driver);
    UserActionPrepare userActionPrepare = new UserActionPrepare();
    ProfilePageObject profilePageObject = new ProfilePageObject(driver);

    @Before
    public void preparationOfConditions() {
        userActionPrepare.createUserIfNonExists();
        mainPageObject.logInButtonClick();
        loginPageObject.emailFieldSendEmail(userEmail);
        loginPageObject.passwordFieldSendPassword(userPassword);
        loginPageObject.signInButtonClick();
        mainPageObject.placeAnOrderIsDisplayed();
    }

    @Test
    public void navigateToPersonalAccount() {
        mainPageObject.profileButtonClick();
        profilePageObject.emailFieldIsDisplayed(userEmail);
    }

    @Test
    public void navigateToConstructorFromPersonalAccount() {
        mainPageObject.profileButtonClick();
        profilePageObject.emailFieldIsDisplayed(userEmail);
        profilePageObject.constructorButtonClick();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    public void navigateToLogoButtonFromPersonalAccount() {
        mainPageObject.profileButtonClick();
        profilePageObject.emailFieldIsDisplayed(userEmail);
        profilePageObject.logoButtonClick();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @After
    public void deleteUser() {
        userActionPrepare.deleteUserIfExists();
    }
}
