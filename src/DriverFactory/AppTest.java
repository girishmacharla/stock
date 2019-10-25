package DriverFactory;

import org.testng.annotations.Test;

import ERP_Stock.DriverScript;

public class AppTest {
	@Test
	public void ERP_Start() {
		DriverScript dr=new DriverScript();
		
		try {
			dr.startTest();
		}catch(Throwable t) {
			System.out.println(t.getMessage());
		}
		
	}

}
