package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage{

    private SelenideElement email = $(By.id("email-input"));

    private SelenideElement password = $(By.id("password-input"));

    private SelenideElement nextButton = $(By.cssSelector("[data-e2e=\"login-email\"]"));

    private SelenideElement logInButton = $(By.cssSelector("[ng-reflect-klass=\"fw-button\"]"));

    private SelenideElement accountLockedLink = $(By.cssSelector("[translate=\"ACCOUNT_LOCKED\"]"));

    private SelenideElement signUpLink = $(By.cssSelector("[ui-sref=\"auth.register\"]"));

    public SignInPage setEmailInput(String value){
        email.sendKeys(value);
        return this;
    }

    public SignInPage setPasswordInput(String value){
        password.sendKeys(value);
        return this;
    }

    public SignInPage clickNextButton(){
        nextButton.click();
        return this;
    }

    public SignInPage clickLogInButton(){
        logInButton.click();
        return this;
    }

    public boolean checkNextButtonState(){
        return nextButton.is(Condition.disabled);
    }

    public SignInPage clickAccountLockedLink(){
        accountLockedLink.click();
        return this;
    }

    public SignInPage clickSignUpLink(){
        signUpLink.click();
        return this;
    }

}
