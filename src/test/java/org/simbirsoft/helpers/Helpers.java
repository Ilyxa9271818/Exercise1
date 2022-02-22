package org.simbirsoft.helpers;

import org.openqa.selenium.WebDriver;

public class Helpers {

    private  WebDriver driver;
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public Helpers(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * метод для обновления сайта
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }
}
