package LogInGitHub.build;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class = 'AppHeader-user']//button[@aria-label = 'Open user account menu']")
    private WebElement avatarMenu;

    @FindBy(xpath = "//*[contains(text(), 'Your repositories')]")
    private WebElement btnRepo;

    public void clickAvatarMenu() {
        avatarMenu.click();
    }

    public void clickBtnRepo() {
        btnRepo.click();
    }
}
