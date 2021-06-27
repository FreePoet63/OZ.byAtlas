package selectors;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;

public interface CollectionPage extends WebPage {
    @FindBy("//ul[@id=\"goods-table\"]/li")
    ElementsCollection<WebElement> collection();

    @FindBy("//div[@id=\"dd_ti1\"]//a")
    ElementsCollection<WebElement> itemTypeFilter();

    @FindBy("//div[@id=\"dd_ti5\"]//label")
    ElementsCollection<WebElement> viewItems();

    @FindBy("//ul[@class=\"b-map-select__dropdown-list\"]//li")
    ElementsCollection<WebElement> sitiesList();
}
