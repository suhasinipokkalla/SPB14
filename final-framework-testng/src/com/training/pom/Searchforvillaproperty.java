package com.training.pom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;




public class Searchforvillaproperty {
	private WebDriver driver; 
		
	public Searchforvillaproperty(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public void searchforvillaprop() throws InterruptedException {
		Thread.sleep(2000);	
		driver.findElement(By.linkText("VILLAS")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("keyword_search")).sendKeys("Nullam hendrerit Apartments");
		Thread.sleep(2000);		
		 driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/section/div/div/div/form/div[3]/div/button")).click();
		 Thread.sleep(1000);	
		driver.findElement(By.className("orig")).sendKeys("Nullam hendrerit Apartments");
		Thread.sleep(1000);
	
		driver.findElement(By.className("overlap")).click();
		Thread.sleep(4000);
//		String parent=driver.getWindowHandle();  //single element- window handle
  		Set<String> winid=driver.getWindowHandles(); //set of elements locator - windowhandles
  		System.out.println(winid);
//  		Thread.sleep(5000);
  		for(String id:winid)
  		{
  			Thread.sleep(500);
  			System.out.println(id);
  			driver.switchTo().window(id);
  			System.out.println(driver.getTitle());
  			
  			if(driver.getTitle().equals("Nullam hendrerit Apartments – Real Estate"))
  			{
  				driver.findElement(By.className("wpcf7-form-control")).clear();
   				driver.findElement(By.className("wpcf7-form-control")).sendKeys("selenium");
  				driver.findElement(By.className("wpcf7-email")).clear();
  				driver.findElement(By.className("wpcf7-email")).sendKeys("selenium@gmail.com");
  				driver.findElement(By.name("your-subject")).clear();
  				driver.findElement(By.name("your-subject")).sendKeys("apartment");
  				driver.findElement(By.name("your-message")).clear();
  				driver.findElement(By.name("your-message")).sendKeys("looking for apartment");
  				Thread.sleep(1000);
  				driver.findElement(By.cssSelector(".wpcf7-submit")).click();
  				Thread.sleep(2000);
  				driver.findElement(By.className("wpcf7-response-output")).click();
  				Thread.sleep(2000);
  				Reporter.log(driver.findElement(By.className("wpcf7-mail-sent-ng")).getText());
  			}	
		
		}

	}
	}
