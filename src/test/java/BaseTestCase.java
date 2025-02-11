import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import practicum.api.StellarburgersApi;

import java.time.Duration;

public class BaseTestCase {

    protected WebDriver driver;
    protected StellarburgersApi stellarburgersApi = new StellarburgersApi();
    private final String testURL = "https://stellarburgers.nomoreparties.site/";
    protected String yandexDriverPath = System.getenv("YANDEX_DRIVER_PATH");


    public BaseTestCase() {
        if (yandexDriverPath == null || yandexDriverPath.isEmpty()) {
            throw new RuntimeException("Environment variable YANDEX_DRIVER_PATH is not set");
        }
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
