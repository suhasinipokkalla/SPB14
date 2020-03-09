package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Enterpassword {
	private WebDriver driver; 
	
	public Enterpassword(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="current_pass")
	private WebElement Curpass; 
	
	@FindBy(name="pass1")
	private WebElement Newpass;
	
	@FindBy(name="pass2")
	private WebElement Confpass; 

		
	public void currentpass(String curpass) {
		this.Curpass.clear();
		this.Curpass.sendKeys(curpass);
	}
	
	public void newpass(String newpass) {
		this.Newpass.clear(); 
		this.Newpass.sendKeys(newpass); 
	}
	
	public void confirmnewpass(String cnfpass) {
		this.Confpass.clear();
		this.Confpass.sendKeys(cnfpass); 
	}	
		

}
