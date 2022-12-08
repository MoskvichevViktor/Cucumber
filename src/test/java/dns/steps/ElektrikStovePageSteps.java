package dns.steps;

import dns.matchers.ElektrikStovePageMatcher;
import dns.web.drivers.WebDriverFactory;
import dns.web.pages.ElektrikStovePage;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElektrikStovePageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Переменная в которую положим количество товара
    int actualCountProduct;

    ElektrikStovePage elektrikStovePage = new ElektrikStovePage(WebDriverFactory.getCurrentDriver());

    ElektrikStovePageMatcher elektrikStovePageMatcher = new ElektrikStovePageMatcher(elektrikStovePage);

    // Шаг: Проверка: количества товара Электрические плиты больше чем <i>
    @Тогда("Проверка: количества товара Электрические плиты больше чем <i>")
    public void checkCountElektrikStoveProduct(Integer expectedCountProduct) {
        // Заносим в переменную количество найденного товара
        actualCountProduct = elektrikStovePage.getTextProductsCount();
        // Проводим проверку на соответствие количества товара Электрические плиты больше чем заданное значение
        elektrikStovePageMatcher.checkCountProduct(expectedCountProduct, actualCountProduct);
    }
}
