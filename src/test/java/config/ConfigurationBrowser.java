package config;

import com.codeborne.selenide.Configuration;

public class ConfigurationBrowser {
    public void mainSetUpBrowser() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
}
