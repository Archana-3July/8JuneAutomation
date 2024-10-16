package coverFoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBasic.Base;
import coverFoxPOM.CoverFoxHomePage;

public class TC1237_CoverFox_Validate_icon_isDisplayed extends Base {
	CoverFoxHomePage homePage;
	
	@BeforeClass
	public void openApplication() throws IOException
	{
		launchBrowser();
	}
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
	     homePage = new CoverFoxHomePage(driver);
	}
  @Test
  public void validate_icon_is_displyed()
  {
	  Reporter.log("Checked icon is displayed or not", true);
	 boolean iconDisplay = homePage.icon_is_Displayed();
	  Assert.assertTrue(iconDisplay, "In Home Page,icon is not displayed,TC is failed");
	  
  }
  
  @AfterClass
  public void closeApplication()
  {
	  closeBrowser();
  }
}
