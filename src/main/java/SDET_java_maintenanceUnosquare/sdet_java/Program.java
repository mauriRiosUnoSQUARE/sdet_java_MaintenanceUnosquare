package SDET_java_maintenanceUnosquare.sdet_java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;



public class Program {

	public WebDriver SetUp() 
	{
    	System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://people.unosquare.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public void SendText(WebElement element, String value) 
	{
		element.sendKeys(value);
	}
	
	public void Click(WebElement element) 
	{
		element.click();
	}
	public static void waitForUI() {
		try
		{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	public void ClickWhenEnabled(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	By ThreeDotMenu = By.cssSelector(".module-container .section .fp-tableCell .first-module .navbar .navbar-toggler");
	By AboutUS = By.xpath("//*[@id=\"nav-list\"]/ul/li[3]/a");
	By Benefits = By.cssSelector(".fp-viewing-welcome .module-container .section:nth-child(7)");

	public static void main(String[] args) {
		
		Program program = new Program();
		WebDriver driver = program.SetUp();
		WebElement element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		element = driver.findElement(program.ThreeDotMenu);
		program.Click(element);
		waitForUI();
		element = driver.findElement(program.AboutUS);
		program.Click(element);
		  //js.executeScript("window.scrollBy(0,-1000)");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		waitForUI();
		driver.navigate().to("https://people.unosquare.com/#welcome");
		waitForUI();
	    element = driver.findElement(program.ThreeDotMenu); //added so we can click in Benefits
		program.Click(element);	
		waitForUI();
		element = driver.findElement(program.Benefits);
		program.Click(element);
		
	}

}
