package org.simbirsoft.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class    LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    WebElement loginField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    WebElement passwordField;

    @FindBy(xpath = "//*[contains(@class, 'username desk-notif-card__user-name')]")
    WebElement userMenu;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getUserName() {
        return userMenu.getText();
    }
}