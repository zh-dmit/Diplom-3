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
    UserActionPrepare userActionPrepare = new UserActionPrepare();
    ProfilePageObject profilePageObject = new ProfilePageObject(driver);

    @Before
    public void createUser() {
        userActionPrepare.createUserIfNonExists();
        mainPageObject.logInButtonClick();
        loginPageObject.emailFieldSendEmail(userEmail);
        loginPageObject.passwordFieldSendPassword(userPassword);
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
    public void deleteUser() {
        userActionPrepare.deleteUserIfExists();
    }
}
