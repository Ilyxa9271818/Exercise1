package org.simbirsoft.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.simbirsoft.helpers.ConfProperties;
import org.simbirsoft.pages.LoginPage;
import org.simbirsoft.pages.SendingPage;
import org.simbirsoft.pages.Waiters;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class SendingTest {
    public static SendingPage sendingPage;
    public static Waiters waiters;
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        waiters = new Waiters(driver);
        sendingPage = new SendingPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }

     @BeforeMethod
     public void login(){
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.clickLoginButton();
        loginPage.inputLogin("soft.simbir");
        loginPage.clickLoginButton();
        loginPage.inputPassword("polkmmnb");
        loginPage.clickLoginButton();
        String user = loginPage.getUserName();
        Assert.assertEquals("soft.simbir", user, "Не удалось авторизоваться");
    }

    @Test
    public void SendingMessage() {
        driver.get(ConfProperties.getProperty("mailpage"));
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
        driver.quit();
    }
}
