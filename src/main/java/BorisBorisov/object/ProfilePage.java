package BorisBorisov.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {

    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/";
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PAGE_URL));
    }
     public void userEditButton(){
        WebElement editButton = driver.findElement(By.xpath("//i[@class='fas fa-user-edit ng-star-inserted']"));
        editButton.click();



    }

    public void userEditField() {
        WebElement userEditField = driver.findElement(By.xpath("//input[@formcontrolname = 'username']"));
        userEditField.clear();
        userEditField.sendKeys("BorisBorisov");


    }

    public void userEditSave() {
        WebElement saveButton = driver.findElement(By.xpath("//button[@class = 'btn btn-primary']"));
        saveButton.click();
    }

    public int getPostCount() {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        return posts.size();
    }

    public void clickPost(int postIndex) {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        posts.get(postIndex).click();
    }
}



