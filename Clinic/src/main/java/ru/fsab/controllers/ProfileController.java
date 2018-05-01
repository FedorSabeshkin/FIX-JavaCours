package ru.fsab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fsab.models.State;
import ru.fsab.models.StatusHealth;
import ru.fsab.models.User;
import ru.fsab.repositories.UsersRepository;
import ru.fsab.security.details.UserDetailsImpl;
import ru.fsab.transfer.UserDto;

import java.util.Optional;

import static ru.fsab.transfer.UserDto.from;

@Controller
public class ProfileController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";
    }
    @PostMapping("/delete/{login}")
    public String delete(ModelMap model, @PathVariable("login") String login){
        Optional<User> userOptional = usersRepository.findOneByLogin(login);
        User user = userOptional.get();
        user.setState(State.DELETED);
        usersRepository.save(user);
        return "login";
    }
}
