package com.checking.com.demoo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_creationTest extends MobileMavenConstansTest{

	@Test
	public void clickadsLink() {
		driver.findElement(By.linkText("ADS")).click();
		driver.findElement(By.linkText("POST AD")).click();
		System.out.println("adds link click success");
	}

	@Test
	public void enterData() {
		WebElement el = driver.findElement(By.id("selCompany"));
		Select sel = new Select(el);
		sel.selectByVisibleText("Karbonn");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.findElement(By.id("selModel")).sendKeys("jumbo k9");
		driver.findElement(By.id("texExpectedPrice")).sendKeys("15000");
		driver.findElement(By.id("dop_Month_ID")).sendKeys("Aug");
		driver.findElement(By.id("dop_Day_ID")).sendKeys("16");
		driver.findElement(By.id("dop_Year_ID")).sendKeys("2016");
		driver.findElement(By.id("radDualSimYes")).click();
		driver.findElement(By.id("radTouchScreenYes")).click();
		driver.findElement(By.id("radFlipModelYes")).click();
		driver.findElement(By.id("texExandableMemory")).sendKeys("128");
		driver.findElement(By.id("texDescription")).sendKeys("new mobile best perfomence");
		try {
			Select se = new Select(driver.findElement(By.xpath(".//*[@id='selModel']")));
			se.selectByIndex(5);
		} catch (Exception e) {
			Select se = new Select(driver.findElement(By.id("selModel")));
			se.selectByVisibleText("jumbo k9");
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("SKIP")).click();
		String code = driver
				.findElement(By.xpath("html/body/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table[2]/tbody/tr[5]/td[2]"))
				.getText();

		System.out.println(code);
		String act = driver
				.findElement(By.xpath("html/body/table/tbody/tr[6]/td/table/tbody/tr/td[2]/table[2]/tbody/tr[5]/td[5]"))
				.getText();
		System.out.println(act);
	}

}
