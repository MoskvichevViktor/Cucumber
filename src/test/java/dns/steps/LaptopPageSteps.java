package dns.steps;

import dns.web.drivers.WebDriverFactory;
import dns.web.helpers.JavaScriptHelper;
import dns.web.helpers.NavigationHelper;
import dns.web.helpers.ScreenHelper;
import dns.web.helpers.WaitHelper;
import dns.web.pages.LaptopPage;
import io.cucumber.java.ru.И;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LaptopPageSteps {

    // Переменная в которую положим название первого элемента после сортировки для дальнейшей проверки
    public static String expectedNameFirstElement;

    private static Logger logger = LogManager.getLogger(dns.steps.StartPageSteps.class);

    // Ссылка на объект класса LaptopPage
    LaptopPage laptopPage = new LaptopPage(WebDriverFactory.getCurrentDriver());

    // Шаг: Открыта страница "Стартовая страница сайта DNS"
    @И("Выбран в фильтре Производитель значение {string}")
    public void filtrCompany(String company) {
        // Страница Ноутбуки
        // Скрываем блок страницы
        laptopPage.blockHeaderHide();
        WaitHelper.invisibilityOf(laptopPage.getHeader());
        // Скриншот всей страницы (с прокруткой) после скрытия блока
        ScreenHelper.makeScreenshotFullPage(WebDriverFactory.getCurrentDriver());
        JavaScriptHelper.scrollBy(0, 800);
        // Установка фильтра "Производитель"
        laptopPage.checkboxCompany(company).setChecked(true);
    }

    // Шаг: Выбран в фильтре Объем оперативной памяти заданное значение
    @И("Выбран в фильтре Объем оперативной памяти значение {string}")
    public void filtrRam(String ram) {
        JavaScriptHelper.scrollBy(0, 500);
        // Отображение фильтра "Объем оперативной памяти"
        laptopPage.accordeonRAM().show();
        // Установка фильтра "Объем оперативной памяти"
        laptopPage.checkboxRAM(ram).setChecked(true);
    }

    // Шаг: Применены фильтры
    @И("Применены фильтры")
    public void clickButtonApplay() {
        JavaScriptHelper.scrollBy(0, 500);
        // Нажатие на кнопку "Применить"
        laptopPage.buttonApply().click();
        // Обновляем страницу для построения списка согласно требованию
        NavigationHelper.refresh();
        // Скриншот всей страницы (с прокруткой) после применения сортировки
        ScreenHelper.makeScreenshotFullPage(WebDriverFactory.getCurrentDriver());
    }

    // Шаг: Применена сортировку
    @И("Применена сортировку {string}")
    public void sort(String type) {
        // Отображение сортировки
        laptopPage.accordeonSort().show();
        // Установка сортировки
        laptopPage.radiobuttonSort(type).setSelected(true);
        // Обновляем страницу для построения списка согласно требованию
        NavigationHelper.refresh();
        // Скриншот всей страницы (с прокруткой) после применения сортировки
        ScreenHelper.makeScreenshotFullPage(WebDriverFactory.getCurrentDriver());
    }

    // Шаг: Выполнен переход на страницу первого продукта в списке
    @И("Выполнен переход на страницу первого продукта в списке")
    public void goFirstLink() {
        // Заносим название ноутбука в переменную для дальнейшей проверки
        expectedNameFirstElement = laptopPage.getNameFirstElement();
        // Нажатие на ссылку первого продукта в списке
        laptopPage.linkFirstProduct().openInNewWindow();
    }
}
