package dns.web.pages;

import dns.web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppliancesPage extends BasePage {

    private Logger logger = LogManager.getLogger(AppliancesPage.class);

    public AppliancesPage(WebDriver driver) {
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Веб элемент - заголовок раздела
    @FindBy(xpath = "//h1[@class='subcategory__page-title']")
    private WebElement textBoxTechnique;

    // Веб элемент - ссылка на раздел Техника для кухни
    @FindBy(xpath = "//span[text() = 'Техника для кухни']")
    private WebElement linkKitchenAppliances;

    public String getTextBoxTechnique() {
        return textBoxTechnique.getText();
    }

    public Link getLinkKitchenAppliances() {
        return new Link(linkKitchenAppliances);
    }
}
