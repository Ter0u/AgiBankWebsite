package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void abrirNavegador() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        String url = ConfigReader.get("base.url");
        driver.get(url);
    }

    public static void fecharNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
