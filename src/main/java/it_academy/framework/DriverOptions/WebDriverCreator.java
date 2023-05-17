package it_academy.framework.DriverOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverCreator <T extends RemoteWebDriver> {
    T create();
}
