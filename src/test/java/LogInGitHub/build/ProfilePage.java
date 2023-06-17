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

    @FindBy(xpath = "//div[@class = 'Header-item position-relative mr-0 d-none d-md-flex']//summary[@aria-label = 'View profile and more']")
    private WebElement avatarMenu;

    @FindBy(xpath = "//*[@class = 'dropdown-menu dropdown-menu-sw']/a[text()='Your repositories']")
    private WebElement btnRepo;

    public void clickAvatarMenu() {
        avatarMenu.click();
    }

    public void clickBtnRepo() {
        btnRepo.click();
    }
}
