package Libraryfiles;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	public class Libraryfilesbaseclass {
		
		public static WebDriver driver;
		public static Properties pop;
		
		public Libraryfilesbaseclass() {	
			try {
				pop=new Properties();
				FileInputStream fi=new FileInputStream("/Users/narendra/eclipse-workspace/Automation/src/main/java/Config/config.properties");
				try {
					pop.load(fi);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void initialization() {

		String browsername=pop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "/Users/narendra/Downloads/chromedriver 2");
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.get(pop.getProperty("url"));
	}
	
	public void clickelement(WebElement element) {
		
		element.click();
	}
	
	public void scrollpagedown() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)", "");
	}
	
public void scrollpageup() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-250)", "");
	}
public void clickelementAndwaitxpath(String element) {
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(element)))).click();
}

public void clickelementAndwaitcss(String element) {
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(element)))).click();
}
public void clickelementAndwaitforstring(String element) {
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(element)))).click();
}
public void getxpath(String s) {
	
	WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(text()='"+s+"'])[1]")))).click();
}

public void findelementandclicks(String element) {
	
	driver.findElement(By.xpath("//div[contains(text()='"+element+"')][1]")).click();
}	
public void findelementandclear(String element) {
	
	driver.findElement(By.cssSelector(element)).clear();
}

public void findelementdate(String element) {
	
	driver.findElement(By.xpath("//div[text()='"+element+"']")).click();
}

public String findelementandreturntextfornofuel(String element) {

	String str=driver.findElement(By.xpath("//span[text()='" +element+ "']")).getText();
	return str;
}
public void clckstartfdate(String element) {
	driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD HH:MM'])[1]]")).click();
}
//public void findelementenddate(String element) {

	//driver.findElement(By.xpath("//input[@placeholder='"+element+"'])[2]")).click();
//}

public void clickenddate(String element) {
	driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD HH:MM'])[2]")).click();
}

public void findelementandclicktext(String element) {

	driver.findElement(By.xpath("//*[(text()='"+element+"')]")).click();

}
public String findelementandreturntext(String element) {

	String str=driver.findElement(By.xpath("//div[text()='"+element+"']")).getText();
	return str;

}
public void findelementandclick(String element) {
	
	driver.findElement(By.xpath(element)).click();
}
public void findelementandclickkms(String element) {
	
	driver.findElement(By.xpath("//*[@class='fuel-option-content' and text()='"+element+"']")).click();
	
}
public String findelementandkmreturntext(String element) {
	
	String str=driver.findElement(By.xpath("//*[@class='filtered-option-label' and text()=' "+element+"']")).getText();
	return str;
}


	
public void findelementandclickcss(String element) {
	
	driver.findElement(By.cssSelector(element)).click();
}

public void findelementandpointcss(String element) {
	
	driver.findElement(By.cssSelector(element));
}
public void Buttonenablecheck(String element) {
	
	//driver.findElement(By.xpath(element)).isEnabled();
	System.out.println("fdhbfsgf");
	System.out.println(	driver.findElement(By.xpath(element)).isEnabled());
	System.out.println("fdhbfsgf");
}
public void findelement(String element) {
	
	driver.findElement(By.xpath(element));
}
public String findelementreturn(String element) {
	
	String str=driver.findElement(By.xpath(element)).getText();
	return str;
}

public void findelementAndsendkeysforusername(String element) {
	
	driver.findElement(By.xpath(element)).sendKeys(pop.getProperty("username1"));
}

public void findelementAndsendkeysforpassword(String element) {
	
	driver.findElement(By.xpath(element)).sendKeys(pop.getProperty("venue"));
}
public void findelementAndsendkeysforpasswordwrong(String element) {
	
	driver.findElement(By.xpath(element)).sendKeys(pop.getProperty("password11"));
}

public void switchfromparenttochild() {
	
	String parentWindowHandler = driver.getWindowHandle();
	String subWindowHandler = null;
	Set<String> handles = driver.getWindowHandles();
	java.util.Iterator<String> iterator = handles.iterator();
	while (iterator.hasNext()){
	    subWindowHandler = iterator.next();
	}
	if(!parentWindowHandler.equals(subWindowHandler)) {
	driver.switchTo().window(subWindowHandler);
	}
	//if(!subWindowHandler.equals(parentWindowHandler))
	//driver.switchTo().window(parentWindowHandler);	
}
public static String  loginbtn="//img[@alt='drivezy-user-thumbnail']";
	
	public static String username="//div[@class='form-input form-width']//input[1]";
	
	public static String password="(//input[@class='input-box'])[2]";
	
	public static String signinpopup="//div[text()='Login/SignUp']";
	
	public static String proceedbutton="//*[contains(text(),'PROCEED')]";
	
	public static String proceedbutton1="//span[text()='PROCEED']";
	
public static String proceedbtonloginpage="body > div.atlaskit-portal-container > div > div > div:nth-child(3) > div.css-1m0lomi > div > div > div > div.modal-body > div > div > div.username-container > div > div.button-section > button > span > span > span > span > span";
	
	public static String successfulltaost="//div[@class='toast-content success-toast']";
	public static String unsuccessfulltaost="//div[@class='toast-content error-toast']";
	
	public static String loginbtnfb="//img[@alt='fb-login']";
	public static String usernamefb="//*[@id='email']";
	public static String passwordfb="//*[@id='pass']";
	
	public static String loginbtnfbonpop="//*[@id='u_0_0']";
	
	public static String withfuelbutton="//div[text()='With Fuel']";
	
	public static String venuevalue="(//div[text()='Mahadevapura'])[1]";
	public static String venuevaluecss="div#react-select-2-option-0-0>div>div:nth-of-type(2)>div";
	
	
	public static String venueclick="//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[1]";
	//public static String venueclick="\"//*[@id=\\\"root\\\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[1]\")
	
	public static String dateclick="//*[@class='react-datepicker-ignore-onclickoutside']";
	
	public static String selectcalendermark="//i[@class='fa fa-angle-right']";
	public static String togglebuttonclick="//div[@class='toggle-block']//img[1]";
	
	public static String Enterkm="div#root>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>input";
	
	public static String flexibutton="//button[@class='icon-button']//i[1]";
	public static String clickbuttonforflexi="//button[@class='icon-button']//i[1]";
	
	public static String flexieditbutton="//i[@class='fa fa-pencil']";
	
	public static String startdateclick="(//input[@placeholder='YYYY-MM-DD HH:MM'])[1]";
	
	public static String enddateclick="(//input[@placeholder='YYYY-MM-DD HH:MM'])[2]";
	
	public static String clickonbike="//img[@alt='bike']";
	
	public static String Nofueltext="//span[text()=' No-fuel ']";
	
	//public static String startdate="(//input[@placeholder='YYYY-MM-DD HH:MM'])[1]";
	//public static String enddate="(//input[@placeholder='YYYY-MM-DD HH:MM'])[2]";
	
	public static String startdate="(//span[text()='Select your pickup date & time']/following::input)[1]";
	public static String enddate="(//span[text()='Select your pickup date & time']/following::input)[2]";
	public static String clickonbikes="(//img[contains(@class,'img load')])[1]";
	
}
