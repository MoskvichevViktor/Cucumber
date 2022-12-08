package dns.matchers;

import dns.web.pages.LaptopProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LaptopProductPageMatcher {

    LaptopProductPage page;

    private Logger logger = LogManager.getLogger(LaptopProductPageMatcher.class);

    // Конструктор
    public LaptopProductPageMatcher(LaptopProductPage page) {
        this.page = page;
    }

    // Проверка заголовка страницы
    public void checkPageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertTrue(actual.contains(expected), "Заголовок страницы НЕ соответствует ожидаемому.");
        logger.info("Заголовок страницы соответствует ожидаемому.");
    }

    // Проверка, что в блоке Характеристики заголовок содержит ожидаемое значение
    public void checkNameEquals(String expected, String actual) {
        Assertions.assertTrue(actual.contains(expected), "В блоке Характеристики заголовок НЕ содержит требуемое значение.");
        logger.info("Заголовок блока характеристик соответствует ожидаемому.");
    }

    // Проверка, что в блоке Характеристики значение Объем оперативной памяти равно ожидаемое значение
    public void checkRam(String expected, String actual) {
        Assertions.assertTrue(actual.contains(expected), "В блоке Характеристики значение Объем оперативной памяти НЕ равно ожидаемому значению.");
        logger.info("В блоке Характеристики значение Объем оперативной памяти равно ожидаемому значению.");
    }
}
