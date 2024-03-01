package com.cp.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cp.guru99.base.Base;

public class LoginPageUICheck extends Base{
	@Test
	public void LOGINUICHECK() {
		boolean result = obj_login.LoginPage_UI(drive_WD);
		Assert.assertTrue(result);
	}
}