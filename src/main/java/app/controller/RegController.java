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
public class RegController {

    @Autowired
    Storage storage;

    @GetMapping(path = "/reg")
    public ModelAndView reg () {
        return new ModelAndView();
    }

    @PostMapping(path = "/reg")
    public ModelAndView reg (String login, String pass, ModelAndView reg) {
        if (storage.isLoginExist(login)) {
            reg.addObject("wrongLogin", "This login already exists");
        } else {
            if (storage.addUser(login, pass)) {
                reg.setViewName("userAdded");
                reg.setViewName("reg");
                return reg;
            }
        }
        return reg;
    }
}
