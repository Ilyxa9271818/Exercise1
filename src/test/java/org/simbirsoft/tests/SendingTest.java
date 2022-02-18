package org.simbirsoft.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.simbirsoft.helpers.ConfProperties;
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
        SendingPage sendingPage;
        Waiters waiters;
        LoginPage loginPage;

        waiters = new Waiters(driver);
        sendingPage = new SendingPage(driver);
        loginPage = new LoginPage(driver);

        driver.get(ConfProperties.getProperty("mailpage"));
        loginPage.clickLoginButton();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginButton();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();

        int messagesBefore = sendingPage.numberOfMessages();
        sendingPage.clickWriteButton();
        sendingPage.inputTo("soft.simbir@yandex.ru");
        sendingPage.inputTheme("Simbirsoft theme");
        sendingPage.inputMessages();
        sendingPage.clickSendButton();
        waiters.alertSent();
        driver.navigate().refresh();
        int messagesAfter = sendingPage.numberOfMessages();
        Assert.assertEquals(messagesBefore +1, messagesAfter, "Сообщение не было отправлено");
        }


    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
