package org.simbirsoft.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.simbirsoft.helpers.ConfProperties;
import org.simbirsoft.helpers.Helpers;
import org.simbirsoft.pages.LoginPage;
import org.simbirsoft.pages.SendingPage;
import org.simbirsoft.pages.Waiters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class SendingTest {

    private WebDriver driver;

     @BeforeMethod
     public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginAndSendingMessage() {
        driver.get(ConfProperties.getProperty("mailpage"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton()
                .inputLogin(ConfProperties.getProperty("login"))
                .clickLoginButton()
                .inputPassword(ConfProperties.getProperty("password"))
                .clickLoginButton();

        SendingPage sendingPage = new SendingPage(driver);
        int messagesBefore = sendingPage.numberOfMessages();
        sendingPage.clickWriteButton()
                .inputTo("soft.simbir@yandex.ru")
                .inputTheme("Simbirsoft theme")
                .inputMessages()
                .clickSendButton();

        Waiters waiters = new Waiters(driver);
        waiters.alertSent();

        Helpers helpers = new Helpers(driver);
        helpers.refreshPage();

        int messagesAfter = sendingPage.numberOfMessages();
        Assert.assertEquals(messagesBefore +1, messagesAfter, "Сообщение не было отправлено");
        }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
