package data_extraction;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HTMLDataExtraction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://www.w3schools.com/html/html_tables.asp");
	        waitForTheUser();
	        
	        JavascriptExecutor scrollDownOne = (JavascriptExecutor) driver;
	        scrollDownOne.executeScript("window.scrollBy(0,200)");
			waitForTheUser();
			
			// Locate the table by XPath
	        WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='ws-table-all']")));
	        waitForTheUser();
	        
	        // Get all rows from the table (skip the first row as it's the header)
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        
	        // Loop through each row
	        for (int i = 1; i < rows.size(); i++) {
	        	WebElement row = rows.get(i);
	        	
	        	// Get all columns (td) in the current row
                List<WebElement> cols = row.findElements(By.tagName("td"));
                
             // Extract the Company, Contact and Country
                if (cols.size() > 1) {
                	String company = cols.get(0).getText().trim();      // Company (1st column)
                	String contact = cols.get(1).getText().trim();      // Contact (2nd column)
                    String country = cols.get(2).getText().trim();      // Country (3rd column)
                    
                    // Print the extracted data
                    System.out.println("Company: " + company + " | Contact: " + contact + " | Country: " + country);
                }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
	
	public static void waitForTheUser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
