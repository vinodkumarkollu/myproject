package com.ERP.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exelib {

	
	public static void main(String[] args) throws IOException 
	
	{
		
		
		
		
		stocklib SL=new stocklib();
		String res=SL.openApp("http://webapp.qedgetech.com");
		System.out.println(res);
		
		res=SL.adminLogin("admin", "master");
		System.out.println(res);
		
		FileInputStream fis2=new FileInputStream("D:\\vinod\\ERP\\src\\com\\ERP\\testData\\uom.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis2);
		XSSFSheet ws=wb.getSheet("testdata");
		
		int rc=ws.getLastRowNum();
		for (int i = 1; i <= rc; i++) 
		{
			XSSFRow wr=ws.getRow(i);
			XSSFCell wc=wr.getCell(0);
			XSSFCell wc1=wr.getCell(1);
			XSSFCell wc2=wr.createCell(2);
			String uid=wc.getStringCellValue();
			String udes=wc1.getStringCellValue();
			String resuom=stocklib.uom(uid, udes);
			System.out.println(resuom);
			wc2.setCellValue(resuom);
		}
		FileOutputStream fos=new FileOutputStream("D:\\vinod\\ERP\\src\\com\\ERP\\testdata\\uom.xlsx");
		wb.write(fos);
		wb.close();
		
		
		res=SL.suppliers("jghjghj", "nellore", "hyd", "ind", "vinod", "9876543210", "bdd", "0123456789", "this is bmw");
		System.out.println(res);
		
		FileInputStream fis3=new FileInputStream("D:\\vinod\\ERP\\src\\com\\ERP\\testData\\sup.xlsx");
		XSSFWorkbook wb1=new XSSFWorkbook(fis3); 
		XSSFSheet ws1=wb1.getSheet("Sheet1");
		int rc1=ws1.getLastRowNum();
		for (int i = 1; i <= rc1; i++) 
		{
			XSSFRow wr1=ws1.getRow(i);
			XSSFCell wc1=wr1.getCell(0);
			
			XSSFCell wc2=wr1.createCell(1);
			String supadd=wc1.getStringCellValue();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			res=SL.stockCategorie(supadd);
			
			System.out.println(res);
			wc2.setCellValue(res);
		}
		FileOutputStream fos1=new FileOutputStream("D:\\vinod\\ERP\\src\\com\\ERP\\testdata\\sup.xlsx");
		wb1.write(fos1);
		wb1.close();
		SL.closebrowser();
		
		
		res=SL.stockItems("busses454", "vinodbmw", "4524552254", "book", "12000", "20000", "gug huh");
		System.out.println(res);
		
        res=SL.closebrowser();
        System.out.println(res);
        
	}

}
