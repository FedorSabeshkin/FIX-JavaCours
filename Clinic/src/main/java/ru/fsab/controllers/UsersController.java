package ru.fsab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fsab.models.Role;
import ru.fsab.models.StatusHealth;
import ru.fsab.models.User;
import ru.fsab.repositories.UsersRepository;

import java.util.Optional;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }

    @PostMapping("/users/pacient")
    public String getPacientPage(ModelMap model){
        model.addAttribute("usersFromServer", usersRepository.findAllByRole(Role.USER));
        return "users";
    }

    @PostMapping("/users/admin")
    public String getMedicPage(ModelMap model){
        model.addAttribute("usersFromServer", usersRepository.findAllByRole(Role.ADMIN));
        return "users";
    }

    @PostMapping("/users/sick/{login}")
    public String setSick(ModelMap model, @PathVariable("login") String login){
        Optional<User> userOptional = usersRepository.findOneByLogin(login);
        User user = userOptional.get();
        user.setStatusHealth(StatusHealth.SICK);
        usersRepository.save(user);
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }
    @PostMapping("/users/health/{login}")
    public String setHealth(ModelMap model, @PathVariable("login") String login){
        Optional<User> userOptional = usersRepository.findOneByLogin(login);
        User user = userOptional.get();
        user.setStatusHealth(StatusHealth.HEALTH);
        usersRepository.save(user);
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }

}
