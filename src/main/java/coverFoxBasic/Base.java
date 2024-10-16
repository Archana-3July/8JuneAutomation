package coverFoxBasic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverFoxUtilities.Utility;

public class Base {
  //driver
	//url
	//launch browser
	//close browser
	
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromPropertyFile("url"));
		Reporter.log("Launching browser..",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("Waiting..", true);
	}
	
	public void closeBrowser()
	{
		Reporter.log("Close browser", true);
		driver.quit();
	}
}
