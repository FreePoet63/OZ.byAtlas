package methoddefault;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selectors.AtlasWEbPage;
import selectors.CollectionPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static settings.StartSettings.onPage;

public class MethodsToDefault {

    public static void moveToElement(WebDriver driver, String value) {
        WebElement e = onPage(AtlasWEbPage.class).linkText(value);
        Actions newItemsActions = new Actions(driver);
        newItemsActions.moveToElement(e)
                .build()
                .perform();
    }

    public static void withAssertCollection(String string) {
        List<WebElement> itemsCollectionCoffee = onPage(CollectionPage.class).collection();
        List<String> itemsChildrenText = itemsCollectionCoffee.stream().map(p -> p.getText())
                .collect(Collectors.toList());
        assertThat(itemsChildrenText, hasItem(containsString(string)));
    }
}
