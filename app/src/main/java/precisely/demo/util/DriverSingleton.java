package precisely.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSingleton {
    private static WebDriver driver;
    private static final String GECKO_DRIVER_PATH = "C:/Learnings/Resources/geckodriver.exe"; 

    private DriverSingleton() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

                // Set Firefox Options to disable cookies
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("network.cookie.cookieBehavior", 2); // 2 means block all cookies
                options.addPreference("network.cookie.lifetimePolicy", 2); // Session-only cookies

                driver = new FirefoxDriver(options);
            } catch (Exception e) {
                System.out.println("GeckoDriver not found at specified path. Using WebDriverManager...");
                WebDriverManager.firefoxdriver().setup();

                // Set Firefox Options to disable cookies in WebDriverManager setup
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("network.cookie.cookieBehavior", 2); // Block all cookies
                options.addPreference("network.cookie.lifetimePolicy", 2); // Session-only cookies

                driver = new FirefoxDriver(options);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
