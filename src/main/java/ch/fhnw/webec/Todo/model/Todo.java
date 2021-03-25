package ch.fhnw.webec.Todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    private String description;
    private boolean isDone;

    private String user; // Jedes TodoElement wird dem Benutzer, der es erstellt hat, zugewiesen.

    public Todo() {}

    public Todo (String description){
        this.description = description; // Beschreibt das TodoElement, also was getan werden muss, z.B. Waschen, Kochen, etc..
        this.isDone = false; // Setzt isDone auf false, da keiner ein TodoElement erstellt, das bereits abgehakt ist. :D
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
