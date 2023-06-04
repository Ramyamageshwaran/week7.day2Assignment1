package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplitcitLearn {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/waits.xhtml ");
		//maximize the browser
		driver.manage().window().maximize();
		//Declare Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		//Wait until visible 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='I am here']")));
	    driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
	    //Wait until invisible
	    WebElement invisibleEle =driver.findElement(By.xpath("//span[text()='I am about to hide']"));
	    wait.until(ExpectedConditions.invisibilityOf(invisibleEle));
	    WebElement clickelement = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
	    clickelement.click();
	    //wait until click the Click First Button
	    wait.until(ExpectedConditions.elementToBeClickable(clickelement));
	    driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
	    WebElement textChange = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
	    //Wait until change the text
	    wait.until(ExpectedConditions.textToBePresentInElement(textChange, "Did you notice?"));
	    
	}

}

