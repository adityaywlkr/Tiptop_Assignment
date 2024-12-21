package com.tiptop_Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FormPage {
    WebDriver driver;

    // Constructor
    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // Locators with @FindBy annotations
    @FindBy(xpath = ".//input[@name='my-disabled']")
    private WebElement disabledInput;

    @FindBy(xpath = ".//input[@value='Readonly input']")
    private WebElement readonlyInput1;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    private WebElement readonlyInput2;

    @FindBy(xpath = "//select[@name='my-select']")
	public WebElement colorDropdown1;

    @FindBy(xpath = "//select[@class = 'form-select']")
	public WebElement colorDropdown2;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='my-name-id']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='my-password-id']")
    private WebElement passwordField;

    @FindBy(xpath = "//p[@id='message']")
    private WebElement receivedText;

    // Actions/Methods

    public WebElement getDisabledInput() {
        return disabledInput;
    }

    public WebElement getReadonlyInput1() {
        return readonlyInput1;
    }
    
    public WebElement getReadonlyInput2() {
        return readonlyInput2;
    }

    public WebElement getColorDropdown1() {
        return colorDropdown1;
    }
    
    public WebElement getColorDropdown2() {
        return colorDropdown2;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }
    public String getRecivedmsg() {
        String msg = receivedText.getText();
		return msg;
    }
    public String gettesturlContainsformData() {
    	String currentUrl = driver.getCurrentUrl();
        // Wait for URL to contain form data
        Assert.assertTrue(currentUrl.contains("name=Test+Name"), "Name data is not passed in the URL.");
        Assert.assertTrue(currentUrl.contains("password=TestPassword"), "Password data is not passed in the URL.");
		return currentUrl;
    }
}
