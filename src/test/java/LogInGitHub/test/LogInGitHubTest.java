package LogInGitHub.test;

import LogInGitHub.core.BaseTest;
import LogInGitHub.core.ConfProperties;
import LogInGitHub.core.TypeBrowsers;
import LogInGitHub.build.LoginPage;
import LogInGitHub.build.ProfilePage;
import LogInGitHub.build.RepoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class LogInGitHubTest extends BaseTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static RepoPage repoPage;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public static class TestSuite1 {
        @BeforeAll
        public static void setUp() {
            String browsers = ConfProperties.getProperty("browsers");
            TypeBrowsers typeBrowsers = Arrays.stream(TypeBrowsers.values())
                    .filter(tb -> browsers.equalsIgnoreCase(tb.name()))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
            initBrowser(typeBrowsers);
            loginPage = new LoginPage(BaseTest.driver);

        }


        @Test
        @Order(1)
        public void logInGitHub() {
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            loginPage.inputPassword(ConfProperties.getProperty("password"));
            loginPage.clickBtnSignIn();

        }


        @Test
        @Order(2)
        public void openPageWithRepo() {
            profilePage = new ProfilePage(BaseTest.driver);
            profilePage.clickAvatarMenu();
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'AppHeader-user']//button[@aria-label = 'Open user account menu']")));
            profilePage.clickBtnRepo();
        }

        @Test
        @Order(3)
        public void countRepo() {
            repoPage = new RepoPage(BaseTest.driver);
            repoPage.countRepo();
        }

        @AfterAll
        public static void quitDriver() {
            driver.quit();
        }
    }
}
