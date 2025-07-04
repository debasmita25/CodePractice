package com.selenium.practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebdriverMethods {

	@Test(groups= {"Regression"})
	public void methodsWebdriver() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String parentPage = driver.getWindowHandle();

		// find element
		WebElement newtabBtn = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newtabBtn.click();

		// find window handle to switch
		Set<String> handles = driver.getWindowHandles();
		Iterator itr = handles.iterator();
		while (itr.hasNext()) {

			String currentHandle = (String) itr.next();
			if (!currentHandle.equals(parentPage)) {
				driver.switchTo().window(currentHandle);
				System.out.println(driver.getTitle());
			}
		}

		driver.switchTo().window(parentPage);
		System.out.println("parent page : " + driver.getTitle());

		// Navigate
		driver.findElement(By.xpath("//a[text()='Online Trainings']")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://www.google.com");

		// manage()
		driver.manage().deleteAllCookies();
		// driver.manage().addCookie(Cookie cookie);
		// driver.manage().deleteCookie(Cookie cookie);
		// driver.manage().deleteCookieNamed(String name);

		// manage().window()
		driver.manage().window().fullscreen();
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		System.out.println(driver.manage().window().getPosition());//Point
		System.out.println(driver.manage().window().getSize());//Dimension

		// driver.manage().timeouts().
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("Page load Timeout : "+driver.manage().timeouts().getPageLoadTimeout());
	    System.out.println("implicitly : "+driver.manage().timeouts().getImplicitWaitTimeout());
	
	    //driver.switchTo()
	    
	    driver.switchTo().newWindow(WindowType.TAB);
	    driver.get("https://testautomationpractice.blogspot.com/");
	    driver.switchTo().newWindow(WindowType.WINDOW);
	    driver.get("https://testautomationpractice.blogspot.com/");
	    WebElement ele=driver.findElement(By.id("alertBtn"));
	    ele.click();
	    //simple Alert
	    driver.switchTo().alert().accept();
	    //Confirmation Alert
	    WebElement conAlertEle=driver.findElement(By.id("confirmBtn"));
	    conAlertEle.click();
	    Alert alertCon=driver.switchTo().alert();
	    System.out.println(alertCon.getText());
	    alertCon.dismiss();
	    WebElement promptAlertEle=driver.findElement(By.id("promptBtn"));
	    promptAlertEle.click();
	    Alert alertPrompt=driver.switchTo().alert();
	    System.out.println(alertPrompt.getText());
	    alertPrompt.sendKeys("Debasmita");
	    alertPrompt.accept();
	    WebElement eleText=driver.findElement(By.cssSelector("p#demo"));
	    Assert.assertEquals(eleText.getText(),"Hello Debasmita! How are you today?");
	    
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	    
	    driver.close();
	    driver.quit();
	    
	}
}
