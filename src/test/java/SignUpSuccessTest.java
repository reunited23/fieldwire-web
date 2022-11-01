import com.codeborne.selenide.Selenide;
import flow_services.SignUpService;
import org.testng.annotations.Test;
import pages.ProjectsPage;

public class SignUpSuccessTest extends BaseUiTest {

    private SignUpService signUpService = new SignUpService();

    private ProjectsPage projectsPage = Selenide.page(ProjectsPage.class);

    @Test
    public void successSignUp(){
        signUpService.successSignUp(false);
        projectsPage.checkElements();
    }

    @Test
    public void successSignUpWithSpecialtyContractor(){
        signUpService.successSignUp(true);
        projectsPage.checkElements();
    }

}
