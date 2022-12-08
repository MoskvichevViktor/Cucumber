package dns.steps;

import dns.matchers.KitchenAppliancesPageMatcher;
import dns.web.drivers.WebDriverFactory;
import dns.web.pages.KitchenAppliancesPage;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KitchenAppliancesPageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(WebDriverFactory.getCurrentDriver());
    KitchenAppliancesPageMatcher kitchenAppliancesPageMatcher = new KitchenAppliancesPageMatcher(kitchenAppliancesPage);

    // Переменные в которые положим проверяемый текст со страницы
    String actualSubCategoryName;
    // Переменная в которую положим проверяемую ссылку (проверка ссылки Собрать свою кухню)
    String actualLink;
    // Переменная в которую положим количество категорий раздела Техника для кухни
    int actualCountSubCategory;

    // Шаг: Проверка: Отображение ссылки Собрать свою кухню
    @Тогда("Проверка: Отображение ссылки Собрать свою кухню")
    public void checkLinkMakeKitchen(String expectedLink) {
        // Заносим в переменную проверяемую ссылку (проверка ссылки Собрать свою кухню)
        actualLink = kitchenAppliancesPage.getLinkMakeKitchen().getText();
        // Проверка на наличие ссылки Собрать свою кухню
        kitchenAppliancesPageMatcher.checkPageLinkEquals(expectedLink, actualLink);
    }

    // Шаг: Проверка: Отображение текста Техника для кухни
    @Тогда("Проверка: Отображение текста Техника для кухни")
    public void checkTextKitchenAppliancesPage(String expectedSubCategoryName) {
        // Выводим в логи названия всех категорий раздела Техника для кухни
        kitchenAppliancesPage.getSubCategoryName();
        // Заносим в переменную текущее отображение текста на странице для дальнейшей проверки
        actualSubCategoryName = kitchenAppliancesPage.getTextBoxKitchenAppliances();
        // Проверка на отображение текста Техника для кухни
        kitchenAppliancesPageMatcher.checkPageTextEquals(expectedSubCategoryName, actualSubCategoryName);
    }

    // Шаг: Проверка: количества категорий раздела Техника для кухни больше чем <x>
    @Тогда("Проверка: количества категорий раздела Техника для кухни больше чем <x>")
    public void checkCountKitchenAppliancesCategory(Integer expectedCountSubCategory) {
        // Заносим в переменную количество категорий раздела Техника для кухни
        actualCountSubCategory = kitchenAppliancesPage.getCountSubCategory();
        // Проверка условия на количество субкатегорий > <x>
        kitchenAppliancesPageMatcher.checkCountSubcategory(expectedCountSubCategory, actualCountSubCategory);
    }
}
