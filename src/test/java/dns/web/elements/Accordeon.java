package dns.web.elements;

import dns.web.helpers.ActionHelper;
import dns.web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

// Класс "Гармошка"
public class Accordeon extends BaseElement {

    // Конструктор
    public Accordeon(WebElement webElement) {
        super(webElement);
    }

    // Раскрытие гармошки
    public void show() {
        // Ожидание кликабельности гармошки
        WaitHelper.clickabilityOfElement(webElement);
        ActionHelper.moveToElement(webElement);
        webElement.click();
    }
}
