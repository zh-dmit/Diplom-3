import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTestCase {
    protected WebDriver driver;
    private final String testURL = "https://stellarburgers.nomoreparties.site/";
    protected String userEmail = "testdmit@test.com";
    protected String userPassword = "123456";
    protected String userWrongPassword = "12345";
    protected String userName = "testdmituser";
    protected String yandexDriverPath = "C:/Users/User/yandexdriver.exe";



    public BaseTestCase() {
        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        driver = new ChromeDriver();
        driver.get(testURL);
    }

    @Before
    public void waitLoadElement() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
