package com.erol.yeniuyelik.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;


public class YeniUyelikData {
	
	private String uyeAdi;
	private String uyeMail;
	private String uyeSifre;
	private String uyeConfirm;
	
	public String getUyeAdi() {
		return uyeAdi;
	}
	
	public void setUyeAdi(String uyeAdi) {
		this.uyeAdi = uyeAdi;
	}
	
	public String getUyeMail() {
		return uyeMail;
	}
	
	public void setUyeMail(String uyeMail) {
		this.uyeMail = uyeMail;
	}
	
	public String getUyeSifre() {
		return uyeSifre;
	}
	
	public void setUyeSifre(String uyeSifre) {
		this.uyeSifre = uyeSifre;
	}
	
	public String getUyeConfirm() {
		return uyeConfirm;
	}
	
	public void setUyeConfirm(String uyeConfirm) {
		this.uyeConfirm = uyeConfirm;
	}
	
	@DataProvider(name = "BireyselUyelikCSVData")
	public static Object[][] getCSVData() throws IOException{
		
		CSVReader csvReader = new CSVReader(new FileReader("../ciceksepeti/src/main/resources/bireyseluyelik.csv"));
		List<String[]>dataList = csvReader.readAll();
		Object[][] data = new Object[dataList.size()][1];
		List<YeniUyelikData> uyeList = new ArrayList<YeniUyelikData>();
		for (String[] strArray:dataList) {
			YeniUyelikData yeniUyelikData = new YeniUyelikData();
			yeniUyelikData.setUyeAdi(strArray[0].trim());
			yeniUyelikData.setUyeMail(strArray[1].trim());
			yeniUyelikData.setUyeSifre(strArray[2].trim());
			yeniUyelikData.setUyeConfirm(strArray[3].trim());
			
			uyeList.add(yeniUyelikData);
		}
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j]=uyeList.get(i);
			}
		}
		csvReader.close();
		return data;
	}


}
