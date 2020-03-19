package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddNewUser;
import com.training.pom.Enquireproperty;
import com.training.pom.EnterUserData;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RealEstateComplextestcasesRETC66 {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static HomePOM homePOM;
	private static Enquireproperty enquireproperty;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AddNewUser addNewUser;
	private static int readinput;
	private static WebDriverWait wait;
	private static FluentWait wt;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		wait=new WebDriverWait(driver,400);
		wt=new FluentWait(driver).pollingEvery(10,TimeUnit.SECONDS);
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		//move till Real estate home page
		homePOM.clickLoginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		loginPOM.moveToUserPage();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		   driver.quit();
	}
	
	@DataProvider (name="userData")
	public Object[][] getData() {
		return new Object[][] {
			{" "," "," "," "},
			{"alex hales"," "," "," "},
			{"mariya", "mariyas"," "," "}
		};
	}
	
	@Test(dataProvider="userData")
	public void validEnquirproperty(String username,String mail,String subject,String message)  throws FileNotFoundException, IOException, InterruptedException{
						//Send Different users enquirie's 
				driver.findElement(By.linkText("PLOTS")).click();
				 driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div/div[4]/div/a/div[2]/span")).click();
				enquireproperty=new Enquireproperty(driver);
				       	enquireproperty.sendEnquiryMessage(EnterUserData.name_ip,username);
				        enquireproperty.sendEnquiryMessage(EnterUserData.mail_ip,mail);
				        enquireproperty.sendEnquiryMessage(EnterUserData.subject_ip,subject);
				         enquireproperty.sendEnquiryMessage(EnterUserData.message_ip,message);
				        enquireproperty.clickbt2(EnterUserData.send_btn);
				        screenShot.captureScreenShot();		
	
	}
	
}

