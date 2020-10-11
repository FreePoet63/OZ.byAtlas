package AtlasOZ;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface SearchPage {
    @SuppressWarnings("rawtypes")
    @FindBy("//button[contains(text(), '{{ text }}')]")
    AtlasWebElement button (@Param("text") String text);
}
