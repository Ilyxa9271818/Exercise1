package org.simbirsoft.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    WebElement loginField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    WebElement passwordField;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

}