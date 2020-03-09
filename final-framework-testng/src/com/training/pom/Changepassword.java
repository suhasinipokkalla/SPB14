package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Changepassword {
	private WebDriver driver; 
	private static Enterpassword enterpassword;	
	
	public Changepassword(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public void clickOnUserProfile() throws InterruptedException {
		enterpassword =new Enterpassword(driver);
		Thread.sleep(2000);		
		Dimension d = driver.findElement(By.className("user-name")).getSize();
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("user-name")),d.width-17, 7).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("My Profile")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Change Password")).click();
		Thread.sleep(3000);
		enterpassword.currentpass("manzoor");
		enterpassword.newpass("mehadi");
		enterpassword.confirmnewpass("mehadi");
		Thread.sleep(2000);
		driver.findElement(By.id("wp-submit")).click();
		
		
	}

}
