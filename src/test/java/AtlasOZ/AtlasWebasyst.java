package AtlasOZ;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface AtlasWebasyst extends WebPage, SearchPage {
    @SuppressWarnings("rawtypes")
    @FindBy("//span[contains(text(), '{{ text }}')]")
    AtlasWebElement newInput (@Param("text") String text);

    @SuppressWarnings("rawtypes")
    @FindBy("//a[contains(text(), '{{ text }}')]")
    AtlasWebElement linkText (@Param("text") String text);
}
