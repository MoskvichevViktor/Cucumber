package dns.steps;

import dns.matchers.AppliancesPageMatcher;
import dns.web.drivers.WebDriverFactory;
import dns.web.pages.AppliancesPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppliancesPageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Переменные в которые положим проверяемый текст со страницы
    String actualCategoryName;

    AppliancesPage appliancesPage = new AppliancesPage(WebDriverFactory.getCurrentDriver());

    AppliancesPageMatcher appliancesPageMatcher = new AppliancesPageMatcher(appliancesPage);

    // Шаг: Проверка: Отображение ссылки Бытовая техника
    @Тогда("Проверка: Отображение ссылки Бытовая техника")
    public void checkTextAppliancesPage(String expectedCategoryName) {
        // Заносим в переменную текущее отображение текста на странице для дальнейшей проверки
        actualCategoryName = appliancesPage.getTextBoxTechnique();
        //Проверка отображения текста Бытовая техника
        appliancesPageMatcher.checkPageTextEquals(expectedCategoryName, actualCategoryName);
    }

    // Шаг: Выполнен переход на страницу Техника для кухни
    @И("Выполнен переход на страницу Техника для кухни")
    public void goKitchenAppliancesPage() {
        // Переходим по ссылке Техника для кухни (kitchenAppliances)
        appliancesPage.getLinkKitchenAppliances().click();
    }
}
