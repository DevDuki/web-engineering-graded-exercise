<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./style.css">
    <link rel="icon" href="./icon/icon.png">
    <title>Todo List - Login</title>
</head>
<body>
<!-- Diese Datei wurde aus dem Projekt Contact List kopiert und leicht angepasst. -->
<!-- EXTERNAL: https://github.com/WebEngineering-FHNW/contact-list-security-netopyr-1/blob/master/src/main/resources/templates/login.ftlh -->
<header>
    <h1>Todo List</h1>
</header>

<main>

    <form class="login-form" action="/login" method="post">
        <#if error>
            <p class="error">Login failed. Please try again.</p>
        </#if>
        <#if logout>
            <p class="info">Logged out successfully!</p>
        </#if>
        <label for="username">Username:</label>
        <input id="username" type="text" name="username" required>
        <label for="password">Password:</label>
        <input id="password" type="password" name="password" required>
        <button id="login-button" type="submit">Login</button>
    </form>

</main>

<script>
    /*
    * Mit diesem "JavaScript" Code - weil es sich besser anhört als ECAMScript -
    * wird dem inputfeld und Plust button, eine class ab- oder zugewiesen, wenn
    * das Inputfeld leer ist. Dies dienst zur visuellen verdeutlichung, dass ein TodoElement
    * nur dann erstellt wird, wenn man auch eine Beschreibung ins inputfeld angibt.
    */
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
    const loginBtn = document.getElementById("login-button");

    loginBtn.addEventListener("click", () => {
        if(usernameInput.value === "" || passwordInput.value === "") {
            if (usernameInput.value === ""){
                usernameInput.classList.add("missing-input");
            } else {
                usernameInput.classList.remove("missing-input");
            }
            if(passwordInput.value === ""){
                passwordInput.classList.add("missing-input");
            } else {
                passwordInput.classList.remove("missing-input");
            }
        } else {
            usernameInput.classList.remove("missing-input");
            passwordInput.classList.remove("missing-input");
        }
    });
</script>

</body>
</html>