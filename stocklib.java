package com.ERP.master;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class stocklib 
{
	public static Properties pr;
	public static FileInputStream fis;
	
    public static WebDriver driver;
    public static String expval,actval;
    
    public String openApp(String url) throws IOException
    {
    	pr=new Properties();
    	fis=new FileInputStream("D:\\vinod\\ERP\\src\\com\\ERP\\properties\\erp.properties");
    	pr.load(fis);
    	expval="Login";
    	driver=new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
        driver.get(url);
    	actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
    	if (actval.equalsIgnoreCase(expval)) {
    		return "application opened seccessfully,pass";
			
		} else {
			return "application not opened,fail";
			

		}
    }
	
	public String adminLogin(String un,String pwd)
	
	{
		  expval="Administrator";
		    driver.findElement(By.id(pr.getProperty("reset"))).click();
			driver.findElement(By.id(pr.getProperty("uname"))).sendKeys(un);
			driver.findElement(By.id(pr.getProperty("pword"))).sendKeys(pwd);
			driver.findElement(By.id(pr.getProperty("alogin"))).click();
			actval=driver.findElement(By.xpath(pr.getProperty("result"))).getText();
	      
			if (actval.equalsIgnoreCase(expval))
	        {
				return "admin login successed,pass";
			} else {
				return "admin login filed,fail";

			}
		
		
		
		
	}
  
	public String suppliers(String sn,String add,String city,String coun,String cp,String pn,String email,String mn,String note)
	{
		expval="Add succeeded";
		driver.findElement(By.xpath(pr.getProperty("suppliers"))).click();
		
		driver.findElement(By.xpath(pr.getProperty("supplieradd"))).click();
        driver.findElement(By.xpath(pr.getProperty("sn"))).sendKeys(sn);
        driver.findElement(By.id(pr.getProperty("address"))).sendKeys(add);
        driver.findElement(By.id(pr.getProperty("city"))).sendKeys(city);
        driver.findElement(By.id(pr.getProperty("country"))).sendKeys(coun);
        driver.findElement(By.id(pr.getProperty("cp"))).sendKeys(cp);
        driver.findElement(By.id(pr.getProperty("pn"))).sendKeys(pn);
        driver.findElement(By.id(pr.getProperty("mail"))).sendKeys(email);
        driver.findElement(By.id(pr.getProperty("mn"))).sendKeys(mn);
        driver.findElement(By.id(pr.getProperty("note"))).sendKeys(note);
        driver.findElement(By.id(pr.getProperty("suppadd"))).click();
        driver.findElement(By.xpath(pr.getProperty("ok"))).click();
        driver.findElement(By.xpath(pr.getProperty("ok"))).click();
        
        actval=driver.findElement(By.xpath(pr.getProperty("res"))).getText();
        System.out.println(actval);
        if (actval.contains(expval)) {
			return "supplier creation added successfully,pass";
		} else {
			return "supplier creation not added,fail";

		}
	}

	public String stockCategorie(String un)
	{
		expval="Add succeeded";
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(pr.getProperty("si")))).build().perform();
		driver.findElement(By.xpath(pr.getProperty("sc"))).click();
		driver.findElement(By.xpath(pr.getProperty("scadd"))).click();
		driver.findElement(By.xpath(pr.getProperty("cn"))).sendKeys(un);
		driver.findElement(By.xpath(pr.getProperty("categorieadd"))).click();
		driver.findElement(By.xpath(pr.getProperty("scok"))).click();
		driver.findElement(By.xpath(pr.getProperty("scok"))).click();
		actval=driver.findElement(By.xpath(pr.getProperty("scres"))).getText();
		if (actval.contains(expval)) {
			return "stock categeroie added successfully,pass";
			
		} else {
			
			return "stock categeroie not added successfully,fail";
		}
	}
	 
	public static  String uom(String uid,String udes)
	{
		expval="Add succeeded";
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(pr.getProperty("uomsi")))).build().perform();	
        driver.findElement(By.xpath(pr.getProperty("uomclick"))).click();
        driver.findElement(By.xpath(pr.getProperty("uomadd"))).click();
        driver.findElement(By.xpath(pr.getProperty("uomid"))).sendKeys(uid);
        driver.findElement(By.xpath(pr.getProperty("uomdes"))).sendKeys(udes);
        driver.findElement(By.xpath(pr.getProperty("uomaddition"))).click();
        driver.findElement(By.xpath(pr.getProperty("uomok"))).click();
        driver.findElement(By.xpath(pr.getProperty("uomok"))).click();
        actval=driver.findElement(By.xpath(pr.getProperty("uomres"))).getText();
		if (actval.equalsIgnoreCase(expval)) {
			return "pass";
			
		} else {
			
			return "fail";
		}
	}

    public String stockItems(String cat,String sn,String stname,String uomr,String pp,String sp,String not)
    {
    	expval="Add succeeded";
    	driver.findElement(By.xpath(pr.getProperty("stockitemclick"))).click();
		driver.findElement(By.xpath(pr.getProperty("stockitemadd"))).click();
		Select catlist=new Select(driver.findElement(By.xpath(pr.getProperty("stockitemcategeroie"))));
		catlist.selectByVisibleText(cat);
		Select supnumlist=new Select(driver.findElement(By.xpath(pr.getProperty("stockitemssn"))));
		supnumlist.selectByVisibleText(sn);
		driver.findElement(By.xpath(pr.getProperty("stockitemstockname"))).sendKeys(stname);
		Select uom=new Select(driver.findElement(By.xpath(pr.getProperty("stockitemuom"))));
		uom.selectByVisibleText(uomr);
		driver.findElement(By.xpath(pr.getProperty("sipp"))).sendKeys(pp);
		driver.findElement(By.xpath(pr.getProperty("sisp"))).sendKeys(sp);
		driver.findElement(By.xpath(pr.getProperty("sinotes"))).sendKeys(not);
		driver.findElement(By.xpath(pr.getProperty("stockitemaddition"))).click();
		driver.findElement(By.xpath(pr.getProperty("stockitemok"))).click();
		driver.findElement(By.xpath(pr.getProperty("stockitemok"))).click();
		actval=driver.findElement(By.xpath(pr.getProperty("stockitemres"))).getText();
		if (actval.contains(expval)) {
			return "stockitem added successfully,pass";
			
		} else {
			
			return "stockitem not added successfully,fail";
		}
    	
    }

    public String closebrowser()
    {
    	driver.close();
    	return "application closed";
    }

}

