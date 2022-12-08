package dns.web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {
    // Получение экземпляра драйвера браузера "Google Chrome"
    public static WebDriver getDriver(String loadStrategy) {
        // Настройка исполняемого файла драйвера
        WebDriverManager.chromedriver().setup();

        // Опции драйвера:
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.valueOf(loadStrategy.toUpperCase()));
        // - режим "Инкогнито"
        options.addArguments("--incognito");
        // - режим "Полный экран"
        options.addArguments("--start-fullscreen");

        // Новый экземпляр драйвера
        return new ChromeDriver(options);
    }
}
