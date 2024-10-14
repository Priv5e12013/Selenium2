package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sales5 {

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
		
		Actions legal = new Actions(driver);
		legal.moveToElement(driver.findElement(By.xpath("//p[text()='Legal Entities']"))).click().perform();
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Your Priyanka");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String leentity = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by Your Priyanka']")).getText();
		System.out.println(leentity);
		if(leentity.contains(leentity)) {
			System.out.println("The legal name created successfully");
		}else {
			System.out.println("The legal name not created successfully");
		}
		
		
		
	}

}
