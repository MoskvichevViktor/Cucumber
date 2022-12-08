package dns.steps;

import dns.matchers.StartPageMatcher;
import dns.web.drivers.WebDriverFactory;
import dns.web.helpers.NavigationHelper;
import dns.web.helpers.ScreenHelper;
import dns.web.helpers.WindowHelper;
import dns.web.pages.ElektrikStovePage;
import dns.web.pages.StartPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StartPageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Список в который положим разделы Бытовой техники
    List<String> actualListCategory;
    int actualCountSubCategory;

    StartPage startPage = new StartPage(WebDriverFactory.getCurrentDriver());

    ElektrikStovePage elektrikStovePage = new ElektrikStovePage(WebDriverFactory.getCurrentDriver());

    StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);

    // Шаг: Открыта страница "Стартовая страница сайта DNS"
    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
        // Закрытие всплывающего окна
        startPage.clickButtonAssept().click();
        // Обновляем страницу
        NavigationHelper.refresh();
        ScreenHelper.makeScreenshotFullPage(WebDriverFactory.getCurrentDriver());
    }

    // Шаг: Выполнен переход на страницу "Ноутбуки"
    @Когда("Выполнен переход на страницу \"Ноутбуки\"")
    public void goToSmartphonesPage() {
        // Наведение курсора мыши на ссылку
        startPage.getLinkComputerAndLaptop().focusOnLink();
        // Скриншот всей страницы (с прокруткой) после открытия меню
        ScreenHelper.makeScreenshotFullPage(WebDriverFactory.getCurrentDriver());
        // Переходим по ссылке Ноутбуки
        startPage.getLinkLaptop().click();
    }

    // Шаг: Выполнено наведение на ссылку "Бытовая техника"
    @Когда("Выполнено наведение на ссылку Бытовая техника")
    public void goToAppliances() throws InterruptedException {
        // Закрытие всплывающего окна
        //startPage.clickButtonAssept().click();
        // Обновляем страницу
        //NavigationHelper.refresh();
        // Наводим курсор по ссылке Бытовая техника
        startPage.getLinkAppliances().focusOnLink();
        // Получаем список категорий
        actualListCategory = startPage.getAppliancesCategoryName();
    }

    // Шаг: Проверка: разделов Бытовой техники на соответствие заданному списку
    @Тогда("Проверка: разделов Бытовой техники на соответствие заданному списку")
    public void checkCountAppiiancesCategory(List<String> expectedListCategory) {
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        // Проверка разделов бытовой техники на соответствие заданному списку
        startPageMatcher.checkPageListCategoryEquals(expectedListCategory, actualListCategory);
    }

    // Шаг: Выполнено наведение на ссылку Холодильное оборудование
    @И("Выполнено наведение на ссылку Холодильное оборудование")
    public void moveRefrigerationEquipment() throws InterruptedException {
        // Наводим курсор на ссылку Холодильное оборудование
        startPage.getLinkRefrigerationEquipment().focusOnLink();
        // Получаем список веб элементов из раздела Холодильное оборудование и пишем его в логи
        List<String> list = startPage.getListRefrigerationEquipmentName();
        for (String x : list) {
            logger.info("Холодильное оборудование - " + x);
        }
        actualCountSubCategory = startPage.getListRefrigerationEquipmentName().size();
    }

    // Шаг: Проверка: количество категорий из раздела Холодильное оборудование больше <n>
    @Тогда("Проверка: количество категорий из раздела Холодильное оборудование больше <n>")
    public void checkCountRefrigerationEquipmentCategory(Integer expectedCountSubCategory) {
        // Проверяем что количество категорий из раздела Холодильное оборудование больше заданного значения
        startPageMatcher.checkCountSubcategory(expectedCountSubCategory, actualCountSubCategory);
    }

    // Шаг: Выполнен переход по ссылке Плиты
    @И("Выполнен переход по ссылке Плиты")
    public void goStovePage() {
        // Наводим курсор на плиты (stove) и кликаем
        startPage.getLinkStove().focusOnLink();
        startPage.getLinkStove().click();
    }

    // Шаг: Выполнен переход по ссылке Электрические плиты
    @И("Выполнен переход по ссылке Электрические плиты")
    public void goElektrikStovePage() {
        // Переходим по ссылке Плиты электрические
        startPage.getLinkElektrikStove().click();
    }

    // Шаг: Выполнен переход на страницу Бытовая техника
    @Когда("Выполнен переход на страницу Бытовая техника")
    public void goAppliancesPage() {
        // Выводим в логи заголовок
        logger.info("Заголовок страницы - " + WebDriverFactory.getCurrentDriver().getTitle());
        // Выводим в логи url
        logger.info("Текущий URL - " + WebDriverFactory.getCurrentDriver().getCurrentUrl());
        // Выводим в логи размер окна браузера
        logger.info("Размеры окна браузера - " + WindowHelper.getWindowSize());
        // Переходим по ссылке Бытовая техника
        startPage.getLinkAppliances().click();
    }
}