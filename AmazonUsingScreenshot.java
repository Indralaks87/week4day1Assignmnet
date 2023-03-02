package w4.day1.assignemnts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonUsingScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
		Thread.sleep(2000);
		
		String phonePrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The price of the first product is :"+phonePrice);
		Thread.sleep(2000);
		
		String phoneRatings = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		Thread.sleep(2000);
		System.out.println("Customer ratings for the first displayed product :"+phoneRatings);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowhandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowhandle.get(1));
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destn = new File("./snap/oneplus.png");
		FileUtils.copyFile(screenshotAs, destn);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        String text = driver.findElement(By.xpath("//div[@id='sw-subtotal']")).getText();
        System.out.println(text);
        
        if(text.contains(phonePrice)) {
        	System.out.println("Price of the phone and cartsubtotal is same");
        }
        else {
        	
        	System.out.println("Price of the phone and cartsubtotal is not same");
        }
        
       //driver.close();
      
	}

}
