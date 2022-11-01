package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SingnUpPage {

    private SelenideElement firstNameInput = $(By.id("firstNameInput"));

    private SelenideElement lastNameInput = $(By.id("lastNameInput"));

    private SelenideElement emailInput = $(By.id("emailInput"));

    private SelenideElement passwordInput = $(By.id("passwordInput"));

    private SelenideElement explicitAgreement = $(By.id("explicitAgreement"));

    private SelenideElement createAccountButton = $(By.cssSelector("[ng-reflect-klass=\"fw-button\"]"));

    private SelenideElement logInLink = $(By.cssSelector("[ui-sref=\"auth.sign_in\"]"));

    public SingnUpPage setFirstNameInput(String value){
        firstNameInput.sendKeys(value);
        return this;
    }

    public SingnUpPage setLastNameInput(String value){
        lastNameInput.sendKeys(value);
        return this;
    }

    public SingnUpPage setEmailInput(String value){
        emailInput.sendKeys(value);
        return this;
    }

    public String getValidationEmailMessage(){
        return emailInput.getAttribute("validationMessage");
    }

    public SingnUpPage setPasswordInput(String value){
        passwordInput.sendKeys(value);
        return this;
    }

    public SingnUpPage clickExplicitAgreement(){
        explicitAgreement.click();
        return this;
    }

    public SingnUpPage clickCreateAccountButton(){
        createAccountButton.click();
        return this;
    }

    public boolean createAccountButtonIsDisabled(){
        return Boolean.parseBoolean(createAccountButton.getAttribute("aria-disabled"));
    }

    public SingnUpPage clickLogInLink(){
        logInLink.click();
        return this;
    }

}
