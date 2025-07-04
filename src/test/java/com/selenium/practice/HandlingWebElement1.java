package com.selenium.practice;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingWebElement1 {

	WebDriverWait wait;

	@Test(groups= {"Regression"})
	public void testAuthenticationPopUp() {

		WebDriver driver = new ChromeDriver();

		// Authentication pop up
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		WebElement textPresent = driver.findElement(By.cssSelector("div[id='content'] p"));
		Assert.assertEquals(textPresent.getText(), "Congratulations! You must have the proper credentials.");
        driver.close();
	}

	// @Test
	public void iframeExample() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//frame[@src='frame_3.html']"))));
		WebElement ele = driver.findElement(By.name("mytext3"));

		ele.sendKeys("Hello Debasmita");
		System.out.println(driver.findElement(By.tagName("iframe")).getAttribute("src"));
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//frame[@src='frame_2.html']"))));
		ele = driver.findElement(By.name("mytext2"));

		ele.sendKeys("Hello Sudeep");
	}

	// @Test
	// StaleElementReferenceException
	public void autoSuggest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selen");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> autoSuggestions = (List<WebElement>) js
				.executeScript("return document.querySelectorAll('ul li');");
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[class*='sbct
		// PZPZlf']")));
		System.out.println(autoSuggestions.size());

		for (int i = 0; i < autoSuggestions.size(); i++) {
			String autoSuggestion = autoSuggestions.get(i).getText();
			System.out.println(autoSuggestion);
			if (autoSuggestion.equalsIgnoreCase("Selenium")) {
				try {
					autoSuggestions.get(i).click();
					break;
				} catch (Exception e) {
					autoSuggestions = (List<WebElement>) js.executeScript("return document.querySelectorAll('ul li');");
					autoSuggestions.get(i).getText();
					break;
				}
			}
		}

	}

	// @Test
	public void dynamicButton() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele = driver.findElement(By.cssSelector("div[class='widget-content'] button[onclick*='toggle']"));
		System.out.println(ele.getAttribute("name"));
		try {
			ele.click();
			System.out.println(ele.getAttribute("name"));
		} catch (Exception e) {
			ele = driver.findElement(By.cssSelector("div[class='widget-content'] button[onclick*='toggle']"));
			ele.click();
			System.out.println(ele.getAttribute("name"));
		}

	}

	// @Test
	public void radioButton() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
		radioButtons.get(0).click();
		System.out.println(radioButtons.get(0).getAttribute("id") + " selected : " + radioButtons.get(0).isSelected());
		radioButtons.get(1).click();
		System.out
				.println(radioButtons.get(1).getDomProperty("id") + " selected : " + radioButtons.get(1).isSelected());

	}

	// @Test
	public void checkBoxes() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for (WebElement day : checkBoxes) {
			if (day.getDomAttribute("value") != null && (day.getDomAttribute("value").equalsIgnoreCase("Monday")
					|| day.getDomAttribute("value").equalsIgnoreCase("Friday"))) {
				day.click();
				// System.out.println(day.getDomAttribute("value") +" "+day.isSelected());
			}
			System.out.println(day.getDomAttribute("value") + " " + day.isSelected());
		}

	}

	// @Test
	public void dropDownElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.id("country"));
		Select select = new Select(ele);
		System.out.println("Total options : " + select.getOptions().size());
		select.selectByIndex(5);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		select.selectByValue("brazil");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.selectByVisibleText("India");

	}

	// @Test
	public void datePicker() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		DateTimeFormatter formatter;
		// WebElement
		// ele=driver.findElement(By.xpath("//input[@id='datepicker']/../p"));
		// document.querySelector('#datepicker')

		// use JavascriptExecutor to scroll to the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = (WebElement) js.executeScript("return document.querySelector('#datepicker');");
		js.executeScript("arguments[0].scrollIntoView(true)", ele);

		// enter first date format
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("12/12/2024");
		driver.findElement(By.xpath("//h2[text()='Double Click']")).click();

		// enter second date format
		WebElement datePickerText2 = driver.findElement(By.xpath("//input[@id='txtDate']"));
		// datePickerText2 = datePickerText2.findElement(By.xpath("./.."));
		// String SecondDate = datePickerText2.getText();
		// SecondDate = SecondDate.substring(SecondDate.indexOf('(') + 1,
		// SecondDate.indexOf(')'));
		// System.out.println(SecondDate);
		// String dateToBeSelected ="02-05-2025";

		// click date field
		datePickerText2.click();
		// Define the formatter matching your date format
		// formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Parse the date string to LocalDate
		// LocalDate date = LocalDate.parse(dateToBeSelected, formatter);

		// Extract parts
		String dayInput = "2";
		String monthInput = "May"; // 1 = Jan, 5 = May
		String yearInput = "2027";

		// selectPastDate(driver, dayInput, monthInput, yearInput);
		// selectFutureDate(driver, dayInput, monthInput, yearInput);

		WebElement monthSelected = driver.findElement(By.cssSelector("select[aria-label='Select month']"));
		Select select = new Select(monthSelected);
		select.selectByVisibleText(monthInput);
		WebElement yearSelected = driver.findElement(By.cssSelector("select[aria-label='Select year']"));
		select = new Select(yearSelected);
		select.selectByVisibleText(yearInput);
		// select date
		List<WebElement> dateElements = driver.findElements(By.cssSelector("td[data-handler='selectDay'] a"));
		for (WebElement eleDate : dateElements) {
			if (eleDate.getText().equals(dayInput)) {
				eleDate.click();
				break;
			}
		}

		// extract third date format
		// WebElement thirdDate = driver.findElement(By.id("start-date"));
		// wait.until(ExpectedConditions.elementToBeClickable(thirdDate));
		// thirdDate.click();
		js = (JavascriptExecutor) driver;
		WebElement eleThirdStartDate = (WebElement) js.executeScript("return document.getElementById('start-date');");
		js.executeScript("arguments[0].value='2025-08-08';", eleThirdStartDate);
		// eleThirdStartDate.sendKeys(Keys.TAB);
		WebElement eleThirdEndDate = (WebElement) js.executeScript("return document.getElementById('end-date');");
		js.executeScript("arguments[0].value='2025-08-08';", eleThirdEndDate);
		driver.findElement(By.className("submit-btn")).click();
		System.out.println(driver.findElement(By.id("result")).getText());

	}

	// select future date
	public void selectFutureDate(WebDriver driver, String expectedDate, String expectedMonth, String expectedYear) {
		// select past year and month
		while (true) {
			WebElement monthSelected = driver
					.findElement(By.cssSelector("select[aria-label='Select month'] option[selected]"));
			WebElement yearSelected = driver
					.findElement(By.cssSelector("select[aria-label='Select year'] option[selected]"));

			if (monthSelected.getText().equalsIgnoreCase(expectedMonth)
					&& yearSelected.getText().equalsIgnoreCase(expectedYear)) {
				break;
			}

			driver.findElement(By.xpath("//a/span[text()='Next']")).click();
		}
		// select date
		List<WebElement> dateElements = driver.findElements(By.cssSelector("td[data-handler='selectDay'] a"));
		for (WebElement ele : dateElements) {
			if (ele.getText().equals(expectedDate)) {
				ele.click();
				break;
			}
		}

	}

	// select past date
	public void selectPastDate(WebDriver driver, String expectedDate, String expectedMonth, String expectedYear) {
		// select past year and month
		while (true) {
			WebElement monthSelected = driver
					.findElement(By.cssSelector("select[aria-label='Select month'] option[selected]"));
			WebElement yearSelected = driver
					.findElement(By.cssSelector("select[aria-label='Select year'] option[selected]"));

			if (monthSelected.getText().equalsIgnoreCase(expectedMonth)
					&& yearSelected.getText().equalsIgnoreCase(expectedYear)) {
				break;
			}

			driver.findElement(By.xpath("//a/span[text()='Prev']")).click();
		}
		// select date
		List<WebElement> dateElements = driver.findElements(By.cssSelector("td[data-handler='selectDay'] a"));
		for (WebElement ele : dateElements) {
			if (ele.getText().equals(expectedDate)) {
				ele.click();
				break;
			}
		}

	}

	// @Test
	public void mouseHover() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		WebElement visibleElement = driver.findElement(By.cssSelector("button[class='dropbtn']"));
		jp.executeScript("arguments[0].scrollIntoView(true)", visibleElement);

		// jp.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		String innerText = (String) jp.executeScript("return document.querySelector('h2.title').innerText;");
		System.out.println(innerText);
		Actions action = new Actions(driver);
		List<WebElement> listOfPointMe = driver.findElements(By.cssSelector("div[class='dropdown-content'] a"));
		// action.moveToElement(visibleElement).moveToElement(listOfPointMe.get(0)).click().perform();

	}

	@Test
	public void doubleClick() {
		ChromeOptions options=new ChromeOptions();
		String filePath = Paths
				.get(System.getProperty("user.dir"), "src", "test", "resources", "Extensions", "AdBlock.crx")
				.toString();
		options.addExtensions(new File(filePath));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		driver.switchTo().frame("iframeResult");
		action.doubleClick(driver.findElement(By.xpath("//p[@id='demo']/preceding-sibling::p"))).perform();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
		driver.close();
	}

	@Test
	public void rightClick() {
		ChromeOptions options = new ChromeOptions();
		String filePath = Paths
				.get(System.getProperty("user.dir"), "src", "test", "resources", "Extensions", "AdBlock.crx")
				.toString();
		options.addExtensions(new File(filePath));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/vue/tryit.php?filename=tryvue_modifiers_rightClick");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.switchTo().frame("iframeResult_0");
		WebElement styleElement = driver.findElement(By.cssSelector("div#app div"));
		System.out.println(styleElement.getDomAttribute("style"));
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.cssSelector("div#app div p"))).perform();
		styleElement = driver.findElement(By.cssSelector("div#app div"));
		System.out.println(styleElement.getDomAttribute("style"));
		driver.close();

	}
	
	@Test(groups= {"Regression"})
	public void dragAndDrop() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement visibleElement = driver.findElement(By.cssSelector("button[class='dropbtn']"));
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		jp.executeScript("arguments[0].scrollIntoView(true)", visibleElement);
		Actions action=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		System.out.println(driver.findElement(By.id("droppable")).getText());
		action.dragAndDrop(source, target).perform();
		System.out.println(driver.findElement(By.id("droppable")).getText());
	    driver.close();	
	}
}
