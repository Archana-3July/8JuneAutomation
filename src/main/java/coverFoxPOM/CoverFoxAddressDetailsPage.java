package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
      @FindBy(xpath="//input[@class='mp-input-text']")  private WebElement pinCodeField;
      @FindBy(id="want-expert") private WebElement mobNoField;
      @FindBy(className="next-btn") private WebElement continueButton;
      
      public CoverFoxAddressDetailsPage(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
      }
      
      public void enterPinCode(String pinCode)
      {
    	  Reporter.log("Entering Pincode..", true);
    	pinCodeField.sendKeys(pinCode);  
      }
      
      public void enterMobNo(String mobNum)
      {
    	  Reporter.log("Entering Mobile no", true);
    	  mobNoField.sendKeys(mobNum);
      }
      
      public void clickOnContinueButton()
      {
    	  Reporter.log("Clicking on Continue button", true);
    	  continueButton.click();
      }
      
      
}
