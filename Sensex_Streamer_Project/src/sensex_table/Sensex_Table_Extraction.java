package sensex_table;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sensex_Table_Extraction {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://www.moneycontrol.com/markets/indian-indices/");
            waitForTheUser();

            JavascriptExecutor scrollDownOne = (JavascriptExecutor) driver;
            scrollDownOne.executeScript("window.scrollBy(0,400)");
            waitForTheUser();

            // Locate the table by XPath
            WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='indicesTable']")));
            waitForTheUser();

            // Get all rows from the table (skip the first row as it's the header)
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            // Print the message before extraction
            System.out.println("Indian Indices - Markets Terminal : NIFTY 50");
            System.out.println();
            
            // Print table headers with outer box
            printLine(); // Top border
            System.out.printf("| %-20s | %-12s | %-8s | %-8s | %-12s | %-12s | %-12s | %-10s | %-10s | %-15s |\n", 
                "Name", "LTP", "%Chg", "Chg", "Volume", "Buy Price", "Sell Price", "Buy Qty", "Sell Qty", "Analysis");
            printLine(); // Header separator

            // Loop through each row
            for (int i = 1; i < rows.size(); i++) {
                WebElement row = rows.get(i);

                // Get all columns (td) in the current row
                List<WebElement> cols = row.findElements(By.tagName("td"));

                // Extract the data
                if (cols.size() > 1) {
                    String name = cols.get(0).getText().trim();         // Name (1st column)
                    String ltp = cols.get(1).getText().trim();          // LTP (2nd column)
                    String per_chg = cols.get(2).getText().trim();      // %Chg (3rd column)
                    String chg = cols.get(3).getText().trim();          // Chg (4th column)
                    String volume = cols.get(4).getText().trim();       // Volume (5th column)
                    String buy_price = cols.get(5).getText().trim();    // Buy Price (6th column)
                    String sell_price = cols.get(6).getText().trim();   // Sell Price (7th column)
                    String buy_qty = cols.get(7).getText().trim();      // Buy Qty (8th column)
                    String sell_qty = cols.get(8).getText().trim();     // Sell Qty (9th column)
                    String analysis = cols.get(9).getText().trim();     // Analysis (10th column)

                    // Print the extracted data in a table format
                    System.out.printf("| %-20s | %-12s | %-8s | %-8s | %-12s | %-12s | %-12s | %-10s | %-10s | %-15s |\n", 
                        name, ltp, per_chg, chg, volume, buy_price, sell_price, buy_qty, sell_qty, analysis);
                }
            }
            printLine(); // Bottom border
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Helper method to print a horizontal line
    public static void printLine() {
        System.out.println("+----------------------+--------------+----------+----------+--------------+--------------+--------------+------------+------------+-----------------+");
    }

    public static void waitForTheUser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
