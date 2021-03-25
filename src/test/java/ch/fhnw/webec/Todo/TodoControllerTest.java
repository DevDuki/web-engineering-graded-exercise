package ch.fhnw.webec.Todo;

import ch.fhnw.webec.Todo.model.Todo;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Struktur dieses Codes wurde vom Projekt Contact List übernommen und angepasst.

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager entityManager;

    @Test
    void showOnlyUsersTodos() throws Exception {
        //given
        Todo todoUser1 = new Todo("User1 Todo");
        todoUser1.setUser("user1");

        Todo todoUser2 = new Todo("User2 Todo");
        todoUser2.setUser("user2");

        entityManager.persist(todoUser1);
        entityManager.persist(todoUser2);
        entityManager.flush();

        //when
        final ResultActions result = mockMvc.perform(
                MockMvcRequestBuilders.get("/createTodo?todoDescription=" + todoUser1.getDescription())
                .with(
                        SecurityMockMvcRequestPostProcessors.user("user1")
                )
        );

        //then
        result.andExpect(status().isOk())
                .andExpect(content().string(containsString("User1 Todo")))
                // Die hier verwendete doesNotContainString Hilfsmethode wurde von Stackoverflow übernommen.
                .andExpect(content().string(doesNotContainString("User2 Todo")));
    }

    // Hilfsmethode gefunden auf Stackoverflow, die eine NOT CoreMatchers zurückgibt,
    // um zu überprüfen ob ein String NICHT in der response enthalten ist.
    // EXTERNAL: https://stackoverflow.com/questions/56657018/spring-mockmvc-dont-expect-content
    private Matcher<String> doesNotContainString(String s) {
        return CoreMatchers.not(containsString(s));
    }
}
