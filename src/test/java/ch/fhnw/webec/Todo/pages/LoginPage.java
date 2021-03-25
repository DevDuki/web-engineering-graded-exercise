package ch.fhnw.webec.Todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Code von dieser Klasse vollständig vom Projekt Contact List übernommen.
// EXTERNAL: https://github.com/WebEngineering-FHNW/contact-list-security-netopyr-1/blob/master/src/test/java/ch/fhnw/webec/contactlistsecurity/pages/LoginPage.java

public class LoginPage {

    private static final String URL = "http://localhost:%d/login";

    public static LoginPage to(WebDriver driver, int port){
        driver.get(String.format(URL, port));
        return PageFactory.initElements(driver, LoginPage.class);
    }

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(tagName = "button")
    private WebElement button;

    public void login(String userNameValue, String passwordValue){
        username.clear();
        username.sendKeys(userNameValue);
        password.clear();
        password.sendKeys(passwordValue);
        button.click();
    }
}
