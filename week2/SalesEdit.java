package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesEdit {

	public static void main(String[] args) {
		
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
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement dd = driver.findElement(By.xpath("//span[text()='Opportunities']"));    //driver.findElement(By.id)0
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",dd);
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Priyanka");
		
		WebElement dd1 = driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-down slds-button__icon slds-icon_container forceIcon'])[2]"));
		executor.executeScript("arguments[0].click();",dd1);
		
		driver.findElement(By.xpath("//div[text()='Edit']")).click();
		driver.findElement(By.xpath("//button[@title='Select a date for Close Date']")).click();
		driver.findElement(By.xpath("//span[@class='slds-day' and text()='10']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		
		WebElement dd2 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value'])[4]"));
		executor.executeScript("arguments[0].click();",dd2);
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String stage = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		if(stage.contains("Perception Analysis")) {
			System.out.println("Perception is done");
		}else {
			System.out.println("Perception is not done");

		}
		
		
		
	}

}
