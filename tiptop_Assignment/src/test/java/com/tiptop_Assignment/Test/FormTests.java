package com.tiptop_Assignment.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tiptop_Assignment.Pages.FormPage;

public class FormTests {
	WebDriver driver;
	FormPage formPage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://d3pv22lioo8876.cloudfront.net/tiptop/");
		formPage = new FormPage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Test Case 1: Verify that the text input element with xpath
	// .//input[@name='my-disabled'] is disabled in the form
	@Test
	public void testDisabledInput() {
		Assert.assertFalse(formPage.getDisabledInput().isEnabled(), "Disabled input is not disabled.");
	}

	// Test Case 2: Verify that the text input with value 'Readonly input' is in
	// readonly state by using 2 xpaths
	@Test
	public void testReadonlyInput1() {
		Assert.assertTrue(formPage.getReadonlyInput1().getAttribute("readonly").equals("true"),
				"Readonly input is not readonly.");
	}

	// Test Case 3: Verify that the dropdown field to select color is having 8
	// elements using 2 xpaths
	@Test
	public void testDropdownElements1() {
		int optionsCount = formPage.getColorDropdown1().findElements(By.tagName("option")).size();
		Assert.assertEquals(optionsCount, 8, "Dropdown does not have 8 elements.");
	}

	// Test Case 4: Verify that the text input with value 'Readonly input' is in
	// readonly state by using 2 xpaths
	@Test
	public void testReadonlyInput2() {
		Assert.assertTrue(formPage.getReadonlyInput2().getAttribute("readonly").equals("true"),
				"Readonly input is not readonly.");
	}

	// Test Case 5: Verify that the dropdown field to select color is having 8
	// elements using 2 xpaths
	@Test
	public void testDropdownElements2() {
		int optionsCount = formPage.getColorDropdown2().findElements(By.tagName("option")).size();
		Assert.assertEquals(optionsCount, 8, "Dropdown does not have 8 elements.");
	}

	// Test Case 6: Verify that the submit button is disabled when no data is
	// entered in Name field
	@Test
	public void testSubmitDisabledNoData() {
		formPage.getNameField().clear(); // Ensure Name field is empty
		Assert.assertFalse(formPage.getSubmitButton().isEnabled(), "Submit button is enabled without Name input.");
	}

	// Test Case 7: Verify that the submit button is enabled when both Name and
	// Password field are entered
	@Test
	public void testSubmitEnabledWithData() {
		formPage.getNameField().clear();
		formPage.getNameField().sendKeys("Test Name");
		formPage.getPasswordField().clear();
		formPage.getPasswordField().sendKeys("TestPassword");

		Assert.assertTrue(formPage.getSubmitButton().isEnabled(),
				"Submit button is not enabled when both fields are filled.");
	}

	// Test Case 8: Verify that on submit of 'Submit' button the page shows
	// 'Received' text
	@Test
	public void testSubmitShowsReceivedText() {

		formPage.getSubmitButton().click();

		// Verify 'Received' text is shown after form submission
		Assert.assertTrue(formPage.getRecivedmsg().contains("Received"), "'Received' text is not displayed.");

	}
	// Test Case 9: Verify that on submit of form all the data passed to the URL

	@Test
	public void testUrlContainsFormData() {
		formPage.gettesturlContainsformData();
	}
}
