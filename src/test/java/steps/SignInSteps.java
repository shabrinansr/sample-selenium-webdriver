package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import org.hint.PageObject.SignInPage;

public class SignInSteps {
    private final WebDriver driver = Hooks.driver;
    SignInPage signInPage= new SignInPage(driver);

    @Given("open hint official website")
    public void openHintWebsite(){

    }

    @When("closes the popup banner")
    public void closesPopupBanner() {
        signInPage.closePopupBanner();
    }

    @And("click the profile icon")
    public void clickProfileIcon() {
        signInPage.clickProfileIcon();
    }

    @And("input valid email")
    public void inputValidEmail() {
        signInPage.inputEmail();
    }

    @And("input valid password")
    public void inputValidPassword() {
        signInPage.inputPassword();
    }

    @And("click sign in button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("profile icon change to profile login icon")
    public void profileIconChangeToProfileLoginIcon() {
        assert signInPage.isProfileLoginIconDisplayed() : "Profile login icon not displayed!";
    }
}
