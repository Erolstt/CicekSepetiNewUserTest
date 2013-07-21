package com.erol.cicek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YeniUyePage {
	
	private WebDriver driver;
	
	public YeniUyePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public YeniUyePage init(){
		driver.get("https://www.ciceksepeti.com/bireysel-uyelik");
		return this;
	}
	
	@CacheLookup
	@FindBy(linkText = "Bireysel Üyelik")
	WebElement bireyselUyelik;
	
	public BireyselUyelikPage bireyselUyelikClick(){
		bireyselUyelik.click();
		return new BireyselUyelikPage(driver);
	}

}
