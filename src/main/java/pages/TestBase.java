package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;

	public static void initDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void takeScreenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		/*
		 * Date date = new Date() ; SimpleDateFormat dateFormat = new
		 * SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		 * 
		 * File scrFile = ts.getScreenshotAs(OutputType.FILE); //The below method will
		 * save the screen shot in d drive with name "screenshot.png" try {
		 * FileUtils.copyFile(scrFile, new
		 * File(System.getProperty("user.dir")+"/screenshots/"+
		 * dateFormat.format(date)+".png")); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		try {
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date date = new Date();
			String label = formatter.format(date);

			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/screenshots/" + label + ".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getPageTitle() {
		  return driver.getTitle();
		 }
	
	public int generateRandom(int bounderyNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bounderyNum);
		return generatedNum;
	}

}
