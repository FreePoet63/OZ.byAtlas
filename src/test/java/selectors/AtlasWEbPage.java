package selectors;

import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface AtlasWEbPage extends WebPage, SearchPage {

    @FindBy("//a[contains(text(), '{{ text }}')]")
    AtlasWebElement linkText (@Param("text") String text);

    @FindBy("//div[starts-with(@class, \"i-icon-2\")]")
    AtlasWebElement citiesText ();
}
