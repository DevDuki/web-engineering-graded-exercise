package ch.fhnw.webec.Todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

// Codes in dieser Klasse wurden vom Projekt Contact List kopiert (keine Anpassungen waren notwendig).
// EXTERNAL: https://github.com/WebEngineering-FHNW/contact-list-security-netopyr-1/blob/master/src/main/java/ch/fhnw/webec/contactlistsecurity/controller/LoginController.java

@Controller
public class LoginController {

    @GetMapping("login")
    public ModelAndView login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout) {
        final Map<String, Object> model = new HashMap<>();
        model.put("error", error != null);
        model.put("logout", logout != null);
        return new ModelAndView("login", model);
    }
}
