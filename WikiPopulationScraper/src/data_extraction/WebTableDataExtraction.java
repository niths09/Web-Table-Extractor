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

public class WebTableDataExtraction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			// Print the message before extraction
            System.out.println("List of countries and territories by total population");
			
			// Open the Wikipedia page
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
	        waitForTheUser();
	        
	        JavascriptExecutor scrollDownOne = (JavascriptExecutor) driver;
	        scrollDownOne.executeScript("window.scrollBy(0,1200)");
			waitForTheUser();
	        
	        // Locate the table by XPath
	        WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='wikitable sortable sticky-header sort-under mw-datatable col2left col6left jquery-tablesorter']")));
	        waitForTheUser();
	        
	        // Get all rows from the table (skip the first row as it's the header)
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        
	        // Loop through each row
	        for (int i = 1; i < rows.size(); i++) {                      // Start from 1 to skip header
	        	WebElement row = rows.get(i);
	        	
	        	// Get all columns (td) in the current row
                List<WebElement> cols = row.findElements(By.tagName("td"));
                
                // Extract the Location, Population, % of world, Date, Source and Notes
                if (cols.size() > 1) {
                	String location = cols.get(0).getText().trim();      // Location (1st column)
                    String population = cols.get(1).getText().trim();    // Population (2nd column)
                    String perc_world = cols.get(2).getText().trim();    // % of world (3rd column)
                    String date = cols.get(3).getText().trim();          // Date (4th column)
                    String source = cols.get(4).getText().trim();        // Source (5th column)
                    String notes = cols.get(5).getText().trim();        // Notes (6th column)
                    
                    // Print the extracted data
                    System.out.println("Location: " + location + " | Population: " + population + " | % of world: " + perc_world + " | Date: " + date + " | Source: " + source + " | Notes: " + notes);
                }
	        }  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser after scraping
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
