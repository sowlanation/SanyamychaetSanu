package LogInGitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id = 'login_field']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class = 'btn btn-primary btn-block js-sign-in-button']")
    private WebElement btnSignIn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickBtnSignIn() {
        btnSignIn.click();
    }
}
