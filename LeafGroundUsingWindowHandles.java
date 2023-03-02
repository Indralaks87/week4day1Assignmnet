package w4.day1.assignemnts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundUsingWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String title = driver.getTitle();
		System.out.println("Title of main page is:"+title);
		System.out.println(" ");
		
		System.out.println("click and confirm new window open");
		driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> oldWindow = driver.getWindowHandles();
        List<String> newWindow = new ArrayList<String>(oldWindow);
        driver.switchTo().window(newWindow.get(1));
        if(oldWindow.size()>0) {
        	String title2 = driver.getTitle();
        	System.out.println("Title of new window open is:"+title2);
        }
        else {
        	System.out.println("New window is not open");
        }
        driver.close();
        driver.switchTo().window(newWindow.get(0));
        
        
        System.out.println("Find number of opened tabs");
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        Set<String> oldWindow1 = driver.getWindowHandles();
        List<String> newWindow1 = new ArrayList<String>(oldWindow1);
        int size = newWindow1.size();
        System.out.println("No of opened tabs is :"+size);
        for(int i=1; i<=size-1; i++) {
        	driver.switchTo().window(newWindow1.get(i));
            String title2 = driver.getTitle();
        	System.out.println("Title is :"+title2);
        	driver.close();
        }
        driver.switchTo().window(newWindow.get(0));
        
        
        System.out.println("close all windows except primary ");
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        Set<String> oldWindow2 = driver.getWindowHandles();
        List<String> newWindow2 = new ArrayList<String>(oldWindow2);
        int size2 = newWindow2.size();
        System.out.println("No of windows is:"+size2);
        for (int j=1; j<=size2-1; j++) {
        	driver.switchTo().window(newWindow2.get(j));
            String title3 = driver.getTitle();
        	System.out.println("Title is :"+title3);
        	driver.close();
        }
        System.out.println("Except primary all windows are closed");
        driver.switchTo().window(newWindow.get(0));
        
        
        System.out.println("wait for 2 new tabs to open:");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
        Set<String> oldWindow3 = driver.getWindowHandles();
        List<String> newWindow3 = new ArrayList<String>(oldWindow3);
        int size3 = newWindow3.size();
        System.out.println("No of windows open is :"+size3);
        for (int k=1; k<=size3-1; k++) {
        	driver.switchTo().window(newWindow3.get(k));
        	String title4 = driver.getTitle();
        	System.out.println("Title is :"+title4);
        	
        	driver.close();
        }
        
        
        
	}

}
