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
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxUtilities.Utility;

public class TC1236_CoverFox_Select1Brand_ValidateMatching extends Base {
  
	  CoverFoxHomePage homePage;
		CoverFoxHealthPlanPage healthPlanPage;
		CoverFoxMemberDetailsPage  memberDetailsPage;
		CoverFoxAddressDetailsPage addressDetailsPage;
		CoverFoxResultPage resultPage;
		String excelPath=System.getProperty("user.dir")+"\\DataSheets\\Frame.xlsx";
		
		String sheetName="Sheet1";
		//open browser/open an application
		@BeforeClass
		public void openApplication() throws IOException
		{
			launchBrowser();
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
		     healthPlanPage.ClickOnNextButton();
		     memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelPath, sheetName, 0, 0));
		     memberDetailsPage.clickOnNextButton();
		     Thread.sleep(2000);
		     addressDetailsPage.enterPinCode(Utility.readDataFromExcel(excelPath, sheetName, 0, 1));
		     addressDetailsPage.enterMobNo(Utility.readDataFromExcel(excelPath, sheetName, 0, 2));
		     addressDetailsPage.clickOnContinueButton();
		     Thread.sleep(2000);
		     resultPage.ClickOnPreferredBrands();
		     Thread.sleep(2000);
		     resultPage.SelectStarHelathInsuranceBrand();
		     Thread.sleep(2000);
		     resultPage.ApplySelectedBrands();
		     Thread.sleep(2000);
		     resultPage.CheckedStarBanner();
		     Thread.sleep(2000);
		}
		 @Test
		 public void validateSelectBrandMatching()
		 {
			 int starBannerCount = resultPage.CheckedStarBanner();
			 int bannerCount = resultPage.getCountFromBanner();
			 Assert.assertEquals(starBannerCount, bannerCount, "The Star Health Insurance are not mathched,TC Failed");
		 }
		 
		 @AfterClass
		  public void closeApplication()
		  {
			  closeBrowser();
		  }
	  
  }

