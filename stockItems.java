package com.ERP.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class stockItems {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expval="reset";
		
		driver.get("http://webapp.qedgetech.com");
		driver.manage().window().maximize();
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
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		Select catlist=new Select(driver.findElement(By.xpath(".//*[@id='x_Category']")));
		catlist.selectByVisibleText("busses454");
		Select supnumlist=new Select(driver.findElement(By.xpath(".//*[@id='x_Supplier_Number']")));
		supnumlist.selectByVisibleText("volvocompany");
		driver.findElement(By.xpath(".//*[@id='x_Stock_Name']")).sendKeys("acluxura");
		Select uom=new Select(driver.findElement(By.xpath(".//*[@id='x_Unit_Of_Measurement']")));
		uom.selectByVisibleText("Items");
		driver.findElement(By.xpath(".//*[@id='x_Purchasing_Price']")).sendKeys("20000000");
		driver.findElement(By.xpath(".//*[@id='x_Selling_Price']")).sendKeys("30000000");
		driver.findElement(By.xpath(".//*[@id='x_Notes']")).sendKeys("it is the ac bus");
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();

	}

}
