package lab.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    private static ThreadLocal<WebDriver> webDriver = ThreadLocal.withInitial(() -> {
        System.setProperty(PropertyReader.get("driver_name"), PropertyReader.get("driver_path"));
        return new ChromeDriver();
    });

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void load(String URL) {
        getDriver().get(URL);
    }

    public static void close() {
        webDriver.get().quit();
        webDriver.remove();
    }

    public static WebDriverWait newWait() {
        return new WebDriverWait(getDriver(), 10);
    }
}
