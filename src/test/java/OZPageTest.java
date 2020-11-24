import AtlasOZ.AtlasWebasyst;
import AtlasOZ.CollectionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OZPageTest {

    FirefoxDriver driver;
    Atlas atlas;

    @Before
    public void startDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        atlas = new Atlas(new WebDriverConfiguration(driver));
        onPage(AtlasWebasyst.class).open("https://oz.by/");
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshotPNG() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    @Description("Plasticine selection using filters")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Plasticine search")
    public void searchPlasticineTest() {
        Actions actions = new Actions(driver);
        actions.moveToElement(onPage(AtlasWebasyst.class).linkText("Детям и мамам")).build().perform();
        onPage(AtlasWebasyst.class).linkText("Лепка").click();
        onPage(AtlasWebasyst.class).newInput("Пластилин").click();
        onPage(AtlasWebasyst.class).linkText("Пластилин").click();
        onPage(AtlasWebasyst.class).linkText("Классический").click();
        onPage(AtlasWebasyst.class).linkText("Genio Kids").click();
        onPage(AtlasWebasyst.class).button("Применить").click();
        List<WebElement> itemsChildren = onPage(CollectionPage.class).collection();
        itemsChildren.size();
        ArrayList<String> itemsChildrenText = new ArrayList<String>();
        for (WebElement ele : itemsChildren)
            itemsChildrenText.add(ele.getText());
        assertThat(itemsChildrenText, hasItem(containsString("Набор для лепки \"Лёгкий пластилин\"")));
        screenshotPNG();
    }

    @Test
    @Description("Selecting shampoo from the list of products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search for shampoo")
    public void searchShampooProduct()  {
        Actions newActions = new Actions(driver);
        newActions.moveToElement(onPage(AtlasWebasyst.class).linkText("Косметика, парфюмерия")).
                build().perform();
        onPage(AtlasWebasyst.class).linkText("Шампуни").click();
        onPage(AtlasWebasyst.class).linkText("Kapous").click();
        onPage(AtlasWebasyst.class).linkText("Рецепты бабушки Агафьи").click();
        onPage(AtlasWebasyst.class).linkText("Жидкий").click();
        onPage(AtlasWebasyst.class).linkText("Для всех типов").click();
        onPage(AtlasWebasyst.class).linkText("Восстановление").click();
        onPage(AtlasWebasyst.class).button("Применить").click();
        List<WebElement> itemsCosmetic = onPage(CollectionPage.class).collection();
        itemsCosmetic.size();
        ArrayList<String> itemsCosmeticText = new ArrayList<String>();
        for (WebElement ele : itemsCosmetic)
            itemsCosmeticText.add(ele.getText());
        assertThat(itemsCosmeticText, hasItems(containsString("Kapous"),
                containsString("Рецепты бабушки Агафьи")));
        screenshotPNG();
    }

    @Test
    @Description("List of cities in which shops are located")
    @Severity(SeverityLevel.NORMAL)
    @Story("Shops and cities")
    public void shopCities() {
        onPage(AtlasWebasyst.class).linkText("Магазины OZ").click();
        onPage(AtlasWebasyst.class).newInput("12 городов").click();
        List<WebElement> cityShop = onPage(CollectionPage.class).collectionShops();
        cityShop.size();
        ArrayList<String> cityShopText = new ArrayList<String>();
        for (WebElement ele : cityShop)
            cityShopText.add(ele.getText());
        assertThat(cityShopText, contains("Минск", "Брест", "Витебск", "Гомель", "Гродно",
                "Могилев","Бобруйск", "Пинск", "Полоцк", "Орша", "Молодечно", "Барановичи",
                "Солигорск", "" , "" , "" , "" , "" , "" , "" , "" , "" , "" , "" , "" , "" ));
        screenshotPNG();
    }

    @Test
    @Description("Using filters, we are looking for animal feed")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Finding animal feed")
    public void itemsAnimal() {
        Actions newItemsActions = new Actions(driver);
        newItemsActions.moveToElement(onPage(AtlasWebasyst.class).linkText("Дом, сад, зоотовары")).
                build().perform();
        onPage(AtlasWebasyst.class).linkText("Корм, лакомства").click();
        onPage(CollectionPage.class).itemViewFilter().get(0).click();
        onPage(CollectionPage.class).itemFeaturesFilter().get(3).click();
        onPage(CollectionPage.class).itemFeaturesFilter().get(4).click();
        onPage(CollectionPage.class).itemBrandFilter().get(0).click();
        onPage(AtlasWebasyst.class).button("Применить").click();
        List<WebElement> itemsAnimal = onPage(CollectionPage.class).collection();
        itemsAnimal.size();
        ArrayList<String> itemsAnimalText = new ArrayList<String>();
        for (WebElement ele : itemsAnimal)
            itemsAnimalText.add(ele.getText());
        assertThat(itemsAnimalText, hasItem(containsString("Корм сухой для кошек")));
        screenshotPNG();
    }

    @Test
    @Description("Searching for coffee using filters")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Finding coffee")
    public void itemsCoffee(){
        Actions newItemsActions = new Actions(driver);
        newItemsActions.moveToElement(onPage(AtlasWebasyst.class).linkText("Продукты, деликатесы")).
                build().perform();
        onPage(AtlasWebasyst.class).linkText("Кофе").click();
        onPage(CollectionPage.class).itemBrandFilter().get(0).click();
        onPage(CollectionPage.class).itemBrandFilter().get(2).click();
        onPage(CollectionPage.class).itemTypeFilter().get(2).click();
        onPage(AtlasWebasyst.class).button("Применить").click();
        List<WebElement> itemsCollectionCoffee = onPage(CollectionPage.class).collection();
        itemsCollectionCoffee.size();
        ArrayList<String> itemsCoffeeText = new ArrayList<String>();
        for (WebElement ele : itemsCollectionCoffee)
            itemsCoffeeText.add(ele.getText());
        assertThat(itemsCoffeeText, hasItem(containsString("Кофе молотый")));
        screenshotPNG();
    }

    @After
    public void closeOz() {
        driver.quit();
    }
}
