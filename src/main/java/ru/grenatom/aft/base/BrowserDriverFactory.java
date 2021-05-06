package ru.grenatom.aft.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;



public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;



	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	public WebDriver createDriver () throws MalformedURLException, InterruptedException{
		//System.out.println("Starting " + browser + " locally");
		Assert.assertTrue(true, "Starting " + browser + " locally");

		// Creating driver
		switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "c:/Selenium/chromedriver.exe");
				driver.set(new ChromeDriver());
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "c:/Selenium/geckodriver.exe");
				driver.set(new FirefoxDriver());
				break;

			case "android":

				/*
				File appDir = new File("/apps");
				File app = new File(appDir, "eribank.apk");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
				capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60000);
				capabilities.setCapability("--session-override", true);
				driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
				 */


				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "Galaxy_Nexus_API_28");
				caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
				caps.setCapability("platformName", "Android");
				caps.setCapability("platformVersion", "9.0");
				caps.setCapability("skipUnlock", "true");
				caps.setCapability("appPackage", "com.experitest.ExperiBank");
				caps.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
				caps.setCapability("noReset", "false");
				driver.set(new AndroidDriver<MobileElement>(new URL("http://192.168.31.5:4723/wd/hub"), caps));		}

		return driver.get();
	}

	public WebDriver createDriverGrid() {
		String hubUrl = "http://192.168.99.128:4445/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//System.out.println("Starting " + browser + " on grid");
		Assert.assertTrue(true, "Starting " + browser + " on grid");

		// Creating driver
		switch (browser) {
			case "chrome":
				capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
				break;

			case "firefox":
				capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
				break;

			case "android":

				File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "/Apps/");
				File app = new File(appDir, "com.experitest.ExperiBank.apk");
				capabilities.setCapability(CapabilityType.APPLICATION_NAME, "ExperiBank");
				capabilities.setCapability("deviceName", "XEDDU18804000040");
				capabilities.setCapability("platformVersion", "9");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
				break;
		}

		try {
			driver.set(new RemoteWebDriver(new URL(hubUrl), capabilities));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver.get();
	}

}
