package dns.steps;

import dns.matchers.LaptopProductPageMatcher;
import dns.web.drivers.WebDriverFactory;
import dns.web.helpers.JavaScriptHelper;
import dns.web.helpers.ScreenHelper;
import dns.web.pages.LaptopProductPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static dns.steps.LaptopPageSteps.expectedNameFirstElement;

public class LaptopProductPageSteps {

    private static Logger logger = LogManager.getLogger(dns.steps.StartPageSteps.class);

    LaptopProductPage laptopProductPage = new LaptopProductPage(WebDriverFactory.getCurrentDriver());
    LaptopProductPageMatcher laptopProductPageMatcher = new LaptopProductPageMatcher(laptopProductPage);

    // Шаг: Открыта страница Продукт. Ноутбук
    @И("Открыта страница Продукт. Ноутбук")
    public void productPage() {
        // Скриншот всей страницы (с прокруткой) после применения сортировки
        ScreenHelper.makeScreenshotFullPage(WebDriverFactory.getCurrentDriver());
        JavaScriptHelper.scrollBy(0, 500);
        // Открываем все характеристики
        laptopProductPage.buttonAllCharacteristics().click();
    }

    // Шаг: Проверка: соответствия названия продукта названию в списке на предыдущей странице
    @Тогда("Проверка: соответствия названия продукта названию в списке на предыдущей странице")
    public void checkFirstName() {
        // Проверка заголовка открытой по ссылке первого элемента страницы
        laptopProductPageMatcher.checkPageTitleEquals(expectedNameFirstElement);
    }

    // Шаг: Проверка: что в блоке Характеристики заголовок содержит '<производитель>'
    @Тогда("Проверка: что в блоке Характеристики заголовок содержит {string}")
    public void checkNameFromTextBlock(String company){
        // Проверить, что в блоке Характеристики заголовок содержит ASUS
        laptopProductPageMatcher.checkNameEquals(company, laptopProductPage.getActualNameCompany());
    }

    // Шаг: Проверка: что в блоке Характеристики значение Объем оперативной памяти равно '<память>'
    @Тогда("Проверка: что в блоке Характеристики значение Объем оперативной памяти равно {string}")
    public void checkRamFromTextBlock(String ram) {
        // Проверка, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
        laptopProductPageMatcher.checkRam(ram, laptopProductPage.getRam());
    }
}