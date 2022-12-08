package dns.matchers;

import dns.web.pages.AppliancesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class AppliancesPageMatcher {

    AppliancesPage page;

    private Logger logger = LogManager.getLogger(AppliancesPageMatcher.class);

    // Конструктор
    public AppliancesPageMatcher(AppliancesPage page) {
        this.page = page;
    }

    // Проверка
    public void checkPageTextEquals(String expected, String actual) {
        Assertions.assertEquals(expected, actual, "Текст Бытовая техника не отображается.");
        logger.info("Проверка на отображения текста Бытовая техника - пройдена!");
    }
}
