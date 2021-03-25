package ch.fhnw.webec.Todo.dao;

import ch.fhnw.webec.Todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Soll beim finden eines TodoElements anhand dessen Beschreibung helfen.
    Todo findTodoByDescriptionContainingAllIgnoreCase(String description);

    // Soll beim finden eines TodoElements anhand dessen Usernamen helfen.
    List<Todo> findTodosByUser(String user);
}
