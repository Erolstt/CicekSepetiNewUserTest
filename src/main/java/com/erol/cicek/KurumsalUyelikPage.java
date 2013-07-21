package com.erol.cicek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KurumsalUyelikPage {
	private WebDriver driver;
	
	public KurumsalUyelikPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
