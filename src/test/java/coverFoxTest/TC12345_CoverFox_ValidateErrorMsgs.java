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

public class TC12345_CoverFox_ValidateErrorMsgs extends Base
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
	@BeforeMethod
	public void openApplication() throws IOException, InterruptedException
	{
		launchBrowser();
		logger = Logger.getLogger("8th_June-CoverFox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Browser");
		homePage = new CoverFoxHomePage(driver);
	     healthPlanPage = new CoverFoxHealthPlanPage(driver);
	     memberDetailsPage = new CoverFoxMemberDetailsPage(driver);
	     addressDetailsPage = new CoverFoxAddressDetailsPage(driver);
	     homePage.clickOnGenderButton();
	     logger.info("Clicking on Gender Button");
	     Thread.sleep(2000);
	     healthPlanPage.ClickOnNextButton();
	     logger.info("Clicking on Next Button");
	     Thread.sleep(1000);
	     memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelPath, sheetName, 0, 0));
	     logger.info("Handling age Drop Down");
	     memberDetailsPage.clickOnNextButton();
	     logger.info("Clicking on Next Button");
	     Thread.sleep(2000);
	}
	//gender,next click, age selection,pincode,mobile,next click
	@Test
	public void validatePinCodeErrorMsg() throws InterruptedException, EncryptedDocumentException, IOException
	{
	     logger.warn("Enter valid Mobile Number");
	     addressDetailsPage.enterMobNo(Utility.readDataFromExcel(excelPath, sheetName, 0, 2));
	     
	}
}