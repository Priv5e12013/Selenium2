package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sales3 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("August@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(30);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//p[text()='Work Type Groups']"))).click().perform();
		
		Thread.sleep(30);
		WebElement New= driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", New);
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Your Priyanka");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String done = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by Your Priyanka']")).getText();
		if(done.contains("Priyanka Mani")){
			System.out.println("Work Type Group Name done by Successfully");
		}else {
			System.out.println("Work Type Group Name done by not Successfully");
		}
		
		
		
		 
		
	}

}
