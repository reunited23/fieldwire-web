package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.elements.PhoneNumberContainer;

import static com.codeborne.selenide.Selenide.$;

public class CompanyInfoPage {

    private SelenideElement companyNameInput = $(By.id("company"));

    private SelenideElement companyTypeSelect = $(By.id("companyType"));

    private SelenideElement tradeTypeSelect = $(By.id("tradeType"));

    private SelenideElement companySizeSelect = $(By.id("companySize"));

    private PhoneNumberContainer phoneNumberContainer = new PhoneNumberContainer($(By.className("intl-phone-number-container")));

    private SelenideElement completeButton = $(By.cssSelector("[data-e2e=\"create-account-complete\"]"));

    public CompanyInfoPage setCompanyNameInput(String value){
        companyNameInput.sendKeys(value);
        return this;
    }

    public CompanyInfoPage setCompanyTypeSelect(String value){
        companyTypeSelect.selectOption(value);
        return this;
    }

    public CompanyInfoPage setCompanySizeSelect(String value){
        companySizeSelect.selectOption(value);
        return this;
    }

    public CompanyInfoPage setTradeTypeSelect(String value){
        tradeTypeSelect.selectOption(value);
        return this;
    }

    public boolean checkTradeTypeSelect(){
        return tradeTypeSelect.exists();
    }

    public CompanyInfoPage setPhone(String country, String phone){
        phoneNumberContainer.setFullPhone(country, phone);
        return this;
    }

    public CompanyInfoPage clickCompleteButton(){
        completeButton.click();
        return this;
    }
}
