package dns.web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenHelper {

    private static Logger logger = LogManager.getLogger(ScreenHelper.class);

    // Счетчик для нумерации скринов
    private static int count = 1;

    // Метод скриншотирования всей веб страницы.
    public static void makeScreenshotFullPage(WebDriver driver) {
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ScreenshotFromCase"+count+".png"));
            logger.info("Скриншот сохранен.");
            count++;
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
