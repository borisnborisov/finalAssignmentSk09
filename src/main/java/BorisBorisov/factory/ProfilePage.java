package BorisBorisov.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/";
    private final WebDriver driver;
    @FindBy(tagName = "h2")
    private WebElement username;
    @FindBy(tagName = "app-post")
    private WebElement posts;
    @FindBy(xpath = "//i[@class='fas fa-user-edit ng-star-inserted']")
    private WebElement editButton;
    @FindBy(xpath = "//input[@formcontrolname = 'username']")
    private WebElement userEditField;
    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    private WebElement saveButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUsername() {
        return username.getText();
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PAGE_URL));
    }

    public int getPostCount() {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        return posts.size();
    }

    public void clickPost(int postIndex) {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        posts.get(postIndex).click();
    }

    public void userEditButton() {
        editButton.click();


    }

    public void userEditField() {
        userEditField.clear();
        userEditField.sendKeys("BorisBorisov");


    }

    public void userEditSave() {
        saveButton.click();
    }
}
