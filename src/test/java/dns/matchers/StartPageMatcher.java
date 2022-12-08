package dns.matchers;

import dns.web.pages.StartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StartPageMatcher {

    StartPage page;

    private Logger logger = LogManager.getLogger(StartPageMatcher.class);

    // Конструктор
    public StartPageMatcher(StartPage page) {
        this.page = page;
    }

    // Проверка на соответствие ссылок
    public void checkPageListCategoryEquals(List<String> expected, List<String> actual) {
        Assertions.assertEquals(expected, actual, "Отображаемые ссылки не прошли проверку на заданное соответствие!");
        logger.info("Проверка на отображение ссылок в разделе Бытовая техника прошла!");
    }

    //Проверка количества категорий Холодильное оборудование больше заданного значения
    public void checkCountSubcategory(Integer expected, Integer actual) {
        Assertions.assertTrue(actual > expected, "Количество категорий меньше или равно заданного значения");
        logger.info("Проверка на количество категорий раздела Холодильное оборудование  - пройдена!");
    }
}
