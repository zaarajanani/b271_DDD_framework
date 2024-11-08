package com.vcentry.testcase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vcentry.base.BaseClass;
import com.vcentry.pages.LoginPage;
import com.vcentry.utils.Function;

public class LoginTest extends BaseClass {
    LoginPage login;
	@BeforeMethod
	public void launchUrl() {
		driver.get(Function.getProp("loginUrl"));
		}
	@Test
	public void LoginWithValidCredentials(String uName,String pwd,String expectedResult) {
		login.enterUsername(uName);
		login.enterPassword(pwd);
		login.clickLoginBtn();
		login.verifyHomePage(expectedResult);
   }
	@Test
	public void LoginWithInValidCredentials(String uName,String pwd,String expectedResult) {
		login.enterUsername(uName);
		login.enterPassword(pwd);
		login.clickLoginBtn();
		login.verifyError(expectedResult);
	}
  @DataProvider(name="ValidLogin")
  public String[][] validLogin() {
	  return Function.getTestData("login", "ValidCredentails");
  }
  @DataProvider(name="InValidLogin")
  public String[][] InvalidLogin() {
	  return Function.getTestData("login", "InValidCredentails");
  }

}
