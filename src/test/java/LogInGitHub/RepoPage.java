package LogInGitHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RepoPage {

    WebDriver driver;

    public RepoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void countRepo() {
        List<WebElement> repo = driver.findElements(By.xpath("//*[@id = 'user-repositories-list']//li"));
        System.out.println("Количество репозиториев: " + repo.size());
    }
}
