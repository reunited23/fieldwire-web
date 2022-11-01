package pages.sections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement header = $(By.className("navbar-header"));

    private SelenideElement projects = header.$(By.cssSelector("[translate=\"PROJECTS\"]"));

    private SelenideElement people = header.$(By.cssSelector("[translate=\"PEOPLE\"]"));

    private SelenideElement account = header.$(By.cssSelector("[translate=\"ACCOUNT\"]"));

    private SelenideElement templates = header.$(By.cssSelector("[translate=\"TEMPLATES\"]"));

    private SelenideElement tutorials = header.$(By.cssSelector("[translate=\"TUTORIALS\"]"));

    private SelenideElement bell = header.$(By.cssSelector("[class=\"fa fa-bell fa-lg\"]"));

    private SelenideElement question = header.$(By.cssSelector("[class=\"question-mark-icon light pointer\"]"));

    private SelenideElement upgradeInfo = header.$(By.cssSelector("[class=\"pointer upgrade-info\"]"));

    private SelenideElement profileMenu = header.$(By.cssSelector("[data-e2e=\"profile-menu\"]"));

    public String getProfileMenuText(){
        return profileMenu.getText();
    }

    public void checkElements(){
        Assert.assertTrue(projects.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(people.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(account.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(templates.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(tutorials.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(bell.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(question.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(upgradeInfo.shouldBe(Condition.exist).isDisplayed());
        Assert.assertTrue(profileMenu.shouldBe(Condition.exist).isDisplayed());
    }
}
