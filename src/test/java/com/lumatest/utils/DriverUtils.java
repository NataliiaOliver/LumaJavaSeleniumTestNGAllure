package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverUtils {

    private static final ChromeOptions chromeOptions;
    private static final FirefoxOptions firefoxOptions;
    private static final EdgeOptions edgeOptions;

    static {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--ignore-certificate-errors");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "./src/test/resources");
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put( "safebrowsing.enabled", true);
        chromeOptions.setExperimentalOption("prefs", prefs);

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
//        firefoxOptions.addArguments("--disable-web-security");

        edgeOptions = new EdgeOptions();
//        edgeOptions.addArguments("--incognito");
//        edgeOptions.addArguments("--headless");
//        edgeOptions.addArguments("--window-size=1920,1080");
//        edgeOptions.addArguments("--disable-gpu");
//        edgeOptions.addArguments("--no-sandbox");
//        edgeOptions.addArguments("--disable-dev-shm-usage");
//        edgeOptions.addArguments("--disable-web-security");
    }

    private static WebDriver createChromeDriver(WebDriver driver) {
        if (driver == null) {
            return new ChromeDriver(chromeOptions);
        } else {
            driver.quit();
            return new ChromeDriver(chromeOptions);
        }
    }

    private static WebDriver createFirefoxDriver(WebDriver driver) {
        if (driver == null) {
            return new FirefoxDriver(firefoxOptions);
        } else {
            driver.quit();
            return new FirefoxDriver(firefoxOptions);
        }
    }

    private static WebDriver createEdgeDriver(WebDriver driver) {
        if (driver == null) {
            return new EdgeDriver(edgeOptions);
        } else {
            driver.quit();
            return new EdgeDriver(edgeOptions);
        }
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
        switch (browser) {
            case "chrome" -> {
                return createChromeDriver(driver);
            }
            case "firefox" -> {
                return createFirefoxDriver(driver);
            }
            case "edge" -> {
                return createEdgeDriver(driver);
            }
            default -> {
                return null;
            }
        }
    }
}