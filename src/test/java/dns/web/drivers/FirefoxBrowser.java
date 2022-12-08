package dns.web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser {
    // Получение экземпляра драйвера браузера "Mozilla Firefox"
    public static WebDriver getDriver(String loadStrategy) {
        // Настройка исполняемого файла драйвера
        WebDriverManager.firefoxdriver().setup();
        // Опции драйвера:
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.valueOf(loadStrategy.toUpperCase()));
        // - режим "Инкогнито"
        options.addArguments("-private");
        // - режим "Полный экран"
        options.addArguments("-kiosk");

        // Новый экземпляр драйвера
        return new FirefoxDriver(options);
    }
}