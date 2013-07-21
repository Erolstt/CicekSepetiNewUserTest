package com.erol.cicek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UyelikActivationPage {
private WebDriver driver;
	
	public UyelikActivationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@CacheLookup
	@FindBy(css = "a.btnTurqoise.backMain")
	private WebElement backHomePage;
	
	public UyelikActivationPage clickHomePageBack(){
		backHomePage.click();
		return this;
	}
	
	public UyelikActivationPage waitForUyelikActivationPage(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(backHomePage));
		return this;
	}

}
