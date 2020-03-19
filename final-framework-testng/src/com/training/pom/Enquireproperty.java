package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Enquireproperty {
	private static WebDriver driver; 
	
	public Enquireproperty(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public void sendEnquiryMessage(By loc,String data) throws InterruptedException {
	
		 driver.findElement(loc).clear();
		 driver.findElement(loc).sendKeys(data);
		  	}
	
	public void clickbt(By loc){
		driver.findElement(loc).click();
		Reporter.log(driver.findElement(By.className("wpcf7-mail-sent-ng")).getText());
	  	}	
	
	public void clickbt2(By loc) throws InterruptedException{
		driver.findElement(loc).click();
		Thread.sleep(5000);
	}	
	
	
		}


	
