package pages.sections;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectSideBar {

    private SelenideElement sideBar = $(By.id("sidebar-wrapper"));

    private SelenideElement dropDown = sideBar.$(By.className("dropdown"));

    private SelenideElement home = dropDown.$(By.cssSelector("[translate=\"HOME\"]"));

    private SelenideElement sidebarNav = sideBar.$(By.className("sidebar-nav"));

    private SelenideElement plans = sidebarNav.$$(By.tagName("li")).get(0);

    private SelenideElement specifications = sidebarNav.$$(By.tagName("li")).get(1);

    private SelenideElement tasks = $(By.cssSelector("[translate=\"TASKS\"]"));

    private SelenideElement photos = sidebarNav.$$(By.tagName("li")).get(3);

    private SelenideElement forms = sidebarNav.$$(By.tagName("li")).get(4);

    private SelenideElement files = sidebarNav.$$(By.tagName("li")).get(5);

    public ProjectSideBar clickDropDown(){
        dropDown.click();
        return this;
    }

    public String getDropDownText(){
       return dropDown.getText();
    }

    public ProjectSideBar clickHome(){
        home.click();
        return this;
    }

    public ProjectSideBar clickPlans(){
        plans.click();
        return this;
    }

    public ProjectSideBar clickSpecifications(){
        specifications.click();
        return this;
    }

    public ProjectSideBar clickTasks(){
        tasks.click();
        return this;
    }

    public ProjectSideBar clickPhotos(){
        photos.click();
        return this;
    }

    public ProjectSideBar clickForms(){
        forms.click();
        return this;
    }

    public ProjectSideBar clickFiles(){
        files.click();
        return this;
    }
}
