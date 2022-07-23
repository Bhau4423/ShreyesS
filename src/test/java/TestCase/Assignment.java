package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Assignment {

	public static void main(String[] args) throws CsvValidationException, IOException, InterruptedException {
		
		WebDriver driver;
		
		String path = "C:\\Users\\rituyashu\\eclipse-workspace_01\\Test_001\\TestData.csv";
	
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.redbus.in/");
			
			CSVReader reader = new CSVReader(new FileReader(path));
			String[] cell;
			
			while((cell=reader.readNext())!=null) {
				
				for(int i=0; i<1; i++) {
					String loc = cell[i];
					String dest = cell[i+1];
					String mo = cell[i+2];
					String yr = cell[i+3];
					String date = cell[i+4];
					
					WebElement h = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
					h.sendKeys(loc);
					Thread.sleep(1000);
					WebElement dt = driver.findElement(By.xpath("//li[@class='selected']"));
					dt.click();
					
					driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys(dest);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//li[@class='selected']")).click();
					driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
					
					while(true) {
						String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
						String ar[]=monthyear.split(" ");
						String month = ar[0];
						String year = ar[1];
						
						
						if(month.equalsIgnoreCase(mo) && year.equals(yr)) 
							break;
						else 
							driver.findElement(By.xpath("//td[@class='next']")).click();
						
						
					}
				
					List<WebElement> list = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
					
					for(WebElement dates:list) {
						String ele = dates.getText();
						if(ele.equals(date)) {
							dates.click();
							break;
						}
					}
//					 
					Thread.sleep(2000);
					int count =0;
					driver.findElement(By.xpath("//button[@id='search_btn']")).click();
					Thread.sleep(2000);
					List<WebElement> bus = driver.findElements(By.xpath("//li[@class='row-sec clearfix']"));
					
					for(int k=0; k<bus.size(); k++) {
						String s = bus.get(k).getText();
						count++;
					}
					 
				
					
      			System.out.println("OutPut Result");
				
			    System.out.print("From    | To  |  Date    |  Bus Count");
			    System.out.println("\n----------------------------------------");
			    System.out.print( loc +   dest + " " + " " +  date + mo + yr +  "  "  +  count);
				
			
	}
					
			
			}
			
	}}
