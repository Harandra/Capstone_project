package com.cp.guru99.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cp.guru99.utills.Utilities;

public class Login_Page {
	WebDriver driver;
	
	@FindBy(name = "uid")
	WebElement Username;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(name = "btnLogin")
	WebElement login;

	@FindBy(name = "btnReset")
	WebElement Reset;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean Login_Page_Title(WebDriver driver) {
		
		String Expected_Title = "GTPL Bank Home Page";
		boolean result = Utilities.validateTitle(driver, Expected_Title);
		return result;
	}

	public boolean LoginPage_UI(WebDriver driver) {
		boolean result = true;
		
		ArrayList<WebElement> menulist = new ArrayList<WebElement>();
		menulist.add(Username);
		menulist.add(Password);
		menulist.add(login);
		menulist.add(Reset);
		
		for (int j =0; j<menulist.size(); j++) {
		
			Utilities.CheckElementPresence(driver, menulist.get(j),20);
			if (result == false) {
				break;
			}
		}
	
		return result;
		
	}
	public Home_Page loginThePage(String uname, String pwd){
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
		login.click();
		return new Home_Page(driver);
	}
}
