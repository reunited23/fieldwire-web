import com.codeborne.selenide.Selenide;
import flow_services.ProjectService;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import pages.TaskPage;

public class TaskSuccessTest extends BaseUiTest {

    private ProjectService projectService = new ProjectService();

    private ProjectPage projectPage = Selenide.page(ProjectPage.class);

    private TaskPage taskPage = Selenide.page(TaskPage.class);

    private String taskName = "TaskName";

    private String priority = "Priority 1";

    @Test
    public void createTaskWithPriority() {
        projectService.createProject(false);
        projectPage.projectSideBar.clickTasks();
        taskPage.clickNewTask().clickTaskEditName()
                .setTaskName(taskName).clickTaskNameCheck()
                .clickStatus()
                .selectStatus(priority).clickClose();
        Assert.assertTrue(taskPage.checkTaskInColumn(1, taskName));
    }

    @Test
    public void createTaskWithDefaultPriority() {
        projectService.createProject(false);
        projectPage.projectSideBar.clickTasks();
        taskPage.clickNewTask().clickTaskEditName()
                .setTaskName(taskName).clickTaskNameCheck()
                .clickClose();
        Assert.assertTrue(taskPage.checkTaskInColumn(2, taskName));
    }
}
