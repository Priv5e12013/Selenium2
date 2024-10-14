package week2;

import java.time.Duration;
                                                                 //setTimeout(function(){debugger;},5000);
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Select4 {

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
		
		driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys("Salesforce Automation by Your Priyanka");
		
		WebElement edit = driver.findElement(By.xpath("(//a[@role='button'])[23]"));
		//)
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("argument[0].click()", edit);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@aria-label='Group Type']")).click();
		driver.findElement(By.xpath("//span[@title='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		driver.findElement(By.xpath("//a[@title='Salesforce Automation by Your Priyanka']")).click();
		
		String Auto = driver.findElement(By.xpath("//lightning-formatted-text[text()='Automation']")).getText();
		
		if(Auto.contains("Automation")) {
			System.out.println("The Worktype edit successfully");
		}else {
			System.out.println("The Worktype edit not successfully");
		}
				
		

	}

}
