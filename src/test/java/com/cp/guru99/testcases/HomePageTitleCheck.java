package com.cp.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cp.guru99.base.Base;
import com.cp.guru99.utills.Utilities;

public class HomePageTitleCheck extends Base{
	@Test
	public void homePageTitleCheck() {
		String myCred[][];
		myCred = Utilities.supplyData("Login");

		for (String[] data : myCred) {
			String userName = data[0];
			String password = data[1];
			objhome = obj_login.loginThePage(userName, password);
			// Add your logic for handling the home page after login
		}
		boolean result = objhome.verfiyHomepageTitle(drive_WD);
		Assert.assertTrue(result);
	}
}
