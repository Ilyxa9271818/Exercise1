package org.simbirsoft.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SendingPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public SendingPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Написать')]")
    WebElement writeButton;

    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    WebElement toField;

    @FindBy(xpath = "//*[contains(@class, 'composeTextField')]")
    WebElement themeField;

    @FindBy(xpath = "//div [@role='textbox']")
    WebElement messageField;

    @FindBy(xpath = "//span[text() = 'Simbirsoft theme']")
    List<WebElement> numberMessages;

    @FindBy(css = ".Button2_view_default")
    WebElement sendButton;

    @FindBy(xpath = "//div [@class = 'ComposeDoneScreen-Wrapper']")
    WebElement alertSent;

    /**
     * метод для проверки наличия элемента на сайте
     */
    public WebElement getAlertSent() {
        return alertSent;
    }
    /**
     * метод для осуществления нажатия кнопки написать
     */
    public SendingPage clickWriteButton() {
        writeButton.click();
        return this;
    }
    /**
     * метод для ввода получателя
     */
    public SendingPage inputTo(String to) {
       toField.sendKeys(to);
        return this;
    }
    /**
     * метод для ввода темы
     */
    public SendingPage inputTheme(String theme) {
        themeField.sendKeys(theme);
        return this;
    }
    /**
    * метод для получения количества писем
    */
    public int numberOfMessages() {
        return numberMessages.size();
    }
    /**
     * метод для осуществления нажатия кнопки отправить
     */
    public void clickSendButton() {
        sendButton.click();
    }
    /**
     * метод для ввода письма
     */
    public SendingPage inputMessages() {
        messageField.sendKeys("Найдено ", String.valueOf(numberMessages.size()), " писем/ьма");
        return this;
    }
}