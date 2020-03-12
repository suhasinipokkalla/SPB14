package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Changepassword;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.UpdateUserProfileDetails;
import com.training.pom.Userlogout;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstatesimpletestcases4_5_6 {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static HomePOM homePOM;
	private static UpdateUserProfileDetails updateUserProfileDetails;
	private static Changepassword changepassword;
	private static Userlogout userlogout;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static int readinput;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		System.out.println("ENTER 1 : to Update Profile details");
		System.out.println("      2 : to Cange password");
		System.out.println("      3 : to Logout from Url");
		Scanner sc=new Scanner(System.in);
		readinput = sc.nextInt();
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	    driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		Thread.sleep(2000);
		homePOM.clickLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		loginPOM.moveToUserPage();
		
		switch(readinput){	
		  case 1:
				Thread.sleep(2000);
			  updateUserProfileDetails =new UpdateUserProfileDetails(driver);
				 updateUserProfileDetails.clickOnUserProfile();
				 screenShot.captureScreenShot("First");
			   break;
		  case 2:
				Thread.sleep(2000);
				changepassword =new Changepassword(driver);
				changepassword.clickOnUserProfile();
				screenShot.captureScreenShot("First");
		    break;
		  case 3:     
			  Thread.sleep(2000);
			  userlogout=new Userlogout(driver);
			  userlogout.logout();
			  screenShot.captureScreenShot("First");
			  break;
			    
		    default:
		    	System.out.println("Please ENTER Valid Action Key");
		}
		
			
	}
	

}
