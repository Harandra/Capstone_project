package com.cp.guru99.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cp.guru99.pages.Home_Page;
import com.cp.guru99.pages.Login_Page;

public class Base {
	public WebDriver driver;
	public WebDriver initializeBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Compatible Browser Found");
		}
		
		driver.get("https://demo.guru99.com/v4/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}
	public Login_Page obj_login;
	public Home_Page objhome;
	public WebDriver drive_WD;
	
	String url = "https://demo.guru99.com/V1/index.php";
	@BeforeMethod
	public void inittest() {
		drive_WD = initializeBrowser("chrome");
		drive_WD.manage().window().maximize();
		drive_WD.get(url);

		obj_login = PageFactory.initElements(drive_WD, Login_Page.class);
		objhome = PageFactory.initElements(drive_WD, Home_Page.class);
	}

	@AfterMethod
	public void TearDown() {
		drive_WD.quit();
	}
}