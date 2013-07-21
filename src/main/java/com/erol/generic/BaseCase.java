package com.erol.generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseCase {
	
   public WebDriver driver;
	protected String cicekURL;
	
	@BeforeSuite
	@Parameters("cicekURL")
	public void setEnv(
			@Optional("https://www.ciceksepeti.com/bireysel-uyelik") String cicekURL) {
		this.cicekURL = cicekURL;
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver= new FirefoxDriver();
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if (!result.isSuccess()) {

            try {

                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("dd-MM-yyyy_HH-ss").format(new GregorianCalendar().getTime())
    					+ ".png";
                FileUtils.moveFile(scrFile, new File(failureImageFileName) );
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    
		driver.close();
		driver.quit();
	}

}
