package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {
	private WebDriver driver; 
	
	public UpdateProfilePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="agent_title")
	private WebElement agentName; 
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(xpath="//*[text()='Save Changes']")
	private WebElement SavechgBtn; 

		
	public void sendAgentName(String agentName) {
		this.agentName.clear();
		this.agentName.sendKeys(agentName);
	}
	
	public void sendPhonenum(String phone) {
		this.phone.clear(); 
		this.phone.sendKeys(phone); 
	}
	
	public void SavechangesBtn() {
		this.SavechgBtn.click(); 
	}	
		

}
