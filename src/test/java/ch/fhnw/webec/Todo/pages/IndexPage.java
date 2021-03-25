package ch.fhnw.webec.Todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Struktur dieses Codes wurde vom Projekt Contact List übernommen und angepasst.
// EXTERNAL: https://github.com/WebEngineering-FHNW/contact-list-security-netopyr-1/blob/master/src/test/java/ch/fhnw/webec/contactlistsecurity/pages/IndexPage.java

public class IndexPage {

    private static final String URL = "http://localhost:%d";

    public static IndexPage to(WebDriver driver, int port) {
        driver.get(String.format(URL, port));
        return PageFactory.initElements(driver, IndexPage.class);
    }

    private final WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "logout-button")
    private WebElement logoutButton;

    @FindBy(tagName = "input")
    private WebElement todoInput;

    @FindBy(id = "add-todo")
    private WebElement addButton;

    @FindBy(tagName = "p")
    private List<WebElement> todos;

    @FindBy(id = "update-status")
    private WebElement updateButton;

    @FindBy(id = "delete-todo")
    private WebElement deleteButton;

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getTodoInput() {
        return todoInput;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public List<WebElement> getTodos() {
        return todos;
    }

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }
}
