package ch.fhnw.webec.Todo.service;

import ch.fhnw.webec.Todo.dao.TodoRepository;
import ch.fhnw.webec.Todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Struktur vom Code in dieser Klasse wurde vom Projekt Contact List übernommen und angepasst.

@Service
public class TodoService {

    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository){
        this.repository = repository;
    }

    public List<Todo> getAllTodos(){
        return repository.findAll();
    }

    public Optional<Todo> findTodo(long id){
        return repository.findById(id);
    }

    // Folgende zwei Methoden, verwenden die vom Interface TodoRepository angebotenen Methoden.
    public List<Todo> getTodosByUser(String user) { return repository.findTodosByUser(user);}
    public Todo findByDescription(String desc) { return repository.findTodoByDescriptionContainingAllIgnoreCase(desc); }


    // CRUD Operationen, die im TodoController verwendet werden.
    // Grösttenteils vom Contat List Projekt übernommen, ausser dass alle void als return value haben.
    // EXTERNAL: https://github.com/WebEngineering-FHNW/contact-list-security-netopyr-1/blob/master/src/main/java/ch/fhnw/webec/contactlistsecurity/service/ContactService.java
    public void createTodo(Todo newTodo){
        repository.save(newTodo);
    }

    public void updateTodo(Todo updatedTodo){
        if(! repository.findById(updatedTodo.getId()).isPresent()){
            throw new IndexOutOfBoundsException();
        }
        repository.save(updatedTodo);
    }

    public void deleteTodo(long id){
        if(! repository.findById(id).isPresent()){
            throw new IndexOutOfBoundsException();
        }
        repository.deleteById(id);
    }
}
