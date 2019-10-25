package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonFunLibrary.ERP_Functions;
import Utilities.ExcelFileUtil;



public class DataDrivenFramework {
	WebDriver driver;
	ERP_Functions erp= new ERP_Functions();
	@BeforeTest
	public void launchapp(){
		
		String app=erp.launchurl("http://webapp.qedge.com");
		System.out.println(app);
		String login=erp.verifyLogin("admin","master");
		System.out.println(login);
	}
	@Test 
	public void supppliercration()throws Throwable
	{
		//to call excel utill methods
		ExcelFileUtil x1=new ExcelFileUtil();
		int rc=x1.rowcount("Supplier");
		int cc=x1.colcount("Supplier");
		Reporter.log("no of rows are::"+rc+"   "+"no of column are::"+cc,true);
		for(int i=1;i<=rc;i++) {
			String sname=x1.getData("Supplier", i, 0);
			String address=x1.getData("Supplier", i, 1);
			String city=x1.getData("Supplier", i, 2);
			String country=x1.getData("Supplier", i, 3);
			String cperson=x1.getData("Supplier", i, 4);
			String pnumber=x1.getData("Supplier", i, 5);
			String mail=x1.getData("Supplier", i, 6);
			String mnumber=x1.getData("Supplier", i, 7);
			String note=x1.getData("Supplier", i, 8);
			String result=erp.verifysupplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			x1.setCellData("Supplier", i, 9, result);
		}
		
	}
	@AfterTest
	public void logout()throws Throwable
	{
		String logoutapp=erp.verifyLogout();
		System.out.println(logoutapp);
		//driver.close();
		
	}
	

}
