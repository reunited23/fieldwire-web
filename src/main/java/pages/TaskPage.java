package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.elements.TaskTable;

import static com.codeborne.selenide.Selenide.$;

public class TaskPage {

    private SelenideElement newTask = $(By.cssSelector("[data-e2e=\"create-new-task\"]"));

    private SelenideElement modalContent = $(By.className("modal-content"));

    private SelenideElement taskEditName = modalContent.$(By.cssSelector("[data-e2e=\"task-edit-name\"]"));

    private SelenideElement taskName = modalContent.$(By.cssSelector("[name=\"name\"]"));

    private SelenideElement taskNameCheck = modalContent.$(By.cssSelector("[data-e2e=\"task-edit-check\"]"));

    private SelenideElement status = modalContent.$(By.cssSelector("[translate=\"STATUS\"]"));

    private SelenideElement statusSelect = modalContent.$(By.cssSelector("[class=\"dropdown-menu pull-right text-left ng-scope\"]"));

    private ElementsCollection statuses = statusSelect.$$(By.tagName("li"));

    private SelenideElement closeModal = modalContent.$(By.cssSelector("[data-e2e=\"task-edit-dismiss\"]"));

    private TaskTable taskTable = new TaskTable($(By.className("task-columns-list")));

    public TaskPage clickNewTask(){
        newTask.click();
        return this;
    }

    public TaskPage clickTaskEditName(){
        taskEditName.click();
        return this;
    }

    public TaskPage setTaskName(String value){
        taskName.sendKeys(value);
        return this;
    }

    public TaskPage clickTaskNameCheck(){
        taskNameCheck.click();
        return this;
    }

    public TaskPage clickStatus(){
        status.click();
        return this;
    }

    public TaskPage selectStatus(String value){
        for (SelenideElement status : statuses){
            if(status.getText().equals(value)){
                status.click();
            }
        }
        return this;
    }

    public TaskPage clickClose(){
        closeModal.click();
        return this;
    }

    public boolean checkTaskInColumn(int columnNumber, String taskName){
        return taskTable.checkTaskInColumn(columnNumber, taskName);
    }
}
