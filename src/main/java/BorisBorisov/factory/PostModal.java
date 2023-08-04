package BorisBorisov.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostModal {

    private final WebDriver driver;
    private final WebElement modalElement;
    @FindBy(css =".post-modal-img img" )
    private WebElement image;
    @FindBy(className = "post-title")
    private WebElement postTitle;
    @FindBy(className = "post-user")
    private WebElement postUser;
    @FindBy(xpath = "//label[@class='delete-ask']")
    private WebElement deletePost;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement confirmDelete;
    @FindBy(xpath = "//i[@class='fas fa-lock ng-star-inserted']")
    private WebElement privatePost;

    public PostModal(WebDriver driver) {
        this.driver = driver;
        this.modalElement = driver.findElement(By.className("post-modal"));
        PageFactory.initElements(driver, this);
    }

    public boolean isImageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPostTitle() {
        return postTitle.getText();
    }

    public String getPostUser() {
        return postUser.getText();
    }

    public void deletePost() {
        deletePost.click();
    }

    public void confirmDelete() {
        confirmDelete.click();
    }

    public void privatePost() {
        privatePost.click();
    }
}


