package Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TestBase {
	public static WebDriver driver;
	String path = "C:\\Users\\rituyashu\\eclipse-workspace_01\\Test_001\\TestData.csv";
	
	public void initilization() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
	}
	
	public void csvrederfile() throws CsvValidationException, IOException {
		CSVReader reader = new CSVReader(new FileReader(path));
		String[] cell;
		
		while((cell=reader.readNext())!=null) {
			
			for(int i=0; i<1; i++) {
				String loc = cell[i];
				String dest = cell[i+1];
				String date = cell[i+2];
			
				driver.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys(loc);
				driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys(dest);
			
			}
			
		}
		
		
		
	}

}
