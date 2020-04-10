package Testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Libraryfiles.Libraryfilesbaseclass;

public class Vehiclelistpageforbike extends Libraryfilesbaseclass{

	public static Vehiclelistpageforcar car;
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		car = new Vehiclelistpageforcar();
	
}
	@Test(priority=1)
	public void calenderselect() throws InterruptedException {
		car.venueclick();
		Thread.sleep(2000);
		findelementandclick(clickonbike);
		Thread.sleep(4000);
    Assert.assertEquals(findelementreturn(Nofueltext), "No-fuel");
    Thread.sleep(3000);
    //car.selectcalender();
    driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
	// Thread.sleep(2000);
	findelementandclick(startdateclick);
	//Thread.sleep(3000);
	findelementdate(pop.getProperty("date1"));
	findelementandclick(enddateclick);
	findelementdate(pop.getProperty("date2"));
	findelementandclicktext(pop.getProperty("searchtext"));
    Thread.sleep(3000);
    
	}
	@Test(priority=2)
	public void checkfuelpackage() throws InterruptedException {
		car.venueclick();
		Thread.sleep(5000);
		findelementandclick(clickonbike);
		Thread.sleep(5000);
		findelementdate(pop.getProperty("startdate11"));
		Thread.sleep(5000);
		findelementandclick(clickonbikes);
		Thread.sleep(4000);
		scrollpagedown();
		Thread.sleep(2000);
		 Assert.assertEquals(findelementandreturntext(pop.getProperty("getdays1")), "Duration\n" + 
		 		"7d");
		 Thread.sleep(4000);
		 driver.navigate().back();
		 Thread.sleep(4000);
		 findelementdate(pop.getProperty("startdate12"));
		 Thread.sleep(2000);
		 scrollpageup();
		 Thread.sleep(3000);
		 findelementandclick(clickonbikes);
		Thread.sleep(4000);
		scrollpagedown();
		Thread.sleep(2000);
		Assert.assertEquals(findelementandreturntext(pop.getProperty("getdays2")), "Duration\n" + 
				 		"15d");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		findelementdate(pop.getProperty("startdate13"));
		Thread.sleep(2000);
		scrollpageup();
		Thread.sleep(4000);
		findelementandclick(clickonbikes);
		Thread.sleep(4000);
		scrollpagedown();
		Thread.sleep(2000);
		Assert.assertEquals(findelementandreturntext(pop.getProperty("getdays3")), "Duration\n" + 
					 		"30d");
		Thread.sleep(3000);
		
			
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}