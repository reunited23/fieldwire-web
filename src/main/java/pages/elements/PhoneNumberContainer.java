package pages.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class PhoneNumberContainer {

    private SelenideElement callDropDown;

    private SelenideElement countryList;

    private SelenideElement phoneNumberInput;

    public PhoneNumberContainer(SelenideElement selenideElement){
        this.callDropDown = selenideElement.$(By.className("iti__flag-container"));
        this.countryList = selenideElement.$(By.className("iti__country-list"));
        this.phoneNumberInput = selenideElement.$(By.id("phone"));
    }

    public void setFullPhone(String country, String phone){
        callDropDown.click();
        selectCountry(country);
        phoneNumberInput.setValue(phone);
    }

    private void selectCountry(String country){
        for(SelenideElement selenideElement : countryList.$$(By.tagName("li"))){
            if(selenideElement.$(By.className("iti__country-name")).getText().equals(country)){
                selenideElement.click();
                return;
            }
        }
    }
}
