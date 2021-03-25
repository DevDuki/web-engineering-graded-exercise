package ch.fhnw.webec.Todo.controller;

import ch.fhnw.webec.Todo.model.Todo;
import ch.fhnw.webec.Todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service){
        this.service = service;
    }

    // Diese Methode gibt den Usernamen vom eingeloggten User zurück und wurde aus Stackoverflow entnommen.
    // EXTERNAL: https://stackoverflow.com/questions/32052076/how-to-get-the-current-logged-in-user-object-from-spring-security
    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){
            return  ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    // Holt nach dem einloggen die Liste der TodoElemente vom eingeloggten User zurück.
    @GetMapping
    public ModelAndView getTodos(){
        String username = currentUserName();
        final Map<String, Object> model = new HashMap<>();

        model.put("todos", service.getTodosByUser(username));
        return new ModelAndView("index", model);
    }

    /*
    * Erstellt ein TodoElement wenn User auf den Plus Button klickt.
    *
    * Falls keine Beschreibung angegeben wurde, wird kein neues Element erstellt und nur die Liste vom User zurückgegeben.
    *
    * Falls bereits ein Element besteht, welches die gleiche Beschreibung enthält, wird diese nicht erstellt, damit
    * keine duplikate in der liste entstehen können.
    */
    @GetMapping("createTodo")
    public ModelAndView createTodo(@RequestParam String todoDescription){
        String username = currentUserName();
        final Map<String, Object> model = new HashMap<>();

        // Falls das Inputfled für die Beschreibung leer ist (sollte jedoch durch das "required" attribut beim input im HTML bereits getestet worden sein).
        if(todoDescription.equals("")){
            model.put("todos", service.getTodosByUser(username));
            return new ModelAndView("index", model);
        }

        // Falls das Element bereits existiert wird dieser boolean Wert im loop auf true gesetzt.
        boolean alreadyExists = false;
        List<Todo> allTodos = service.getTodosByUser(username);
        for(Todo todo : allTodos){
            if(todo.getDescription().equals(todoDescription)){
                alreadyExists = true;
                break;
            }
        }

        // Hier wird schlussendlich, anhand des boolean Wertes, entschieden ob ein neues Element erstellt werden soll oder nicht.
        if(!alreadyExists){
            Todo newTodo = new Todo(todoDescription); // Neues Element wird also nur erstellt, wenn es noch keins davon gibt.
            newTodo.setUser(username);
            service.createTodo(newTodo);
        }

        // Unabhängig davon, ob nun ein neues erstellt wurde oder nicht, werden alle TodoElemente zurückgegeben.
        model.put("todos", service.getTodosByUser(username));
        return new ModelAndView("index", model);
    }

    /*
    * Löscht ein TodoElement
    *
    * Falls der Benutzer, nach einem Löschvorgang, einen refresh vom Brwoser erzeugt, kann es passieren, dass dieser
    * erneut versuchen wird den gleichen (bereits gelöschten) Element, was eine error hervorrufen würde. Deswegen
    * habe ich einen check eingeüfgt, welches überprüfen soll, ob dieses Element übrehaupt noch existiert.
    * Wenn ja, kann es gelöscht werden, ansonsten soll einfach nur die liste aller Todos zurückgegeben werden.
    */
    @GetMapping("deleteTodo")
    public ModelAndView deleteTodo(@RequestParam String todoDesc){
        String username = currentUserName();
        final Map<String, Object> model = new HashMap<>();

        Todo deletingTodo = service.findByDescription(todoDesc);

        // Massnahme gegen den refresh nach einem manuellen Löschvorgang.
        if(deletingTodo != null) {
            service.deleteTodo(deletingTodo.getId());
        }

        model.put("todos", service.getTodosByUser(username));
        return new ModelAndView("index", model);
    }

    /*
    * Aktualisiert den isDone Status vom TodoElement, wenn User auf das häkchen klickt.
    *
    * Ähnlich wie beim deleteTodo, kann beim refresh des Browsers, der gleiche Befehl nochmals geschickt werden.
    * Hier kann jedoch keine einfache Lösung gefunden werden, ausser das Einfügen eines pseudo input Elements,
    * welches einen zufälligen Wert erhalten würde, ausser bei einem Refresh, und so in erfahrung gebracht wird,
    * ob es sich um einen Refresh handelt oder nicht. Jedoch wurde dies hier nicht realisiert.
    */
    @GetMapping("updateIsDone")
    public ModelAndView updateIsDone(@RequestParam String updatingTodoDesc){
        String username = currentUserName();
        final Map<String, Object> model = new HashMap<>();

        Todo updatingTodo = service.findByDescription(updatingTodoDesc);
        updatingTodo.setDone(!updatingTodo.isDone());
        service.updateTodo(updatingTodo);

        model.put("todos", service.getTodosByUser(username));
        return new ModelAndView("index", model);
    }
}
