package Testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import Libraryfiles.Libraryfilesbaseclass;

public class LoginTest extends Libraryfilesbaseclass{
	
	public static LoginTest login1;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
	}
	@Test(priority=1,description ="Checking title of page")
	public void validatepagetitle() {
		String tilte=driver.getTitle(); 
		Assert.assertEquals(tilte,"Self Drive Car Rentals in Bangalore | Rent a car in Bangalore | Drivezy");
	}
	//@Test(priority=2,description="login with username and password with success login")
	public void logincheckpass() throws InterruptedException {
		findelementandclick(loginbtn);
		Thread.sleep(2000);
		String str=findelementreturn(signinpopup);
		Assert.assertEquals(str, "Login/SignUp");
		findelementAndsendkeysforusername(username);
		clickelementAndwaitxpath(proceedbutton);
		Thread.sleep(2000);
		Buttonenablecheck(proceedbutton1);
		findelementAndsendkeysforpassword(password);
		findelementandclick(proceedbutton1);
		Thread.sleep(5000);
		String str1=findelementreturn(successfulltaost);
		Assert.assertEquals(str1, "Login Successful.");
	}
	@Test(priority=3,description="login with username and password with unsuccess login")
	public void logincheckfail() throws InterruptedException {
		findelementandclick(loginbtn);
		Thread.sleep(2000);
		String str=findelementreturn(signinpopup);
		Assert.assertEquals(str, "Login/SignUp");
		findelementAndsendkeysforusername(username);
		clickelementAndwaitxpath(proceedbutton);
		Thread.sleep(2000);
		Buttonenablecheck(proceedbutton1);
		System.out.println("button disable");
		findelementAndsendkeysforpasswordwrong(password);
		findelementandclick(proceedbutton1);
		Thread.sleep(3000);
		String str1=findelementreturn(unsuccessfulltaost);
		Assert.assertEquals(str1, "Login Failed");
	}
	@Test(priority=4,description="login with facebook")
	public void loginwithfacebook() throws InterruptedException {
		findelementandclick(loginbtn);
		Thread.sleep(3000);
		findelementandclick(loginbtnfb);
		Thread.sleep(3000);
		switchfromparenttochild();
		Thread.sleep(5000);
		clickelementAndwaitxpath(usernamefb);
		findelementAndsendkeysforusername(usernamefb);
		findelementAndsendkeysforpassword(passwordfb);
		findelementandclick(loginbtnfbonpop);
		Thread.sleep(6000);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
