# Sensex Table Extraction  

This project automates the extraction of data from the Indian Indices table on the MoneyControl website. The extracted data provides insights into NIFTY 50 market trends, including real-time values such as the Last Traded Price (LTP), percentage change, volume and more. The data is displayed in a neatly formatted table in the console.  

## Features  

### Indian Indices Extraction  
- Extracts live data from the **Indian Indices - NIFTY 50** table on the MoneyControl website.  
- Columns extracted include:  
  - **Name**: Name of the stock or index.  
  - **LTP**: Last traded price.  
  - **%Chg**: Percentage change in price.  
  - **Chg**: Change in price.  
  - **Volume**: Total trading volume.  
  - **Buy Price**: Current buy price.  
  - **Sell Price**: Current sell price.  
  - **Buy Qty**: Quantity available for buying.  
  - **Sell Qty**: Quantity available for selling.  
  - **Analysis**: Additional analysis details.  

### Console Output  
- Displays the extracted data in a visually formatted table with proper alignment and separators for easy readability.  

### Scroll Functionality  
- Uses JavaScript Executor to scroll the webpage to ensure that the dynamic content is fully loaded before extraction.  

## Pre-requisites  

Before running this project, ensure the following are installed:  
1. **Java Development Kit (JDK)** - Version 8 or higher.  
2. **Selenium WebDriver** - Include Selenium libraries in your project.  
3. **Google Chrome** - Latest version of the Chrome browser.  
4. **ChromeDriver** - Ensure the ChromeDriver version matches your Chrome browser.  
5. **Integrated Development Environment (IDE)** - IntelliJ IDEA, Eclipse, or any other IDE for Java development.  

## Technologies Used  

- **Java** - Programming language used for development.  
- **Selenium WebDriver** - To interact with and extract data from the MoneyControl website.  
- **Google Chrome & ChromeDriver** - For browsing and interacting with the webpage.  
- **JavaScript Executor** - For scrolling functionality.  
