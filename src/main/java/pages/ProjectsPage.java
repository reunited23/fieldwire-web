package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.elements.PhoneNumberContainer;
import pages.elements.ProjectCards;
import pages.sections.Header;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public Header header = new Header();

    private SelenideElement newProject = $(By.cssSelector("[translate=\"PLUS_NEW_PROJECT\"]"));

    private SelenideElement showArchived = $(By.cssSelector("[translate=\"SHOW_ARCHIVED\"]"));

    private ProjectCards projectsCard = new ProjectCards($$(By.className("project-card")));

    private SelenideElement projectName = $(By.cssSelector("[name=\"name\"]"));

    private SelenideElement projectCode = $(By.cssSelector("[name=\"code\"]"));

    private SelenideElement createProject = $(By.cssSelector("[ng-reflect-klass=\"fw-button\"]"));

    private SelenideElement selectFiles = $(By.cssSelector("[type=\"file\"]"));

    private SelenideElement next = $(By.cssSelector("[data-e2e=\"project-wizard-next-btn\"]"));

    private SelenideElement categoryName = $(By.cssSelector("[placeholder=\"Category name\"]"));

    private SelenideElement addCategory = $(By.cssSelector("[data-e2e=\"project-wizard-category-add-btn\"]"));

    private SelenideElement memdersEmail = $(By.cssSelector("[name=\"email\"]"));

    private SelenideElement memdersRoleSelect = $(By.cssSelector("[name=\"role\"]"));

    private SelenideElement inviteMember = $(By.cssSelector("[data-e2e=\"project-wizard-invite-btn\"]"));

    private PhoneNumberContainer phoneNumberContainer = new PhoneNumberContainer($(By.className("iti-container")));

    private SelenideElement textMeLink = $(By.cssSelector("[data-e2e=\"project-wizard-text-lnk-btn\"]"));

    public ProjectsPage clickNewProject(){
        newProject.shouldBe(Condition.visible).click();
        return this;
    }

    public ProjectsPage setProjectName(String value){
        projectName.shouldBe(Condition.visible).sendKeys(value);
        return this;
    }

    public ProjectsPage setProjectCode(String value){
        projectCode.shouldBe(Condition.visible).sendKeys(value);
        return this;
    }

    public ProjectsPage clickCreateProject(){
        createProject.shouldBe(Condition.visible).click();
        return this;
    }

    public boolean getCreateProjectIsDisable(){
        return Boolean.parseBoolean(createProject.getAttribute("aria-disabled"));
    }

    public ProjectsPage setFile(String value){
        selectFiles.uploadFile(new File(value));
        return this;
    }

    public ProjectsPage clickNext(){
        next.shouldBe(Condition.visible).click();
        return this;
    }

    public ProjectsPage setCategoryName(String value){
        categoryName.shouldBe(Condition.visible).sendKeys(value);
        return this;
    }

    public ProjectsPage clickAddCategory(){
        addCategory.shouldBe(Condition.visible).click();
        return this;
    }

    public ProjectsPage setMemdersEmail(String value){
        memdersEmail.shouldBe(Condition.visible).sendKeys(value);
        return this;
    }

    public ProjectsPage setMemdersRole(String value){
        memdersRoleSelect.shouldBe(Condition.visible).selectOption(value);
        return this;
    }

    public ProjectsPage clickInviteMember(){
        inviteMember.click();
        return this;
    }

    public ProjectsPage setPhone(String country, String phone){
        phoneNumberContainer.setFullPhone(country, phone);
        return this;
    }

    public ProjectsPage clickTextMeLink(){
        textMeLink.click();
        return this;
    }

    public void checkElements(){
        header.checkElements();
        Assert.assertTrue(newProject.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(showArchived.shouldBe(Condition.exist).isDisplayed());
    }

    public String getProjectCardName(int index){
        return projectsCard.getProjectCardName(index);
    }

    public String getProjectCardCode(int index){
        return projectsCard.getProjectCardCode(index);
    }
}