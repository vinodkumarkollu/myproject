package com.ERP.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class unitofMeasurment {

	
	public static void main(String[] args) 
	{
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
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).build().perform();	
        driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")).click();
        driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
        driver.findElement(By.xpath(".//*[@id='x_UOM_ID']")).sendKeys("454");
        driver.findElement(By.xpath(".//*[@id='x_UOM_Description']")).sendKeys("it is the unit");
        driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
        driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	}

}
