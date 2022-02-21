package org.simbirsoft.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SendingPage {

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

    public SendingPage clickWriteButton() {
        writeButton.click();
        return this;
    }

    public SendingPage inputTo(String to) {
       toField.sendKeys(to);
        return this;
    }

    public SendingPage inputTheme(String theme) {
        themeField.sendKeys(theme);
        return this;
    }

    public int numberOfMessages() {
        return numberMessages.size();
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public SendingPage inputMessages() {
        messageField.sendKeys("Найдено ", String.valueOf(numberMessages.size()), " писем/ьма");
        return this;
    }
}