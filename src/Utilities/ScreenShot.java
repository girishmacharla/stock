package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static void takescreen(WebDriver driver,String sname)throws Throwable {
		String path="C:\\mrng930batch\\ERP_Stock\\Screens"+sname+".png";
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File(path));
		
	}
	
	
	
	
	
}
