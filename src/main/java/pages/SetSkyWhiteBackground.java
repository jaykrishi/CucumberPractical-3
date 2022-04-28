package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SetSkyWhiteBackground {
	
	
	
		WebDriver driver;
		
		public SetSkyWhiteBackground(WebDriver driver) {
			this.driver = driver;
		}

		// Element Library
		@FindBy(how = How.XPATH, using = "//button[contains(text(),'Set White Background')]")
		WebElement WHITE_BUTTON;
		@FindBy(how = How.XPATH, using = "//body")
		WebElement BODY_ELEMENT;

		public void clickSetWhiteButton() {
			// TODO Auto-generated method stub
			WHITE_BUTTON.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		public String getWhiteBackgroundColor() {
			String whitebckgclr = BODY_ELEMENT.getCssValue("background-color");
			 String hex = Color.fromString(whitebckgclr).asHex();
			 System.out.println(hex);
			 return hex;
				      
		}

		public Boolean checkWhiteButtonIsEnabled() {
			// TODO Auto-generated method stub
			boolean status = WHITE_BUTTON.isEnabled();
			return status;
		}
	}


