package com.erol.cicek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erol.yeniuyelik.data.YeniUyelikData;

public class BireyselUyelikPage {

	private WebDriver driver;
	
	public BireyselUyelikPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@CacheLookup
	@FindBy(id = "Customer_Name")
	private WebElement uyeAdi;
	
	@CacheLookup
	@FindBy(id = "Customer_Email")
	private WebElement uyeMail;
	
	@CacheLookup
	@FindBy(id = "Customer_Password")
	private WebElement uyeSifre;
	
	@CacheLookup
	@FindBy(id = "ConfirmPassword")
	private WebElement uyeConfirm;
	
	@CacheLookup
	@FindBy(css = "#regNewMember > input.btnGreen")
	private WebElement kayitOl;
	
	public BireyselUyelikPage typeCustomerName(String UyeAdi){
		uyeAdi.sendKeys(UyeAdi);
		return this;
	}

	public BireyselUyelikPage typeCustomerEmail(String UyeEmail) {
		uyeMail.sendKeys(UyeEmail);
		return this;		
	}
	
	public BireyselUyelikPage typeCustomerPassword(String UyeSifre){
		uyeSifre.sendKeys(UyeSifre);
		return this;
	}
	
	public BireyselUyelikPage typeCustomerConfirmPassword(String UyeConfirmSifre){
		uyeConfirm.sendKeys(UyeConfirmSifre);
		return this;
	}
	
	public UyelikActivationPage clickKayitOl(){
		kayitOl.click();
		return new UyelikActivationPage(driver);
	}
	
	public UyelikActivationPage yeniBireyselUyeKayit(YeniUyelikData yeniUyelikData){
		return typeCustomerName(yeniUyelikData.getUyeAdi())
				.typeCustomerEmail(yeniUyelikData.getUyeMail())
				.typeCustomerPassword(yeniUyelikData.getUyeSifre())
				.typeCustomerConfirmPassword(yeniUyelikData.getUyeConfirm())
				.clickKayitOl();
		
	}
	
}
