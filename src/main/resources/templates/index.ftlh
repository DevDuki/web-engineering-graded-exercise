<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="Todo List made with maven Java Spring Framework">
    <meta name="robots" content="index,follow"> <!-- Hilft für die SEO optimisierung.  -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet"> <!-- Wird für einen schöneren Font verwendet.  -->
    <!-- Das <link> Element darunter ist für die vereinfachte Nutzung von Icons im HTML gedacht.
    Damit kann man einfach in einer Klasse den Icon Typ angeben. Hier wird dabei das <span> Element dafür verwendet.
    Z.B. <span class="fas fa-sign-out-alt"></span> für das Logout icon. -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <link rel="stylesheet" href="./style.css">
    <link rel="icon" href="./icon/icon.png">
    <title>Todo List - All Todos</title>
</head>
<body>
<!-- Nach dem Login wird der User auf diese Index Seite weitergeleitet, wo er seine Todos anlegen und verwalten kann. -->

<!-- Logout Button. -->
<nav>
    <a id="logout-button" class="logout" href="/logout"><span class="fas fa-sign-out-alt"></span>Logout</a>
</nav>

<!-- Header. -->
<header>
    <h1>Todo List</h1>
</header>

<!-- Hauptbereich der Webseite. Hier werden Todos erstellt, verwaltet und angezeigt. -->
<main>
    <!-- Form zur Erstellung eines Todos. -->
    <form id="create-todo-form" action="/createTodo" method="get">
        <label id="create-todo-label" for="todo-input">Create Todo</label>
        <input id="todo-input" type="text" name="todoDescription" required>
        <button id="add-todo" type="submit" class="todo-button"><span class="fas fa-plus-square"></span></button>
    </form>

    <!-- Liste aller Todos mit deren Buttons fürs Löschen und Aktualiseren (isDone). -->
    <section class="todo-container">
    <#if todos?has_content> <!-- überprüft ob die Liste überhaupt todos enthält, da sonst ein error erzeugt wird. -->
        <ul class="todo-list">
            <#list todos as todo>
                <#if todo.isDone()> <!-- überprüft ob die isDone propperty vom Todo auf true oder false ist, damit sie unterschiedlich dargestellt werden können. -->
                    <li class="todo-item completed">
                <#else>
                    <li class="todo-item">
                </#if>
                        <p>${todo.description}</p>
                        <!-- Button um das Todo auf "done" setzen zu können. -->
                        <form class="update-todo" action="/updateIsDone" method="get"> <!-- Ich frag mich immernoch, ob man diese Funktion auch ohne eine <form> lösen könnte. -->
                            <button id="update-status" type="submit" name="updatingTodoDesc" value=${todo.description}><span class="fas fa-check"></span></button>
                        </form>
                        <!-- Buttom um das Todo zu löschen. -->
                        <form class="delete-todo" action="/deleteTodo" method="get">
                            <button id="delete-todo" type="submit" name="todoDesc" value=${todo.description}><span class="fas fa-trash"></span></button>
                        </form>
                    </li>
            </#list>
        </ul>
    </#if>

    </section>

</main>

<script>
    /*
    * Mit diesem "JavaScript" Code - weil es sich besser anhört als ECAMScript -
    * wird dem inputfeld und Plust button, eine class ab- oder zugewiesen, wenn
    * das Inputfeld leer ist. Dies dienst zur visuellen verdeutlichung, dass ein TodoElement
    * nur dann erstellt wird, wenn man auch eine Beschreibung ins inputfeld angibt.
    */
    const addTodoBtn = document.getElementById("add-todo");
    const todoInput = document.getElementById("todo-input");

    addTodoBtn.addEventListener("click", () => {
        if(todoInput.value === ""){
            todoInput.classList.add("missing-input");
            addTodoBtn.classList.add("missing-input");
        } else {
            todoInput.classList.remove("missing-input");
            addTodoBtn.classList.remove("missing-input");
        }
    });
</script>

</body>
</html>