package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

//import pageObjects.LoginPage;


public class Stepdef extends BaseClass {
	@Before
	public void setup() throws IOException {
		// Logging
		logger = Logger.getLogger("Github Repos");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);

		// Load properties file
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser"); // getting the browser name from config.properties file

		// Launching browser
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}

		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}

	}

	// Login steps....................
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		logger.info("************* Launching Browser *****************");
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("************* Opening URL  *****************");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("Move to Repositories section")
	public void move_to_Repositories_section() {
		logger.info("************* click on login *****************");
		lp.clickRepo();
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("************* cloding browser *****************");
		driver.quit();
	}

	@When("get all Repo titles and desc from UI")
	public void get_all_Repo_titlesAndDesc_fromUI() {
		
		lp.getAllRepoTitleAndDescFromUI();
	}
	
	

	@When("get all Repo titles and desc from API using {string}")
	public void get_all_Repo_titlesAndDesc_fromAPI(String url) {
		
		lp.getAllRepoTitleAndDescFromAPI(url);
	}

	@Then("Verify Actual data of UI with Expected data from API")
	public void verify_Actual_data_of_UI_with_Expected_data_from_API() {
	
		lp.verifyTitlesAndDescFromUIandAPI();
	}

}
