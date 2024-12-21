package com.tiptop_Assignment.utility;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseTest {

	    protected WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	    	System.setProperty("webdriver.chrome.driver",
	    			 System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe");
	    	        WebDriver driver = new ChromeDriver();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");  // Optional: Run tests in headless mode
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }


}
