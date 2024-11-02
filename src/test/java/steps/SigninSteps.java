package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import org.hint.PageObject.SigninPage;

public class SigninSteps {
    private final WebDriver driver = Hooks.driver;
    SigninPage signinPage = new SigninPage(driver);

    @Given("open hint official website")
    public void openHintWebsite(){

    }

    @When("closes the popup banner")
    public void closesPopupBanner() {
        signinPage.closePopupBanner();
    }

    @And("click the profile icon")
    public void clickProfileIcon() {
        signinPage.clickProfileIcon();
    }

    @And("input valid email")
    public void inputValidEmail() {
        signinPage.inputEmail();
    }

    @And("input valid password")
    public void inputValidPassword() {
        signinPage.inputPassword();
    }

    @And("click sign in button")
    public void clickSignInButton() {
        signinPage.clickSignInButton();
    }

    @Then("profile icon change to profile login icon")
    public void profileIconChangeToProfileLoginIcon() {
        assert signinPage.isProfileLoginIconDisplayed() : "Profile login icon not displayed!";
    }
}
