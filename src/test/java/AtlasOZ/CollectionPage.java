package AtlasOZ;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;

public interface CollectionPage extends WebPage {
    @FindBy("//ul[@id=\"goods-table\"]/li")
    ElementsCollection<WebElement> collection();

    @FindBy("//ul[@class=\"b-map-select__dropdown-list\"]//span[@class=\"b-map-select__dropdown-text\"]")
    ElementsCollection<WebElement> collectionShops();

    @FindBy("//div[@id=\"dd_id_producer\"]//a[@class=\"link-facet-bot\"]")
    ElementsCollection<WebElement> itemBrandFilter();

    @FindBy("//div[@id=\"dd_v6\"]//label")
    ElementsCollection<WebElement> itemFeaturesFilter();

    @FindBy("//div[@id=\"dd_v3\"]//a")
    ElementsCollection<WebElement> itemViewFilter();

    @FindBy("//div[@id=\"dd_ti1\"]//a")
    ElementsCollection<WebElement> itemTypeFilter();
}
