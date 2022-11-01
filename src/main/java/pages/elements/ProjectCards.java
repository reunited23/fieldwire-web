package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;


@AllArgsConstructor
public class ProjectCards {

    private ElementsCollection projectsCard;

    public String getProjectCardName(int index){
        return projectsCard.get(index).$(By.cssSelector("[class=\"project-name truncate\"]")).getText();
    }

    public String getProjectCardCode(int index){
        return projectsCard.get(index).$(By.cssSelector("[class=\"project-code truncate ng-star-inserted\"]")).getText();
    }
}
