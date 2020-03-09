package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class UpdateUserProfileDetails {
	private WebDriver driver; 
	private static UpdateProfilePage updateProfilePage;	
	
	public UpdateUserProfileDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public void clickOnUserProfile() throws InterruptedException {
		updateProfilePage =new UpdateProfilePage(driver);
		Thread.sleep(2000);		
		Dimension d = driver.findElement(By.className("user-name")).getSize();
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("user-name")),d.width-17, 7).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("My Profile")).click();
		Thread.sleep(2000);
		updateProfilePage.sendAgentName("manzoor");
		updateProfilePage.sendPhonenum("9876543210");
		Thread.sleep(1000);
		updateProfilePage.SavechangesBtn();
		
	}

}
