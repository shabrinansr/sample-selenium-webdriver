package steps;

import io.cucumber.java.bs.A;
import org.hint.PageObject.OrderPage;
import io.cucumber.java.en.*;
import org.hint.PageObject.SigninPage;
import org.openqa.selenium.WebDriver;
import hooks.Hooks;


public class OrderSteps {
    private final WebDriver driver = Hooks.driver;
    OrderPage orderPage = new OrderPage(driver);
    SigninPage signinPage = new SigninPage(driver);

    @Given("User sign in")
    public void userSignin() {
        signinPage.closePopupBanner();
        signinPage.clickProfileIcon();
        signinPage.inputEmail();
        signinPage.inputPassword();
        signinPage.clickSignInButton();
        signinPage.isProfileLoginIconDisplayed();
    }

    @When("User open product detail")
    public void openProductSingleURL(){
        orderPage.openProductSingleURL();
    }

    @And("Checkout product")
    public void checkoutProduct(){
        orderPage.clickAddToBag();
        orderPage.clickIconCart();
        orderPage.clickCheckout();
    }

    @And("Complete Order")
    public void completeOrder(){
        orderPage.clickNextStep();
        orderPage.clickNextStep2();
        orderPage.clickPlaceOrder();
    }

    @Then("User get order id")
    public void verifyOrderIdText() {
        boolean isOrderIdTextCorrect = orderPage.isOrderIdTextCorrect();
        assert isOrderIdTextCorrect : "Text 'ORDER ID' is not displayed correctly.";
    }

}
