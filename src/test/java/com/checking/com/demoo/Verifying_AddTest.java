package com.checking.com.demoo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verifying_AddTest extends MobileMavenConstansTest{

	@Test
	public void activation_Add() {
		String act = driver
				.findElement(By.xpath("html/body/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table[2]/tbody/tr[5]/td[5]"))
				.getText();
		System.out.println(act);
		if (act.equalsIgnoreCase("Pending")) {

			driver.get("http://mobiles-market.in/admin/");
			String admin = driver.getTitle();
			if (admin.equalsIgnoreCase("Admin Index")) {
				driver.findElement(By.id("texLoginId")).sendKeys("adminmob");
				driver.findElement(By.id("pasPassword")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				System.out.println("admin login success");

			} else {
				System.out.println("Admin url Not Found");
			}
			driver.findElement(By.linkText("ADS")).click();
			driver.findElement(By.linkText("PENDING ADS")).click();
			String id = driver
					.findElement(
							By.xpath("html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td[2]"))
					.getText();
			System.out.println(id + "present id");
			driver.findElement(
					By.xpath("html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td[2]"))
					.click();

			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			
			driver.findElement(By
					.xpath("html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/a[1]"))
					.click();
			/*if (id.equalsIgnoreCase(code)) {
				//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				System.out.println("ids equals");
			} else {
				System.out.println("Code is not matched");
			}*/
		}
	}

	@Test
	public void lunch_UserUrl() {
		driver.get("http://mobiles-market.in");

		System.out.println("User Url Launch success");
		driver.findElement(By.linkText("USERS")).click();
		driver.findElement(By.id("texUserId")).sendKeys("bharath.sele99@gmail.com");
		driver.findElement(By.id("pasPassword")).sendKeys("bharath");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pageMessageTd']/table/tbody/tr/td[2]")).getText(),
				"Log In Successfull");
		System.out.println("login sccess");
		driver.findElement(By.linkText("ADS")).click();
		driver.findElement(By.linkText("VIEW ALL ADS")).click();
		String pendg=driver.findElement(By.xpath("html/body/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table[2]/tbody/tr[5]/td[5]")).getText();
		if (pendg.equalsIgnoreCase("Pending")) {
			System.out.println("still add in pending");
		} else if(pendg.equalsIgnoreCase("Active")){
          System.out.println("Add id in Active mode");
		}
	}
	
}
