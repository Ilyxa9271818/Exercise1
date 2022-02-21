package org.simbirsoft.helpers;

import org.openqa.selenium.WebDriver;
import org.simbirsoft.pages.Waiters;

public class Helpers {

    private  WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
