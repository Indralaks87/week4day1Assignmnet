package w4.day1.assignemnts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContactUsingAlert {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement((By.className("decorativeSubmit"))).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.linkText("Merge Contacts")).click();
        
        //click on widget of from contact
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
        Set<String> firstLookUp = driver.getWindowHandles();
        List<String> fromLookUp = new ArrayList<String>(firstLookUp);
        driver.switchTo().window(fromLookUp.get(1));
        
        //click on first resulting contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
        driver.switchTo().window(fromLookUp.get(0));
        
        Thread.sleep(2000);
        
        //click on widget of To contact
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        Set<String> secondLookUp = driver.getWindowHandles();
        List<String> toLookUp = new ArrayList<String>(secondLookUp);
        driver.switchTo().window(toLookUp.get(1));
        
        Thread.sleep(2000);
        //click on second resulting contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
        driver.switchTo().window(toLookUp.get(0));
        
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        //To accept alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        String title = driver.getTitle();
        System.out.println(title);
        
        
        
       
        
        
        
        
        
        
	}

}
