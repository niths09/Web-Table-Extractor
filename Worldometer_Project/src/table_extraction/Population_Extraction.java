package table_extraction;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Population_Extraction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			// Print the message before extraction
            System.out.println("World Population");
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://www.worldometers.info/world-population/population-by-country/");
	        waitForTheUser();
	        
	        JavascriptExecutor scrollDownOne = (JavascriptExecutor) driver;
	        scrollDownOne.executeScript("window.scrollBy(0,200)");
			waitForTheUser();
			
			// Locate the table by XPath
	        WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-striped table-bordered dataTable no-footer']")));
	        waitForTheUser();
	        
	        // Get all rows from the table (skip the first row as it's the header)
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        
	        // Print headers
            System.out.printf("%-5s %-30s %-15s %-15s %-15s %-10s %-15s %-10s %-10s %-10s %-15s %-10s%n",
                    "No", "Country", "Population", "Yearly Change", "Net Change", "Density", "Land Area",
                    "Migrants", "Fert. Rate", "Med. Age", "Urban Pop%", "World Share");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	        
	        // Loop through each row
	        for (int i = 1; i < rows.size(); i++) {
	        	WebElement row = rows.get(i);
	        	
	        	// Get all columns (td) in the current row
                List<WebElement> cols = row.findElements(By.tagName("td"));
                
                // Extract the No, Country, Population, Yearly Change, Net Change, Density, Land Area, Migrants, Fert. Rate, Med. Age, Urban Pop% and World Share
                if (cols.size() > 1) {
                	String nos = cols.get(0).getText().trim();             // No (1st column)
                	String country = cols.get(1).getText().trim();         // Country (2nd column)
                	String population = cols.get(2).getText().trim();      // Population (3rd column)
                    String yearly_change = cols.get(3).getText().trim();   // Yearly Change (4th column)
                    String net_change = cols.get(4).getText().trim();      // Net Change (5th column)
                    String density = cols.get(5).getText().trim();         // Density (6th column)
                    String land_area = cols.get(6).getText().trim();       // Land Area (7th column)
                    String migrants = cols.get(7).getText().trim();        // Migrants (8th column)
                    String fert_rate = cols.get(8).getText().trim();       // Fert. Rate (9th column)
                    String med_age = cols.get(9).getText().trim();         // Med. Age (10th column)
                    String urban_popln = cols.get(10).getText().trim();    // Urban Pop% (11th column)
                    String world_share = cols.get(11).getText().trim();    // World Share (12th column)
                    
                    // Print the data in table format
                    System.out.printf("%-5s %-30s %-15s %-15s %-15s %-10s %-15s %-10s %-10s %-10s %-15s %-10s%n",
                            nos, country, population, yearly_change, net_change, density, land_area, migrants,
                            fert_rate, med_age, urban_popln, world_share);
	            }
		    }
	        
	        JavascriptExecutor scrollDownTwo = (JavascriptExecutor) driver;
	        scrollDownTwo.executeScript("window.scrollBy(0,4000)");
			waitForTheUser();
			
			JavascriptExecutor scrollDownThree = (JavascriptExecutor) driver;
			scrollDownThree.executeScript("window.scrollBy(0,4000)");
			waitForTheUser();
			
			JavascriptExecutor scrollDownFour = (JavascriptExecutor) driver;
			scrollDownFour.executeScript("window.scrollBy(0,4000)");
			waitForTheUser();
	        
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
