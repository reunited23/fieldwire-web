package pages.elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;

@AllArgsConstructor
public class TaskTable {

    private SelenideElement table;

    private ElementsCollection columns;

    public TaskTable(SelenideElement selenideElement){
        this.table = selenideElement;
        this.columns = table.$$(By.id("task-column-task-body"));
    }

    public boolean checkTaskInColumn(int columnNumber, String taskName){
        for (SelenideElement task : columns.get(columnNumber).$$(By.cssSelector("[data-e2e=\"task-name-ontaskpage\"]")).shouldBe(CollectionCondition.size(1))){
            if(taskName.equals(task.shouldBe(Condition.exist).getText())){
                return true;
            }
        }
        return false;
    }
}
