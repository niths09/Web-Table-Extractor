# World Population Data Extraction  

This project automates the extraction of country-wise population data from the Worldometers website using Selenium WebDriver. The script captures key statistics, such as population, density, and urban population percentage and displays them in a tabular format in the console.  

## Features  
- **Automated Web Navigation**: Accesses the Worldometers Population by Country page programmatically.  
- **Dynamic Table Parsing**: Extracts data dynamically from an HTML table using Selenium.  
- **Data Columns Extracted**:  
  - Rank (No)  
  - Country  
  - Population  
  - Yearly Change  
  - Net Change  
  - Density  
  - Land Area  
  - Migrants  
  - Fertility Rate  
  - Median Age  
  - Urban Population (%)  
  - World Share  
- **Formatted Console Output**: Displays the extracted data in a neatly formatted table in the console.  
- **Smooth Scrolling**: Uses JavaScript Executor to scroll through the page for visibility of dynamic content.  

## Prerequisites  
Ensure the following are set up on your system:  
1. **Java Development Kit (JDK)** - Version 8 or above.  
2. **Selenium WebDriver** - Include the required Selenium libraries in your project.  
3. **Google Chrome** - Latest stable version.  
4. **ChromeDriver** - Ensure the ChromeDriver version matches your browser version.  
5. **Integrated Development Environment (IDE)** - Any IDE like IntelliJ IDEA or Eclipse for running Java programs.  

## Technologies Used  
- **Java** - The programming language used for the project.  
- **Selenium WebDriver** - For web automation and data extraction.  
- **Google Chrome & ChromeDriver** - To simulate browser-based interaction.  
- **JavaScript Executor** - For smooth scrolling through the web page.
