package ch.fhnw.webec.Todo;

import ch.fhnw.webec.Todo.dao.TodoRepository;
import ch.fhnw.webec.Todo.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

// Struktur dieses Codes wurde vom Projekt Contact List übernommen und angepasst.

@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void findByIdShouldReturnTodo() {
        //given
        final Todo todo = new Todo("cook");
        todo.setUser("user1");

        entityManager.persist(todo);
        entityManager.flush();

        //when
        final Optional<Todo> result = todoRepository.findById(todo.getId());

        //then
        assertThat(result.get().getId()).isEqualTo(todo.getId());
    }

    @Test
    void findByDescriptionShouldReturnTodo() {
        //given
        final Todo todo = new Todo("wash");
        todo.setUser("user1");

        entityManager.persist(todo);
        entityManager.flush();

        //when
        final Todo result = todoRepository.findTodoByDescriptionContainingAllIgnoreCase("wash");

        //then
        assertThat(result.getId()).isEqualTo(todo.getId());
    }

    @Test
    void findTodosByUserShouldReturnTodosFromUser() {
        //given
        final Todo todoUser1 = new Todo("User1 Todo");
        todoUser1.setUser("user1");

        final Todo todoUser2 = new Todo("User2 Todo");
        todoUser2.setUser("user2");

        entityManager.persist(todoUser1);
        entityManager.persist(todoUser2);
        entityManager.flush();

        //when
        final List<Todo> todos = todoRepository.findTodosByUser("user1");

        //then
        assertThat(todos.size()).isEqualTo(1);
        assertThat(todos).containsOnly(todoUser1);
    }

}
