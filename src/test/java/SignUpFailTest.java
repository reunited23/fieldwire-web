import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.SingnUpPage;

public class SignUpFailTest extends BaseUiTest {

    private SignInPage signInPage = Selenide.page(SignInPage.class);

    private SingnUpPage singnUpPage = Selenide.page(SingnUpPage.class);

    private String invalidEmailMessage = "Invalid email";

    @Test
    public void invalidEmail(){
        Selenide.open(Configuration.baseUrl);
        signInPage.clickSignUpLink();
        singnUpPage.setEmailInput("email");
        Assert.assertEquals(invalidEmailMessage, singnUpPage.getValidationEmailMessage());
    }

    @Test
    public void emptyEmail(){
        Selenide.open(Configuration.baseUrl);
        signInPage.clickSignUpLink();
        singnUpPage.setEmailInput("");
        Assert.assertTrue(singnUpPage.createAccountButtonIsDisabled());
    }

    @Test
    public void checkDisableCreateButton(){
        Selenide.open(Configuration.baseUrl);
        signInPage.clickSignUpLink();
        Assert.assertTrue(singnUpPage.createAccountButtonIsDisabled());
        singnUpPage.clickExplicitAgreement();
        Assert.assertFalse(singnUpPage.createAccountButtonIsDisabled());
        singnUpPage.clickExplicitAgreement();
        Assert.assertTrue(singnUpPage.createAccountButtonIsDisabled());
    }
}
