package dns.hooks;

import dns.web.drivers.BrowserName;
import dns.web.drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverHooks {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    // Действия совершаемые перед каждым сценарием
    @Before
    public void startDriverBeforeScenario() {
        // Получаем параметр запуска тестов через Maven -Dbrowser
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        String loadStrategy = System.
                getProperty("loadStrategy", "normal")
                .toUpperCase();
        // Получаем экземпляр драйвера браузера
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser), loadStrategy);
        logger.info("Драйвер стартовал!");
    }

    // Действия совершаемые после каждого сценария
    @After
    public void stopDriverAfterScenario() {
        // Если драйвер еще существует
        if(driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}