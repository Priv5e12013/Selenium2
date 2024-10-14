package week2;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sales6 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();                                         //setTimeout(function(){debugger;},5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(30);
		
		Actions legal = new Actions(driver);
		legal.moveToElement(driver.findElement(By.xpath("//p[text()='Legal Entities']"))).click().perform();
		
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("Salesforce Automation by Your Priyanka");
		
		WebElement legal1 = driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("argument[0].click()", legal1);
		Thread.sleep(30);

		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.name("CompanyName")).sendKeys("Tetsleaf");
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("SalesForce");
		driver.findElement(By.xpath("(//button[@type='button'])[37]")).click();
		Thread.sleep(30);

		driver.findElement(By.xpath("//span[@title='Active']")).click();
		driver.findElement(By.name("SaveEdit")).click();
		
		String edit = driver.findElement(By.xpath("//a[@title='Salesforce Automation by Your Priyanka']")).getText();
		if(edit.contains(edit)) {
			System.out.println("The legal entity edited successfully");
		}else {
			System.out.println("The legal entity edited not successfully");
		}
		
	}

}
