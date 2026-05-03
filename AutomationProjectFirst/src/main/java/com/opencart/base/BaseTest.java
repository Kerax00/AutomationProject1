package com.opencart.base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

	static String url = "https://automationexercise.com/";
	static WebDriver driver;

	@BeforeMethod
	public void browserLaunch() throws MalformedURLException, URISyntaxException {
		// Instantiate the chrome options
		ChromeOptions options = new ChromeOptions();
		// add the headless argument to the options
		options
				.addArguments("headless", "--remote-allow-origins=*");
		// set the platform independent arguments in the setCapability
		options
				.setCapability("platformName", Platform.ANY);
		// Instantiate the remotewebdriver
		driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub")
				.toURL(), options);
		// manage the resolution of the window
		driver
				.manage()
				.window()
				.maximize();
		// Launch the url
		driver
				.navigate()
				.to(url);
	}

	@Test
	public void getTitle() {
		// get the title of the homepage
		String title = driver
				.getTitle();
		System.out
				.println(title);
		System.out
				.println("And it worked!!!!");
	}

	@AfterMethod
	public void browserClose() {
		if (driver != null) {
			driver
					.quit();
		}
	}

}
