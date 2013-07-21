package com.erol.cicek;

import org.openqa.selenium.WebDriver;

public class Factory {
	private WebDriver driver;
	
	public Factory(WebDriver driver){
		this.driver = driver;
	}
	
	public YeniUyePage yeniUyePage(){
		return new YeniUyePage(driver);
	}
	
	public UyelikActivationPage uyelikActivationPage(){
		return new UyelikActivationPage(driver);
	}
	
	public BireyselUyelikPage bireyselUyelikPage(){
		return new BireyselUyelikPage(driver);
	}
	
	public KurumsalUyelikPage kurumsalUyelikPage(){
		return new KurumsalUyelikPage(driver);
	}
}
