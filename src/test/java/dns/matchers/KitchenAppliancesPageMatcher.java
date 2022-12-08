package dns.matchers;

import dns.web.pages.KitchenAppliancesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class KitchenAppliancesPageMatcher {

    KitchenAppliancesPage page;

    private Logger logger = LogManager.getLogger(KitchenAppliancesPageMatcher.class);

    // Конструктор
    public KitchenAppliancesPageMatcher(KitchenAppliancesPage page) {
        this.page = page;
    }

    // Проверка отображения текста Техника для кухни
    public void checkPageTextEquals(String expected, String actual) {
        Assertions.assertEquals(expected, actual, "Текст Техника для кухни не отображается.");
        logger.info("Проверка на отображения текста Техника для кухни - пройдена!");
    }

    // Проверка отображения ссылки Собрать свою кухню
    public void checkPageLinkEquals(String expected, String actual) {
        Assertions.assertEquals(expected, actual, "Ссылка Собрать свою кухню не отображается.");
        logger.info("Проверка на отображения ссылки Собрать свою кухню - пройдена!");
    }

    // Проверка на количество категорий раздела Техника для кухни
    public void checkCountSubcategory(Integer expected, Integer actual) {
        Assertions.assertTrue( expected < actual, "Количество категорий меньше или равно пяти");
        logger.info("Проверка на количество категорий раздела Техника для кухни  - пройдена!");
    }
}
