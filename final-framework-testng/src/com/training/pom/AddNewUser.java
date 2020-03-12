package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddNewUser {
	private WebDriver driver; 
		
	public AddNewUser(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("Add New")).click();
	}
	public void addDetails() throws InterruptedException {
		Thread.sleep(1000);	
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("suha5");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("suhasini5@gmail.com");
				driver.findElement(By.id("first_name")).clear();
   				driver.findElement(By.id("first_name")).sendKeys("suha5");
  				driver.findElement(By.id("last_name")).clear();
  				driver.findElement(By.id("last_name")).sendKeys("suha5");
  				driver.findElement(By.id("url")).clear();
  				driver.findElement(By.id("url")).sendKeys("www.google.com");
  				Thread.sleep(1000);
  				driver.findElement(By.className("wp-generate-pw")).click();
  				Thread.sleep(10000);
  				driver.findElement(By.id("pass1-text")).clear();
  				Thread.sleep(5000);
  				driver.findElement(By.id("pass1-text")).sendKeys("suhasini@12345");
  				driver.findElement(By.className("pw-checkbox")).click();
  				driver.findElement(By.id("send_user_notification")).click();
  				Thread.sleep(1000);
  				Select drpdwn=new Select(driver.findElement(By.id("role")));
  		        drpdwn.selectByVisibleText("Agent");
  		       driver.findElement(By.id("createusersub")).click();
  		 	Thread.sleep(1000);
  		 
  			}
  		
}	
		
	
	
	
	
