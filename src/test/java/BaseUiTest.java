import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Browsers.*;

public class BaseUiTest {

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://staging.fieldwire.com";
        Configuration.headless = false;
        if(browser.equalsIgnoreCase("edge")){

            Configuration.browser = EDGE;
        }
        else if(browser.equalsIgnoreCase("chrome")){
            Configuration.browser = CHROME;
        }
        else{
            throw new Exception("Browser is not correct");
        }
        Configuration.timeout =30000;
    }

    @AfterMethod
    public void after() {
        Selenide.closeWebDriver();
    }
}
