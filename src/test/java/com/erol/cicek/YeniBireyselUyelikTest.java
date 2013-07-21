package com.erol.cicek;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.erol.generic.BaseCase;
import com.erol.yeniuyelik.data.YeniUyelikData;

public class YeniBireyselUyelikTest extends BaseCase{

	@Test(dataProvider = "BireyselUyelikCSVData", dataProviderClass = YeniUyelikData.class)
	public void BireyselUyelikTest(YeniUyelikData yeniUyelikData){
		driver.get(cicekURL);
		Factory yenibireyseluyelik = new Factory(driver);
				yenibireyseluyelik
				.bireyselUyelikPage()
				.yeniBireyselUyeKayit(yeniUyelikData)
				.waitForUyelikActivationPage();
				
				assert driver
				.findElement(By.tagName("body"))
				.getText()
				.contains("Teþekkürler. Hesabýnýz baþarýyla oluþturulmuþtur.");

	}
	
}
