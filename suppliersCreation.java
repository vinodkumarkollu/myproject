package com.ERP.scripts;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class suppliersCreation {

	public static void main(String[] args)
	{
        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String expval="reset";
		String expheader="Stock Accounting System";
		String exptitle="Suppliers ";
		
		
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
		String actheader=driver.getTitle();
	      
		if (actheader.contains(expheader))
        {
			System.out.println("stock accounting home page launched");
		} else {
			System.out.println("stock accounting home page is not launched");

		}

		driver.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
		String acttitle=driver.getTitle();
		System.out.println(acttitle);
		if (acttitle.contains(exptitle)) {
			System.out.println("suppliers page launched successfully");
			
		} else {
			System.out.println("suppliers page is not launched");

		}
		
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
        driver.findElement(By.xpath(".//*[@id='x_Supplier_Name']")).sendKeys("volvocompany");
        driver.findElement(By.id("x_Address")).sendKeys("atmakur,nellore(dt),andhrapradesh");
        driver.findElement(By.id("x_City")).sendKeys("Atmakur");
        driver.findElement(By.id("x_Country")).sendKeys("India");
        driver.findElement(By.id("x_Contact_Person")).sendKeys("vinodkumar");
        driver.findElement(By.id("x_Phone_Number")).sendKeys("9999999999");
        driver.findElement(By.id("x__Email")).sendKeys("volvocompany.gmail.com");
        driver.findElement(By.id("x_Mobile_Number")).sendKeys("8888888888");
        driver.findElement(By.id("x_Notes")).sendKeys("this company provides busses and cars");
        driver.findElement(By.id("btnAction")).click();
        driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
       
       
       
        
        
	}

}
