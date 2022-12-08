package dns.web.pages;

import dns.web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KitchenAppliancesPage extends BasePage {

    private Logger logger = LogManager.getLogger(AppliancesPage.class);

    public KitchenAppliancesPage(WebDriver driver) {
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Веб элемент - заголовок раздела
    @FindBy(xpath = "//h1[@class='subcategory__page-title']")
    private WebElement textBoxKitchenAppliances;

    // Веб элемент - ссылка на раздел Собрать свою кухню
    @FindBy(xpath = "//a[text() = 'Собрать свою кухню']")
    private WebElement linkMakeKitchen;

    // Список Веб элементов - подкатегории
    @FindBy(xpath = "//span[@class='subcategory__title']")
    private List<WebElement> kitchenAppliancesCategories;

    public String getTextBoxKitchenAppliances() {
        return textBoxKitchenAppliances.getText();
    }

    public Link getLinkMakeKitchen() {
        return new Link(linkMakeKitchen);
    }

    public void getSubCategoryName() {
        for (WebElement element : kitchenAppliancesCategories) {
            logger.info("Техника для кухни - " + element.getText());
        }
    }

    public Integer getCountSubCategory() {
        return kitchenAppliancesCategories.size();
    }
}
