package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {
     //variable declaration
	@FindBy(className="next-btn") private WebElement nextButton;
	//constructor
	public CoverFoxHealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//method
	public void ClickOnNextButton()
	{
		Reporter.log("Clicking on Next Button", true );
		nextButton.click();
	}
}
