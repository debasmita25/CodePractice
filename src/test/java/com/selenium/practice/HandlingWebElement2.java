package com.selenium.practice;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class HandlingWebElement2 {

	WebDriverWait wait;

	@Test(groups= {"Regression"})
	public void copyPaste() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement visibleElement = driver.findElement(By.cssSelector("button[class='dropbtn']"));
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		jp.executeScript("arguments[0].scrollIntoView(true)", visibleElement);
		Actions action = new Actions(driver);
		WebElement field1 = driver.findElement(By.id("field1"));
		WebElement field2 = driver.findElement(By.id("field2"));
		field1.clear();
		field1.sendKeys("Debasmita");

		// first approach with Actions class
		field1.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		field2.click();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		// send Approach
		field1.clear();
		field1.sendKeys("Sudeep");
		field1.click();
		field1.sendKeys(Keys.CONTROL + "a");
		field1.sendKeys(Keys.CONTROL + "c");
		field2.click();
		field2.sendKeys(Keys.CONTROL + "v");
		
		driver.close();

	}

	// @Test
	public void sliderElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		WebElement visibleElement = (WebElement) jp.executeScript(
				"return [...document.querySelectorAll(\"*\")].find(el => el.textContent?.trim() === \"Slider\");");
		jp.executeScript("arguments[0].scrollIntoView(true)", visibleElement);
		Actions action = new Actions(driver);
		WebElement sliderFull = driver.findElement(By.cssSelector("div[id='slider-range']"));
		System.out.println(sliderFull.getLocation());
		List<WebElement> sliders = driver.findElements(By.cssSelector("div[id='slider-range'] span"));
		WebElement minSlider = sliders.get(0);
		WebElement maxSlider = sliders.get(1);

		Point ptMin = minSlider.getLocation();
		Point ptMax = maxSlider.getLocation();
		System.out.println(ptMin.getX() + " " + ptMin.getY());
		System.out.println(ptMax.getX() + " " + ptMax.getY());
		// action.dragAndDropBy(minSlider, 800, 2019).perform();
		// action.dragAndDropBy(maxSlider, 864, 2019);
		action.clickAndHold(minSlider).moveByOffset(800, 2019).release().perform();
	}

	@Test
	public void sliderDemo() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		System.out.println(minSlider.getLocation());// (59, 250)
		System.out.println(maxSlider.getLocation());// (412, 250)

		Actions action = new Actions(driver);
		// action.dragAndDropBy(minSlider, 350, 250).perform();
		// action.dragAndDropBy(maxSlider, -100, 250).perform();
		action.clickAndHold(maxSlider).moveByOffset(-100, 250).release().perform();
		System.out.println(minSlider.getLocation());
		System.out.println(maxSlider.getLocation());
		driver.close();
	}

	// @Test
	public void svgElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']")).click();
      
	}

	@Test
	public void dynamicWebTable1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> listOfHeaders = driver.findElements(By.cssSelector("tr[id='headers'] th"));
		List<WebElement> listOfRows = driver.findElements(By.cssSelector("tbody[id='rows'] tr"));
		System.out.println("printing header****************");
		for (WebElement header : listOfHeaders) {
			System.out.print(header.getText() + "   " + "\t");
		}
		System.out.println();
		for (int i = 0; i < listOfRows.size(); i++) {
			int colsPerRecord = listOfRows.get(i).findElements(By.xpath("./td")).size();
			for (int j = 0; j < colsPerRecord; j++) {
				System.out.print(listOfRows.get(i).findElements(By.xpath("./td")).get(j).getText());
			}

			System.out.println();
		}

		driver.close();
	}

	@Parameters("browser")
	@Test(groups= {"Regression"})
	public void dynamicWebTable2(String browser) {
		System.out.println("I AM PARAMETERIZED");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> listOfHeaders = driver.findElements(By.cssSelector("tr[id='headers'] th"));
		List<WebElement> listOfRows = driver.findElements(By.cssSelector("tbody[id='rows'] tr"));
		System.out.println("printing header****************");
		for (WebElement header : listOfHeaders) {
			System.out.print(header.getText() + "   " + "\t");
		}
		System.out.println();
		for (int i = 0; i < listOfRows.size(); i++) {
			int colsPerRecord = listOfRows.get(i).findElements(By.xpath("./td")).size();
			for (int j = 0; j < colsPerRecord; j++) {
				System.out.print(listOfRows.get(i).findElements(By.xpath("./td")).get(j).getText() + "   " + "\t");
			}

			System.out.println();
		}

		driver.close();
	}

	// @Test
	public void fileUploads() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		WebElement fileUpload = driver.findElement(By.id("filesToUpload"));
		String path1 = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testdata",
				"BMS_uploaded_ECG_tracker.xlsx").toString();
		String path2 = Paths
				.get(System.getProperty("user.dir"), "src", "test", "resources", "testdata", "data.properties")
				.toString();

		fileUpload.sendKeys(path1);
		fileUpload.sendKeys(path2);

		JavascriptExecutor jp = (JavascriptExecutor) driver;
		WebElement ele = (WebElement) jp.executeScript(
				"return [...document.querySelectorAll('*')].find(e1=>e1.textContent.trim() === 'Files You Selected:')");
		System.out.println(ele.getText());
		List<WebElement> listOfFiles = driver.findElements(By.id("fileList"));
		for (WebElement file : listOfFiles) {
			System.out.println(file.getText());
		}
	}

	@Test(groups= {"Regression"})
	public void takeScreenshot() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		WebElement visibleElement = (WebElement) jp.executeScript(
				"return [...document.querySelectorAll(\"*\")].find(el => el.textContent?.trim() === \"Slider\");");
		jp.executeScript("arguments[0].scrollIntoView(true)", visibleElement);
		/*
		 * File captureSourceFile = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE); File location = new File(
		 * Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
		 * "screenshots", "screenshot1.jpeg") .toString()); try {
		 * Files.copy(captureSourceFile, location);
		 * System.out.println("Screenshot taken"); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace();
		 * System.out.println("Screenshot NOT taken"); }
		 */
		
		 //using WebElement TakesScreenshot
		File src= visibleElement.getScreenshotAs(OutputType.FILE);
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter dft=DateTimeFormatter.ofPattern("dd_mm_yyyy_hh_mm");
		String filename=dft.format(ldt);
		String pathName=Paths.get(System.getProperty("user.dir"), "src", "test", "resources","screenshots", filename+".jpg") .toString();
		//System.out.println(pathName);
		File location = new File(pathName); 
		try {
		Files.copy(src, location);
		System.out.println("Screenshot taken");} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void findBrokenLinks() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		WebElement visibleElement = (WebElement) jp.executeScript(
				"return [...document.querySelectorAll(\"*\")].find(el => el.textContent?.trim() === \"Broken Links\");");
		jp.executeScript("arguments[0].scrollIntoView(true)", visibleElement);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement ele : links) {
			String url = ele.getDomAttribute("href");
			if (url == null || url.isEmpty() || url.startsWith("javascript") || url.equals("#")) {
				System.out.println(ele.getText() + " : url not present");
				continue;
			}
			HttpURLConnection connection = null;
			try {
				connection = (HttpURLConnection) new URL(url).openConnection();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			connection.setConnectTimeout(3000);
			try {
				connection.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int responseCode = 0;
			try {
				responseCode = connection.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (responseCode >= 400) {
				System.out.println(ele.getText() + " Broken Link " + responseCode);
			} else {
				System.out.println(ele.getText() + " Active Link " + responseCode);
			}
		}

		driver.close();

	}

	@Test(groups= {"Regression"})
	public void shadowDOM() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.automationtesting.in/shadow-dom");
		// JavascriptExecutor jp=(JavascriptExecutor)driver;
		// WebElement shadowRoot=(WebElement)jp.executeScript("return
		// document.querySelector('#shadow-root');");

		// single shadow dom
		// SearchContext
		// shadowRoot=driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		// System.out.println(shadowRoot.findElement(By.cssSelector("#shadow-element")).getText());

		// nested shadow dom
		// SearchContext
		// shadowRootFirst=driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		// SearchContext
		// shadowRootSecond=shadowRootFirst.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		// System.out.println(shadowRootSecond.findElement(By.cssSelector("#nested-shadow-element")).getText());

		// mini nested shadow dom
		SearchContext shadowRootFirst = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		SearchContext shadowRootSecond = shadowRootFirst.findElement(By.cssSelector("#inner-shadow-dom"))
				.getShadowRoot();
		SearchContext shadowRootThird = shadowRootSecond.findElement(By.cssSelector("#nested-shadow-dom"))
				.getShadowRoot();

		System.out.println(shadowRootThird.findElement(By.cssSelector("#multi-nested-shadow-element")).getText());
        driver.close();
	}
}
