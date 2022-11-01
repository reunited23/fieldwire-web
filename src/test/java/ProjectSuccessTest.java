import com.codeborne.selenide.Selenide;
import flow_services.ProjectService;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import pages.ProjectsPage;
import pojo.ProjectInfo;

public class ProjectSuccessTest extends BaseUiTest {

    private ProjectService projectService = new ProjectService();

    private ProjectsPage projectsPage = Selenide.page(ProjectsPage.class);

    private ProjectPage projectPage = Selenide.page(ProjectPage.class);

    @Test
    public void createProject(){
        ProjectInfo projectInfo = projectService.createProject(false);
        projectPage.projectSideBar.clickDropDown()
                .clickHome();
        Assert.assertEquals(projectsPage.getProjectCardName(0), projectInfo.getName());
        Assert.assertEquals(projectsPage.getProjectCardCode(0), projectInfo.getCode());
    }

    @Test
    public void createProjectWithFile(){
        ProjectInfo projectInfo = projectService.createProject(true);
        Assert.assertTrue(projectPage.checkFile(projectInfo.getFileName()));
        projectPage.projectSideBar.clickDropDown()
                .clickHome();
        Assert.assertEquals( projectsPage.getProjectCardName(0), projectInfo.getName());
        Assert.assertEquals(projectsPage.getProjectCardCode(0), projectInfo.getCode());
    }

    @Test
    public void createProjectWithCategory(){
        ProjectInfo projectInfo = projectService.createProjectWithCategory();
        projectPage.projectSideBar.clickDropDown()
                .clickHome();
        Assert.assertEquals(projectsPage.getProjectCardName(0), projectInfo.getName());
        Assert.assertEquals(projectsPage.getProjectCardCode(0), projectInfo.getCode());
    }
}
