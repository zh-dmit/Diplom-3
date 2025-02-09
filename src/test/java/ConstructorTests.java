import io.qameta.allure.Step;
import org.junit.Test;
import practicum.pages.MainPageObject;

public class ConstructorTests extends BaseTestCase {

    MainPageObject mainPageObject = new MainPageObject(driver);

    @Test
    public void navigateToBunsSection() {
        mainPageObject.bunsSectionClick();
        mainPageObject.bunsSectionNameIsDisplayed();
    }

    @Test
    public void navigateToSauceSection() {
        mainPageObject.sauceSectionClick();
        mainPageObject.sauceSectionNameIsDisplayed();
    }

    @Test
    public void navigateToFillingSection() {
        mainPageObject.fillingSectionClick();
        mainPageObject.fillingSectionNameIsDisplayed();
    }
}
