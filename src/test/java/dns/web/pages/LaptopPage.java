package dns.web.pages;

import dns.web.elements.*;
import dns.web.helpers.JavaScriptHelper;
import dns.web.helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaptopPage extends BasePage {

    private Logger logger = LogManager.getLogger(LaptopPage.class);

    private String company = "ASUS";

    public LaptopPage(WebDriver driver) {
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Веб элемент header
    @FindBy(xpath = "//header")
    private WebElement blockHeader;
    // Веб элемент Строка поиска
    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement inputCompany;
    // Веб элемент Чекбокс производитель
    @FindBy(xpath = "//span[text()='{company}  ']")
    private WebElement checkBoxCompany;
    // Веб элемент аккордеон Объем оперативной памяти
    @FindBy(xpath = "//span[text()='Объем оперативной памяти (ГБ)']")
    private WebElement accordeonRAM;
    // Список веб элементов со значениями объема оперативной памяти
    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти (ГБ)\"]/../../div//label/span[1]")
    private List<WebElement> checkboxRAM;
    // Веб элемент кнопка Применить
    @FindBy(xpath = "//button[text()='Применить']")
    private WebElement buttonApply;
    // Веб элемент аккордеон Сортировка:
    @FindBy(xpath = "//span[text()='Сортировка:']")
    private WebElement accordeonS;
    // Список веб элементов со значениями сортировки
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]//span")
    private List<WebElement> radiobuttonSort;
    // Веб элемент аккордеон Производитель
    @FindBy(xpath = "//span[text()='Производитель']")
    private WebElement accordeonCompany;
    // Список веб элементов со значениями Производитель
    @FindBy(xpath = "//span[text()=\"Производитель\"]/../../div//label/span[1]")
    private List<WebElement> checkboxCompany;
    // Веб элемент с сылкой на первый элемент из списка
    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;
    // Веб элемент с названием первого элемента (для дальнейшей проверки)
    @FindBy(xpath = "//div[@data-id='product']/a")
    private WebElement textFirstElement;

    // Скрытие шапки
    public void blockHeaderHide() {
        JavaScriptHelper.displayNone(blockHeader);
    }

    // Чекбоксы "Производитель"
    public CheckBox checkboxCompany(String company) {

        for (WebElement webElement : checkboxCompany) {
            if (webElement.getText().contains(company)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    // Аккордеон "Объем оперативной памяти"
    public Accordeon accordeonRAM() {
        return new Accordeon(accordeonRAM);
    }
    // Чекбоксы "Объем оперативной памяти"
    public CheckBox checkboxRAM(String ram) {
        for (WebElement webElement : checkboxRAM){
            if (webElement.getText().contains(ram)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    // Кнопка "Применить"
    public Button buttonApply() {
        return new Button(buttonApply);
    }

    // Аккордеон "Сортировка"
    public Accordeon accordeonSort() {
        return new Accordeon(accordeonS);
    }

    // Переключатели "Сортировка"
    public RadioButton radiobuttonSort(String type) {
        for (WebElement webElement : radiobuttonSort) {
            if(webElement.getText().contains(type)) {
                return new RadioButton(webElement);
            }
        }
        return null;
    }

    // Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        return new Link(linkFirstProduct);
    }

    //Получаем название ноутбука для дальнейшей проверки на соответствие ожидаемому заголовку страницы
    public String getNameFirstElement(){
        WaitHelper.visibilityOfElement(textFirstElement);
        String expectedTitle = textFirstElement.getText();
        expectedTitle = expectedTitle.substring(0, expectedTitle.indexOf("["));
        return expectedTitle;
    }

    // Получаем веб элемент header
    public WebElement getHeader() {
        return blockHeader;
    }
}
