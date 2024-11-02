package org.hint.PageObject;
import org.hint.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.AssertJUnit.assertTrue;

public class SignInPage extends BasePage {

    // Constructor to initialize the page elements
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    // Define locators using @FindBy annotation
    @FindBy(xpath = "(//div[@id='close-button-1454703513202'])[1]")  // Update with the actual ID
    private WebElement popupBannerClose;

    @FindBy(xpath = "(//button[@type='button'])[2]")  // Update with the actual ID
    private WebElement profileIcon;

    @FindBy(xpath = "(//input[@placeholder='Email Address'])[1]")  // Update with the actual ID
    private WebElement emailInput;

    @FindBy(xpath = "(//input[@placeholder='Password'])[1]")  // Update with the actual ID
    private WebElement passwordInput;

    @FindBy(xpath = "(//button[normalize-space()='Login'])[1]")  // Update with the actual ID
    private WebElement signInButton;

    @FindBy(className = "(//button[@class='btn btn-icon-login'])[1]")  // Update with the actual ID
    private WebElement profileLoginIcon;

    // Step definitions for Gherkin steps

    // Opens the hint official website (assuming this is done elsewhere)

    // Closes the popup banner
    public void closePopupBanner() {
        click(popupBannerClose);
    }

    // Click the profile icon
    public void clickProfileIcon() {
        click(profileIcon);
    }

    // Input valid email
    public void inputEmail() {
        type(emailInput, "shabrina.shabrina@beautyhaul.com");
    }

    // Input valid password
    public void inputPassword() {
        type(passwordInput, "Beautyhaul12");
    }

    // Click sign in button
    public void clickSignInButton() {
        click(signInButton);
    }

    // Assert profile icon changes to profile login icon
    public boolean isProfileLoginIconDisplayed() {
        return assertElementPresent(profileLoginIcon);
    }
}
