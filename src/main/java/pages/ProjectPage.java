package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import pages.sections.ProjectSideBar;

import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage {

    public ProjectSideBar projectSideBar = new ProjectSideBar();

    public ElementsCollection files = $$(By.className("floorplan-label"));

    public boolean checkFile(String fileName){
        for (SelenideElement file : files.shouldBe(CollectionCondition.size(1))){
            if(file.getText().equals(fileName + "\n" +
                    "Processing")){
                return true;
            }
        }
        return false;
    }
}
