package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewUser;
import com.training.pom.Changepassword;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.Searchforproperty;
import com.training.pom.UpdateUserProfileDetails;
import com.training.pom.Userlogout;
//import com.training.pom.Userlogout;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstateMediumtestcasesRETC034_35_36 {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static HomePOM homePOM;
	private static Searchforproperty searchforproperty;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AddNewUser addNewUser;
	private static int readinput;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		System.out.println("ENTER 1 : to Search Apartment and fill enquire form");
		System.out.println("      2 : to Add New User");
		System.out.println("      3 : to Search Villa and fill enquire form");
		Scanner sc=new Scanner(System.in);
		readinput = sc.nextInt();
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
	public void validEnquirpropertyORadduser() throws InterruptedException {
		Thread.sleep(2000);
		//move till Real estate home page
		homePOM.clickLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		
		
		switch(readinput){	
		  case 1:
				Thread.sleep(2000);
				loginPOM.moveToUserPage();
				//move to customer page and search for property then select apartment finally send message to them 
				Thread.sleep(2000);	
				driver.findElement(By.linkText("COMMERCIAL")).click();
				searchforproperty=new Searchforproperty(driver);
				searchforproperty.searchforprop();
				screenShot.captureScreenShot("First");
			   break;
		  case 2:
				Thread.sleep(2000);
				//move to add new user  
				addNewUser=new AddNewUser(driver);
				addNewUser.addDetails();
				screenShot.captureScreenShot("First");
		    break;
		  case 3:     
			  Thread.sleep(2000);
			  loginPOM.moveToUserPage();
			//move to customer page and search for property then select apartment finally send message to them 
			   Thread.sleep(2000);	
			   driver.findElement(By.linkText("VILLAS")).click();
			   searchforproperty=new Searchforproperty(driver);
			   searchforproperty.searchforprop();
			   screenShot.captureScreenShot("First");
			  break;
			    
		    default:
		    	System.out.println("Please ENTER Valid Action Key");
		}
	
	}
	

}
