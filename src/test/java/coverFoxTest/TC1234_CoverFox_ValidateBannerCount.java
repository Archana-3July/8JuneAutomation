package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBasic.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxUtilities.Utility;

public class TC1234_CoverFox_ValidateBannerCount extends Base
{
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxMemberDetailsPage  memberDetailsPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxResultPage resultPage;
	String excelPath=System.getProperty("user.dir")+"\\DataSheets\\Frame.xlsx";
	
	String sheetName="Sheet1";
	
	public static Logger logger;
	//open browser/open an application
	@BeforeClass
	public void openApplication() throws IOException
	{
		launchBrowser();
		logger = Logger.getLogger("8th_June-CoverFox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Browser");
	}
	//gender,next click, age selection,pincode,mobile,next click
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
	     homePage = new CoverFoxHomePage(driver);
	     healthPlanPage = new CoverFoxHealthPlanPage(driver);
	     memberDetailsPage = new CoverFoxMemberDetailsPage(driver);
	     addressDetailsPage = new CoverFoxAddressDetailsPage(driver);
	     resultPage = new CoverFoxResultPage(driver);
	     
	     homePage.clickOnGenderButton();
	     logger.info("Clicking on Gender Button");
	     healthPlanPage.ClickOnNextButton();
	     logger.info("Clicking on Next Button");
	     memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelPath, sheetName, 0, 0));
	     logger.info("Handling age Drop Down");
	     memberDetailsPage.clickOnNextButton();
	     logger.info("Clicking on Next Button");
	     Thread.sleep(2000);
	     addressDetailsPage.enterPinCode(Utility.readDataFromExcel(excelPath, sheetName, 0, 1));
	     logger.warn("Pin Code is required");
	     addressDetailsPage.enterMobNo(Utility.readDataFromExcel(excelPath, sheetName, 0, 2));
	     logger.info("Entering Mobile Number");
	     addressDetailsPage.clickOnContinueButton();
	     logger.error("Wrong details,please check the details");
	     Thread.sleep(3000);
	}
	
  @Test
  public void validatePolicyCount() 
  {
	  int textCount = resultPage.getCountFromText();
	  int textBanner = resultPage.getCountFromBanner();
	  logger.info("Validating results");
	  Assert.assertEquals(textCount,textBanner,"text count not matching with banner text");
	  //Assert.fail();
  }
  //logout from application
  //close browser/close application
  @AfterClass
  public void closeApplication()
  {
	  logger.info("Closing Browser");
	  closeBrowser();
  }
}
