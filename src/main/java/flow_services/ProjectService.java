package flow_services;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import pages.ProjectsPage;
import pojo.ProjectInfo;

public class ProjectService {

    private SignUpService signUpService = new SignUpService();

    private ProjectsPage projectsPage = Selenide.page(ProjectsPage.class);

    private Faker faker = new Faker();

    private String projectCode = "123";

    private String fileName = "image111.jpeg";

    public ProjectInfo createProject(boolean withFile){
        ProjectInfo projectInfo = new ProjectInfo(faker.name().title(), projectCode,null, fileName);
        signUpService.successSignUp(false);
        projectsPage.clickNewProject()
                .setProjectName(projectInfo.getName()).setProjectCode(projectInfo.getCode()).clickCreateProject();
        if(!withFile) {
            projectsPage.clickNext().clickNext().clickNext().clickNext();
        }else {
            projectsPage.setFile(projectInfo.getFileName())
                    .clickNext().clickNext().clickNext().clickNext();
        }
        return projectInfo;
    }

    public ProjectInfo createProjectWithCategory(){
        ProjectInfo projectInfo = new ProjectInfo(faker.name().name(), projectCode, faker.name().name(), fileName);
        signUpService.successSignUp(false);
        projectsPage.clickNewProject()
                .setProjectName(projectInfo.getName()).setProjectCode(projectInfo.getCode()).clickCreateProject()
                .clickNext()
                .setCategoryName(projectInfo.getCategoryName()).clickAddCategory().clickNext()
                .clickNext().clickNext();
        return projectInfo;
    }
}
