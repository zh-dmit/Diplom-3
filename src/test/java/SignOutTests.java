import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import practicum.api.UserActionPrepare;
import practicum.pages.LoginPageObject;
import practicum.pages.MainPageObject;
import practicum.pages.ProfilePageObject;

public class SignOutTests extends BaseTestCase {

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
    public void signOutTest() {
        mainPageObject.profileButtonClick();
        profilePageObject.signOutButtonClick();
        loginPageObject.signInButtonIsDisplayed();
    }

    @After
    public void dataCleaning() {
        userActionPrepare.deleteUserIfExists();
    }
}
