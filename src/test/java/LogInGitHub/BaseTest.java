package LogInGitHub;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    public static void initBrowser(TypeBrowsers typeBrowsers) {
        switch (typeBrowsers) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(ConfProperties.getProperty("site"));
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(ConfProperties.getProperty("site"));
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
            default -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(ConfProperties.getProperty("site"));
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        }
        // return driver;
    }
}
