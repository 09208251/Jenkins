package com.checking.com.demoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends MobileMavenConstansTest {
	
	@Test
	public void launch ()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chrome3.4.0\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get("http://mobiles-market.in/");
		System.out.println("mobile launch success");
	}
	@Test
	public void login()
	{
		driver.findElement(By.linkText("USERS")).click();
		driver.findElement(By.id("texUserId")).sendKeys("bharath.sele99@gmail.com");
		driver.findElement(By.id("pasPassword")).sendKeys("bharath");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		//Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='pageMessageTd']/table/tbody/tr/td[2]")).getText(), "Log In Successfull");
	 System.out.println("login sccess");
	}
	 
}
