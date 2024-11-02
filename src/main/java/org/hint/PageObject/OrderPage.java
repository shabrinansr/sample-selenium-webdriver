package org.hint.PageObject;
import org.hint.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {
    // Constructor to initialize the page elements
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    private static final String BASE_URL = "https://www.hintofyou.com/en/product/detail/";

    //Define URL
    private static String Product_Single = BASE_URL + "hint-mintea-eau-de-parfum";

    // Define locators using @FindBy annotation
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Add to Bag'])[1]")  // Update with the actual ID
    private WebElement aadToBag;
    @FindBy(xpath = "(//span[@class='i'])[1]")  // Update with the actual ID
    private WebElement iconCart;
    @FindBy(xpath = "(//a[normalize-space()='Checkout'])[1]")  // Update with the actual ID
    private WebElement buttonCheckout;
    @FindBy(xpath = "(//button[@class='btn btn-block btn-primary btn-checkout btn-custom-bag'][normalize-space()='Next Step'])[1]")
    // Update with the actual ID
    private WebElement buttonNextStep;
    @FindBy(xpath = "(//div[contains(text(),'Virtual Account BCA')])[1]")  // Update with the actual ID
    private WebElement bcaVirtualAcc;
    @FindBy(xpath = "(//button[@class='btn btn-block btn-primary btn-checkout btn-custom-bag'])[1]")
    // Update with the actual ID
    private WebElement buttonPlaceOrder;
    @FindBy(xpath = "(//div[@class='cart-detail text-lg2'])[1]")  // Update with the actual ID
    private WebElement completeYourPayment;
    @FindBy(xpath = "(//div[contains(text(),'ORDER ID')])[1]")  // Update with the actual ID
    private WebElement orderId;
    @FindBy(xpath = "(//u[contains(text(),'Change')])[1]")  // Update with the actual ID
    private WebElement waitChange;

    // Step definitions for Gherkin steps
    public void openProductSingleURL() {
        driver.get(Product_Single);
    }

    public void clickAddToBag() {
        click(aadToBag);
    }

    public void clickIconCart() {
        click(iconCart);
    }

    public void clickCheckout() {
        click(buttonCheckout);
    }

    public void clickNextStep() {
        click(buttonNextStep);
        waitForElementClickable(bcaVirtualAcc);
    }

    public void clickNextStep2(){
        click(buttonNextStep);
        waitForElementClickable(waitChange);
    }

    public void clickPayment() {
        click(bcaVirtualAcc);
    }

    public void clickPlaceOrder() {
        click(buttonPlaceOrder);
    }

    public boolean isOrderIdTextCorrect() {
        // Assert text for "ORDER ID"
        return assertText(orderId, "ORDER ID");
    }
}
