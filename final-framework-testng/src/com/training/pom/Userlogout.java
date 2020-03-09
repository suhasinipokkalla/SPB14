package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Userlogout {
	private WebDriver driver; 
		
	public Userlogout(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	public void logout() throws InterruptedException {
		Thread.sleep(2000);		
		Dimension d = driver.findElement(By.className("user-name")).getSize();
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("user-name")),d.width-17, 7).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(2000);
		
		
	}

}
