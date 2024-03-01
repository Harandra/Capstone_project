package com.cp.guru99.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cp.guru99.utills.Utilities;

public class Home_Page {
	public WebDriver driver;

	@FindBy(linkText = "Manager")
	WebElement manager;

	@FindBy(linkText = "New Customer")
	WebElement newcustomer;
	
	@FindBy(linkText="Log out")
	WebElement logout;
	
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public boolean verfiyHomepageTitle(WebDriver driver) {
		boolean result = Utilities.validateTitle(driver, "GTPL Bank Manager HomePage");
		return result;

	}

	public boolean Verifyelementpresencein_HomePage(WebDriver driver) {
		boolean result = true;
		ArrayList<WebElement> menulist = new ArrayList<WebElement>();
		menulist.add(manager);
		menulist.add(newcustomer);

		for (int i = 0; i < menulist.size(); i++) {
			Utilities.CheckElementPresence(driver, menulist.get(i), 20);
			if (result == false) {
				break;
			}
		}

		return result;
		
	}
	public boolean presenceOfLogOut() {
		return logout.isDisplayed();
	}
}

