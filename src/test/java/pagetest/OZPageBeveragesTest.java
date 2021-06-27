package pagetest;

import io.qameta.allure.*;
import org.junit.Test;
import settings.StartSettings;

import static methoddefault.MethodsToDefault.moveToElement;
import static methoddefault.MethodsToDefault.withAssertCollection;
import static page.OzAllMethods.*;

public class OZPageBeveragesTest extends StartSettings {

    @Step
    @Test
    @Description("Searching for coffee using filters")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Finding coffee")
    public void itemsCoffee(){
        moveToElement(driver, "Продукты, деликатесы");
        searchElementPage("Кофе");
        elementCollection(2);
        elementFilterCollection(0);
        clickButton("Применить");
        withAssertCollection( "Кофе молотый");
    }
}
