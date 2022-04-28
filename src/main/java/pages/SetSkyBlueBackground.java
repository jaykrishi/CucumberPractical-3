package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SetSkyBlueBackground {
	
	WebDriver driver;
	
	public SetSkyBlueBackground(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Set SkyBlue Background')]")
	WebElement SKYBLUE_BUTTON;
	@FindBy(how = How.XPATH, using = "//body")
	WebElement BODY_ELEMENT;
	
	public void clickSetSkyBlueButton() {
		SKYBLUE_BUTTON.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
	
	public String getBlueBackgroundColor() {
		 String bluebckgclr = BODY_ELEMENT.getCssValue("background-color");
		 String hex = Color.fromString(bluebckgclr).asHex();
		 System.out.println(hex);
		 return hex;
			      
	}

	public boolean checkButtonIsEnabled() {
		// TODO Auto-generated method stub
		boolean buttonStatus = SKYBLUE_BUTTON.isEnabled();
		return  buttonStatus;
	}

}
