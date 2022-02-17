package org.simbirsoft.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SendingPage {
    public WebDriver driver;
    public SendingPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Написать')]")
    WebElement writeButton;

    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    WebElement toField;

    @FindBy(xpath = "//*[contains(@class, 'composeTextField')]")
    WebElement themeField;

    @FindBy(xpath = "//div [@role='textbox']")
    WebElement messageField;

    @FindBy(xpath = "//div [@class = 'ns-view-container-desc mail-MessagesList js-messages-list']/div")
    List<WebElement> numberMessages;

    @FindBy(xpath = "//*[contains(@class, 'Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l')]")
    WebElement sendButton;

    public void clickWriteButton() {
        writeButton.click();
    }

    public void inputTo(String to) {
       toField.sendKeys(to);
    }

    public void inputTheme(String theme) {
        themeField.sendKeys(theme);
    }

    public int numberOfMessages() {
        return numberMessages.size();
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public void inputMessages() {
        messageField.sendKeys("Найдено ", String.valueOf(numberMessages.size()), " писем/ьма");
    }
}