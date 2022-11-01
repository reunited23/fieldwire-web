import com.codeborne.selenide.Selenide;
import flow_services.SignUpService;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectsPage;

public class ProjectFailTest extends BaseUiTest {

    private SignUpService signUpService = new SignUpService();

    private ProjectsPage projectsPage = Selenide.page(ProjectsPage.class);

    @Test
    public void createProjectEmptyName() {
        signUpService.successSignUp(false);
        projectsPage.clickNewProject()
                .setProjectName("  ");
        Assert.assertTrue(projectsPage.getCreateProjectIsDisable());
    }

    @Test
    public void createProjectSpecialSymbols() {
        signUpService.successSignUp(false);
        projectsPage.clickNewProject()
                .setProjectName("!@#$%^&*");
        Assert.assertTrue(projectsPage.getCreateProjectIsDisable());
    }
}
