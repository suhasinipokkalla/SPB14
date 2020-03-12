package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewUser;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstatetestcasesRETC035 {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static HomePOM homePOM;
	private static AddNewUser addNewUser;
	
	private static Properties properties;
	private static ScreenShot screenShot;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	    driver.quit();
	}
	
	@Test
	public void validAddUserTest() throws InterruptedException {
		Thread.sleep(2000);
		//move till Real estate home page
		homePOM.clickLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//move to add new user  
		addNewUser=new AddNewUser(driver);
		addNewUser.addDetails();
		screenShot.captureScreenShot();
	}
	

}
