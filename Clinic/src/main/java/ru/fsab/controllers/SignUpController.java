package ru.fsab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fsab.forms.UserForm;
import ru.fsab.repositories.UsersRepository;
import ru.fsab.services.SignUpService;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

    @GetMapping
    public String getSignUpPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm) {
        Boolean checkAdmin = false;
        String code = userForm.getCode();
        if (!(code.isEmpty())){
            if (code.equals("secretCode")){
                checkAdmin = true;
            }
        }
        service.signUp(userForm, checkAdmin);
        return "redirect:/login";
    }

}
