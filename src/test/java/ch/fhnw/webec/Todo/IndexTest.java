package ch.fhnw.webec.Todo;

import ch.fhnw.webec.Todo.service.TodoService;
import ch.fhnw.webec.Todo.pages.IndexPage;
import ch.fhnw.webec.Todo.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

// Struktur dieses Codes wurde vom Projekt Contact List übernommen und angepasst.

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TodoService todoService;

    private final WebDriver driver = new HtmlUnitDriver();

    @BeforeEach
    void login() {
        final LoginPage page = LoginPage.to(driver, port);
        page.login("user1", "user1");
    }

    @Test
    void createdTodoShowsOnTheList(){
        //given
        final IndexPage page = IndexPage.to(driver, port);

        //when
        page.getTodoInput().sendKeys("wash");
        page.getAddButton().click();

        //then
        assertThat(page.getTodos().get(0).getText()).isEqualTo("wash");
    }

    @Test
    void onlyLoggedInUserTodosShowOnList(){
        //given
        final IndexPage page = IndexPage.to(driver, port);

        //when
        createTodo(page, "wash"); // Selbst erstellte Hilfsmethode, da dieser Code mehrmals verwendet wurde.
        page.getLogoutButton().click();
        loginUser("user2", "user2"); // Hab mit dem LoginPage versucht einen neuen login durchzuführen, aber ging nicht, deswegen habe ich eine eigene Hilfsmethode erstellt.
        createTodo(page, "cook");

        //then
        assertThat(page.getTodos().size()).isEqualTo(1);
        assertThat(page.getTodos().get(0).getText()).isEqualTo("cook");
    }

    @Test
    void deleteTodoShouldRemoveTodoFromList(){
        //given
        final IndexPage page = IndexPage.to(driver, port);

        //when
        createTodo(page, "wash");
        page.getDeleteButton().click();

        //then
        assertThat(page.getTodos().size()).isEqualTo(0);
    }

    @Test
    void setDoneButtonShouldToggleTodoIsDonePropperty(){
        //given
        final IndexPage page = IndexPage.to(driver, port);

        //when
        createTodo(page, "wash");
        page.getUpdateButton().click();

        //then
        // Wir erinnern uns, dass das isDone immer zu erst false ist, sobald ein TodoElement erstellt wird.
        assertThat(todoService.findByDescription(page.getTodos().get(0).getText()).isDone()).isEqualTo(true);
    }

    // Hilfsmethode die direkt ein TodoElement mit der gewünschten beschreibung erstellt.
    private void createTodo(IndexPage page, String todoDesc){
        page.getTodoInput().sendKeys(todoDesc);
        page.getAddButton().click();
    }

    // Hilfsmethode zum einloggen eines Users, da es mit der LoginPage nicht ging.
    void loginUser(String username, String password){
        final LoginPage page = LoginPage.to(driver, port);
        page.login(username, password);
    }
}
