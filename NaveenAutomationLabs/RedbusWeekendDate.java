package redbus;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedbusWeekendDate{
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");	
		
		String Rununtil = "Jul 2025";
		
		//Click on the calender
		driver.findElement(By.cssSelector("#onwardCal")).click();
		
		
		do {
			
			//Get the month and holiday count 
			
			String extract = driver.findElement(By.cssSelector("div[class^=DayNavigator__IconBlock]:nth-child(2)")).getText();
						
			System.out.println(extract);
			
			//Check if the current month is the given month
			if(extract.contains(Rununtil)) {
				
				List<WebElement> dates = driver.findElements(By.cssSelector("span[class$=bwoYtA]"));
				
				ArrayList<String> alldate = new ArrayList<String>();
				
				// If yes, get all the elements of weekend dates, loop and store it in array list 
				
				 for(int i = 0; i< dates.size(); i++) {
			         //obtain text
					String s = dates.get(i).getText();
					alldate.add(s);
				 } 
				 System.out.println(alldate);
				break;
			}
			
			//If not, click to visit next month 
			driver.findElement(By.cssSelector("div[class^=DayNavigator__IconBlock]:nth-child(3)")).click();
			
		}	while (true);
	}
}