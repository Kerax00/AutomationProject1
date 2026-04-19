package com.opencart.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import com.opencart.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends ReadConfig {

	public BaseTest() throws Exception {
		super();
	}

	public static WebDriver driver;

	@BeforeTest
	public static void browserLauch() throws Exception {

		ReadConfig config1 = new ReadConfig();

		// get the browser value using the getProperty
		System.out
				.println(config1.prop1
						.getProperty("browser"));
		System.out
				.println(config1.prop1
						.getProperty("url"));

		// 1. Setup the options FIRST
		ChromeOptions options = new ChromeOptions();

		// For the 403 Forbidden error
		options
				.addArguments("--remote-allow-origins=*");

		WebDriverManager
				.chromedriver()
				.clearDriverCache()
				.setup();
		driver = new ChromeDriver(options);
		// driver
		// .get("https://www.google.com/");

		driver
				.manage()
				.window()
				.maximize();
		driver
				.manage()
				.timeouts()
				.implicitlyWait(Duration
						.ofSeconds(10));
		driver
				.get(config1.prop1
						.getProperty("url"));

	}

}
