package steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SetSkyBlueBackground;
import pages.SetSkyWhiteBackground;
import pages.TestBase;


public class BackGroundColorStepDefinition extends TestBase {
	
	
	SetSkyBlueBackground skyBlueColorobj;
	SetSkyWhiteBackground whiteColorobj;
	Boolean status;
	@Before
	public void setUp() {
		initDriver();
		skyBlueColorobj = PageFactory.initElements(driver, SetSkyBlueBackground.class);
		whiteColorobj = PageFactory.initElements(driver, SetSkyWhiteBackground.class);
		
	}
	
	@Given("^User is on Techfios Page$")
	public void user_is_on_Techfios_Page()  {
		driver.get("https://techfios.com/test/101/index.php");
	}

	@Given("^Set SkyBlue BackGround Button Exists$")
	public void set_SkyBlue_BackGround_Button_Exists()  {
	    status = skyBlueColorobj.checkButtonIsEnabled();
	}

	@Given("^Set SkyWhite BackGround Button Exists$")
	public void set_SkyWhite_BackGround_Button_Exists()  {
	    
		status = whiteColorobj.checkWhiteButtonIsEnabled();
	}

	@When("^User clicks on the Set SkyBlue Button$")
	public void user_clicks_on_the_Set_SkyBlue_Button()  {
		if(status==true) {
	   skyBlueColorobj.clickSetSkyBlueButton();
		}
	}

	@Then("^Background Color changes to Sky Blue$")
	public void background_Color_changes_to_Sky_Blue()  {
		
		String blubckgColor = skyBlueColorobj.getBlueBackgroundColor();
	//	System.out.println(bckgColor);
		
		Assert.assertEquals("Not SkyBlue", "#87ceeb", blubckgColor);
		
	}

	@When("^User clicks on the Set SkyWhite Button$")
	public void user_clicks_on_the_Set_SkyWhite_Button(){
	    if(status == true) {
		whiteColorobj.clickSetWhiteButton();
	    }
	}

	@Then("^Background Color changes to White$")
	public void background_Color_changes_to_White() {

		String whbckgColor = whiteColorobj.getWhiteBackgroundColor();
	//	System.out.println(bckgColor);
		
		Assert.assertEquals("Not White", "#ffffff", whbckgColor);
	    
	}

	@After
	public void tearDown() {
		 driver.close();
		 driver.quit();
	}

}
