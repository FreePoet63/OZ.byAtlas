package pagetest;

import io.qameta.allure.*;
import org.junit.Test;
import settings.StartSettings;

import static methoddefault.MethodsToDefault.moveToElement;
import static methoddefault.MethodsToDefault.withAssertCollection;
import static page.OzAllMethods.clickButton;
import static page.OzAllMethods.searchElementPage;

public class OZPageWomensProductsTest extends StartSettings {

    @Step
    @Test
    @Description("Selecting shampoo from the list of products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search for shampoo")
    public void searchShampooProductTest()  {
        moveToElement(driver, "Косметика, парфюмерия");
        searchElementPage("Шампуни");
        searchElementPage("Kapous");
        searchElementPage("Жидкий");
        searchElementPage("Для всех типов");
        searchElementPage("Восстановление");
        clickButton("Применить");
        withAssertCollection( "Kapous");
    }
}
