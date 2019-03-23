package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


import com.TestUtil.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TestBase.class.getClass());
	

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\mdisl\\eclipse-workspace_Fall_2018\\techfiosbilling\\src\\main\\java\\com\\Config\\Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialize() {
		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		    driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADOUTTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITYWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}
	@BeforeTest
	public void log() {
		String log4jCofigPath= System.getProperty("user.dir") + "\\src\\main\\java\\log4j.properties";
		PropertyConfigurator.configure(log4jCofigPath);
	}
	

}
