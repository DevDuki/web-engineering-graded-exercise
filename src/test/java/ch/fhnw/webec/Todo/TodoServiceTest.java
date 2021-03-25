package ch.fhnw.webec.Todo;

import ch.fhnw.webec.Todo.model.Todo;
import ch.fhnw.webec.Todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Struktur dieses Codes wurde vom Projekt Contact List übernommen und angepasst.

@SpringBootTest
@Transactional
public class TodoServiceTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoService todoService;

    @Test
    void todoFromUserShouldReturnCorrectTodos() {
        //given
        final Todo todoUser1 = new Todo("User1 Todo");
        todoUser1.setUser("user1");

        final Todo todoUser2 = new Todo("User2 Todo");
        todoUser2.setUser("user2");

        entityManager.persist(todoUser1);
        entityManager.persist(todoUser2);
        entityManager.flush();

        //when
        final List<Todo> result = todoService.getTodosByUser("user1");

        //then
        assertThat(result).containsOnly(todoUser1);
    }
}
