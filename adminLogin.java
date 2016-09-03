package com.ERP.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class adminLogin {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		
		String expheader="Stock Accounting System";
		driver.get("http://webapp.qedgetech.com");
		driver.manage().window().maximize();
		String expval="reset";
		String actval=driver.findElement(By.id("btnreset")).getText();
		if (actval.equalsIgnoreCase(expval))
		{
			System.out.println("application launched");
			
		}
		else {
             System.out.println("application not launched");
		}
		driver.findElement(By.id("btnreset")).click();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		String actheader=driver.getTitle();
      
		if (actheader.contains(expheader))
        {
			System.out.println("stock accounting home page launched");
		} else {
			System.out.println("stock accounting home page is not launched");

		}
		driver.close();

	}

}
