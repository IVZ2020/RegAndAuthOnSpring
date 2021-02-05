package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import app.storage.Storage;

@Controller
@RequestMapping(path = "/")
public class AuthController {

    @Autowired
    Storage storage;

    @GetMapping(path = "/auth")
    public ModelAndView reg () {
        return new ModelAndView();
    }

    @PostMapping(path = "/auth")
    public ModelAndView reg (String login, String pass, ModelAndView auth) {

        if (storage.isLoginExist(login)) {
            if (storage.isPasswordCorrect(login, pass)) {
                auth.addObject("authOk", "Welcome user " + login);
                auth.setViewName("auth");
                return auth;
            } else {
                auth.addObject("authFail", "Wrong password!");
                auth.setViewName("auth");
                return auth;
            }
        } else {
                auth.addObject("loginFail", "Wrong login");
                auth.setViewName("auth");
                return auth;
        }
    }
}
