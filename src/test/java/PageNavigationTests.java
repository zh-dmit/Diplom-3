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
    UserActionPrepare userActionPrepare = new UserActionPrepare(stellarburgersApi);
    ProfilePageObject profilePageObject = new ProfilePageObject(driver);

    @Before
    public void preparationOfConditions() {
        stellarburgersApi.generateUserData();
        userActionPrepare.createUserIfNonExists();
        mainPageObject.logInButtonClick();
        loginPageObject.emailFieldSendEmail(stellarburgersApi.getUserEmail());
        loginPageObject.passwordFieldSendPassword(stellarburgersApi.getUserPassword());
        loginPageObject.signInButtonClick();
        mainPageObject.placeAnOrderIsDisplayed();
    }

    @Test
    public void navigateToPersonalAccount() {
        mainPageObject.profileButtonClick();
        profilePageObject.emailFieldIsDisplayed(stellarburgersApi.getUserEmail());
    }

    @Test
    public void navigateToConstructorFromPersonalAccount() {
        mainPageObject.profileButtonClick();
        profilePageObject.emailFieldIsDisplayed(stellarburgersApi.getUserName());
        profilePageObject.constructorButtonClick();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    public void navigateToLogoButtonFromPersonalAccount() {
        mainPageObject.profileButtonClick();
        profilePageObject.emailFieldIsDisplayed(stellarburgersApi.getUserEmail());
        profilePageObject.logoButtonClick();

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @After
    public void dataCleaning() {
        userActionPrepare.deleteUserIfExists();
    }
}
