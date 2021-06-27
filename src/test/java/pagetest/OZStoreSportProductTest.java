package pagetest;

import io.qameta.allure.*;
import org.junit.Test;
import settings.StartSettings;

import static methoddefault.MethodsToDefault.moveToElement;
import static methoddefault.MethodsToDefault.withAssertCollection;
import static page.OzAllMethods.clickButton;
import static page.OzAllMethods.searchElementPage;

public class OZStoreSportProductTest extends StartSettings {

    @Step
    @Test
    @Description("Choosing balls in the OZ.BY store")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Finding dalls")
    public void itemsSport() {
        moveToElement(driver, "Туризм, отдых, спорт");
        searchElementPage("Мячи");
        searchElementPage("Футбольный");
        searchElementPage("Склеивание");
        clickButton("Применить");
        withAssertCollection("Мяч футбольный");
    }
}
