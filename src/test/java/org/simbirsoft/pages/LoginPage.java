package org.simbirsoft.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    WebElement loginField;

    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    WebElement passwordField;

    /**
     * метод для ввода логина
     */
    public LoginPage inputLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
    /**
     * метод для ввода пароля
     */
    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
}