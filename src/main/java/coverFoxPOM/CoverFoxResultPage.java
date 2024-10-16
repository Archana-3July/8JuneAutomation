package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage {
	
	@FindBy(xpath="//div[contains(text(),'matching Health')]") private WebElement resultText;
	@FindBy (className="plan-card-container") private List<WebElement>planList;
	@FindBy (xpath="//div[text()='Preferred brands']") private WebElement preferredBrands;
	@FindBy (xpath="//span[text()='Star Health Insurance']") private WebElement starHealthInsurance;
	@FindBy (xpath="//button[text()=' Apply ']") private WebElement applyBrand;
	@FindBy (xpath="//img[@alt='Star Health Insurance']") private List<WebElement> bannerStar;
	
	public CoverFoxResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int getCountFromText() {
		Reporter.log("getting policy count from text displayed..", true);
		String resultInString = resultText.getText().substring(0,2);
		int countFromText = Integer.parseInt(resultInString);
		return countFromText;
	}
	
	public int getCountFromBanner() {
		Reporter.log("getting policy count from banner displayed..", true);
		int countFromBanner=planList.size();
		return countFromBanner;
	}
	
	public void ClickOnPreferredBrands() {
		Reporter.log("Click on Preferred Brands",true);
		preferredBrands.click();
	 }
	
	public void SelectStarHelathInsuranceBrand() {
		Reporter.log("Select Star Health Insurance",true);
		starHealthInsurance.click();
	}
	
	public void ApplySelectedBrands() {
		Reporter.log("Apply of 1 selected Brand",true);
		applyBrand.click();
	}
	
	public int CheckedStarBanner() {
		Reporter.log("Check Star Helath Insurance ",true);
		int CountStar = bannerStar.size();
		Reporter.log("Star Health Insurance Count is :"+CountStar,true);
		return CountStar;
		
	}
	
	
//	public void validateResult()
//	{
//		String resultString = resultText.getText().substring(0, 2);
//		int resultNumber = Integer.parseInt(resultString);
//		int planListNumber = planList.size();
//		System.out.println("Result Number is "+resultNumber);
//		System.out.println("Plan List Number is "+planListNumber);
//		
//		
//		
//		if(resultNumber==planListNumber) {
//			System.out.println("Result is matching");
//		}
//		else {
//			System.out.println("Result is not matching");
//		}
//	}

}
