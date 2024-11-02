package org.hint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int WAIT = 50; // Wait for 30

    // Constructor to initialize WebDriver and WebDriverWait
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize page elements
    }

    // Common method to navigate to a URL
    public void navigateTo(String url){
        driver.get(url);
    }

    // Click on an element
    public void click(WebElement element) {
        waitForElementVisible(element);
        waitForElementClickable(element);
        element.click();
    }

    // Double-click on an element
    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        waitForElementVisible(element);
        actions.doubleClick(element).perform();
    }

    // Type text into an element
    public void type(WebElement element, String text) {
        waitForElementVisible(element);
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    // Assert if element is present (can also handle stale elements)
    public boolean assertElementPresent(WebElement element) {
        try {
            waitForElementVisible(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    // Assert if element's text is as expected
    public boolean assertText(WebElement element, String expectedText) {
        waitForElementVisible(element);
        String actualText = element.getText();
        return actualText.equals(expectedText);
    }

    // Wait for element to be visible
    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for element to be clickable
    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Fungsi forLoading untuk menunggu elemen loading hilang
    public void forLoading(WebElement loadingElement) {
        wait.until(ExpectedConditions.invisibilityOf(loadingElement));
    }
}
