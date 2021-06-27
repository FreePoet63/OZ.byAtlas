package settings;

import io.qameta.allure.Attachment;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import selectors.AtlasWEbPage;

import java.util.concurrent.TimeUnit;

public class StartSettings {
    public static WebDriver driver;
    public static Atlas atlas;

    @Before
    public void startDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        atlas = new Atlas(new WebDriverConfiguration(driver));
        onPage(AtlasWEbPage.class).open("https://oz.by/");
    }

    @After
    public void closeOz() {
        screenshotPNG();
        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshotPNG() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
