package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
      //variable declaration
	@ FindBy(xpath="//div[text()='Male']") private WebElement gender;
	@FindBy(xpath="//img[@alt='Coverfox.com']") private WebElement icon;
	  //constructor
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	  //method
	public void clickOnGenderButton()
	{
		Reporter.log("Clicking on Gender Button", true);
		gender.click();
	}
	
	public boolean icon_is_Displayed()
	{
		Reporter.log("icon is displayed",true);
		boolean display_icon = icon.isDisplayed();
		return display_icon;
//		if(display_icon==true) {
//			Reporter.log("In Home Page, icon is displayed", true);
//		}else {
//			Reporter.log("In Home Page,icon is not displayed", true);
//		}
	}
}
