package flow_services;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import enams.CompanySize;
import enams.CompanyType;
import enams.Country;
import enams.TradeType;
import org.testng.Assert;
import pages.CompanyInfoPage;
import pages.SignInPage;
import pages.SingnUpPage;
import pojo.CompanyInfo;
import pojo.UserInfo;

public class SignUpService {

    private SignInPage signInPage = Selenide.page(SignInPage.class);

    private SingnUpPage singnUpPage = Selenide.page(SingnUpPage.class);

    private CompanyInfoPage companyInfoPage = Selenide.page(CompanyInfoPage.class);

    private Faker faker = new Faker();

    private String email = "@ggmal.com";

    private String password = "ZXCV123bnm";

    public UserInfo successSignUp(boolean typeSpecialtyContractor){
        UserInfo user = getUserInfo();
        CompanyInfo company = getCompanyInfo();
        Selenide.open(Configuration.baseUrl);
        signInPage.clickSignUpLink();
        singnUpPage.setEmailInput(user.getEmail())
                .setFirstNameInput(user.getFirstName())
                .setLastNameInput(user.getLastName())
                .setPasswordInput(user.getPassword())
                .clickExplicitAgreement()
                .clickCreateAccountButton();
        if(typeSpecialtyContractor) {
            companyInfoPage.setCompanyNameInput(company.getName())
                    .setCompanyTypeSelect(CompanyType.SPECIALTY_CONTRACTOR.getName());
            Assert.assertTrue(companyInfoPage.checkTradeTypeSelect());
            companyInfoPage.setTradeTypeSelect(company.getTradeType());
        }else{
            companyInfoPage.setCompanyNameInput(company.getName())
                    .setCompanyTypeSelect(company.getType());
            Assert.assertFalse(companyInfoPage.checkTradeTypeSelect());
        }
        companyInfoPage.setCompanySizeSelect(company.getSize())
                .setPhone(company.getPhoneCountry(), company.getPhoneNumber())
                .clickCompleteButton();
        return user;
    }

    private UserInfo getUserInfo(){
        return new UserInfo(faker.name().username() + email,
                faker.name().firstName(),
                faker.name().lastName(),
                password);
    }

    private CompanyInfo getCompanyInfo(){
        return new CompanyInfo(faker.name().name(),
                CompanyType.OTHER.getName(),
                TradeType.CONCRETE.getName(),
                CompanySize.SMALL.getName(),
                Country.USA.getName(), "(201)555-" + faker.phoneNumber().subscriberNumber(4));
    }
}
