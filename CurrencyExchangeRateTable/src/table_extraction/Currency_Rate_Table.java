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

public class Currency_Rate_Table {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://www.xe.com/currencytables/");
            waitForTheUser();

            JavascriptExecutor scrollDownOne = (JavascriptExecutor) driver;
            scrollDownOne.executeScript("window.scrollBy(0,650)");
            waitForTheUser();

            // Extract data from the first table
            System.out.println("Live Currency Rates");
            printBoxHeader(new String[]{"Currency", "Rate", "Change"}); // Boxed Header for 3 columns
            WebElement liveCurrencyTable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='sc-621fdd77-0 fFOksQ'])[1]")));
            waitForTheUser();
            extractLiveCurrencyData(liveCurrencyTable);

            // Extract data from the second table
            System.out.println("\nCentral Bank Rates");
            printBoxHeader(new String[]{"Currency", "Interest Rate"}); // Boxed Header for 2 columns
            WebElement centralBankTable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='sc-621fdd77-0 fFOksQ'])[2]")));
            waitForTheUser();
            extractCentralBankData(centralBankTable);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void extractLiveCurrencyData(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 1) {
                String currency = cols.get(0).getText().trim();     // Currency (1st column)
                String rate = cols.get(1).getText().trim();         // Rate (2nd column)
                String change = cols.get(2).getText().trim();       // Change (3rd column)
                printRow(new String[]{currency, rate, change}, 3);  // Specify 3 columns
            }
        }
        printBottomLine(3); // Add bottom line to close the table (3 columns)
    }

    public static void extractCentralBankData(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 1) {
                String currency = cols.get(0).getText().trim();     // Currency (1st column)
                String interestRate = cols.get(1).getText().trim(); // Interest Rate (2nd column)
                printRow(new String[]{currency, interestRate}, 2);  // Specify 2 columns
            }
        }
        printBottomLine(2); // Add bottom line to close the table (2 columns)
    }

    // Prints a row with lines separating columns dynamically based on column count
    public static void printRow(String[] columns, int columnCount) {
        if (columnCount == 3) {
            System.out.printf("| %-15s | %-15s | %-15s |%n", 
                              (columns.length > 0 ? columns[0] : ""), 
                              (columns.length > 1 ? columns[1] : ""), 
                              (columns.length > 2 ? columns[2] : ""));
        } else if (columnCount == 2) {
            System.out.printf("| %-15s | %-15s |%n", 
                              (columns.length > 0 ? columns[0] : ""), 
                              (columns.length > 1 ? columns[1] : ""));
        }
    }

    // Prints a header with a box-style format dynamically based on column count
    public static void printBoxHeader(String[] headers) {
        if (headers.length == 3) {
            String line = "+-----------------+-----------------+-----------------+";
            System.out.println(line); // Top border
            System.out.printf("| %-15s | %-15s | %-15s |%n", 
                              headers[0], 
                              headers[1], 
                              headers[2]);
            System.out.println(line); // Bottom border
        } else if (headers.length == 2) {
            String line = "+-----------------+-----------------+";
            System.out.println(line); // Top border
            System.out.printf("| %-15s | %-15s |%n", 
                              headers[0], 
                              headers[1]);
            System.out.println(line); // Bottom border
        }
    }

    // Prints a bottom line to close the table dynamically based on column count
    public static void printBottomLine(int columnCount) {
        StringBuilder line = new StringBuilder("+");
        for (int i = 0; i < columnCount; i++) {
            line.append("-----------------+");
        }
        System.out.println(line.toString());
    }

    public static void waitForTheUser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
