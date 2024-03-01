package com.cp.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cp.guru99.base.Base;

public class LoginPageTitleCheck extends Base {
		@Test
		public void LOGINTITLETEST() {
			boolean result = obj_login.Login_Page_Title(drive_WD);
			Assert.assertTrue(result);
		}
}