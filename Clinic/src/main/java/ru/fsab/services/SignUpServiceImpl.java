package ru.fsab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
import ru.fsab.forms.UserForm;
import ru.fsab.models.Role;
import ru.fsab.models.State;

import ru.fsab.models.StatusHealth;
import ru.fsab.models.User;
import ru.fsab.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm, Boolean checkAdmin) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        if (checkAdmin){
            User user = User.builder()
                    .firstName(userForm.getFirstName())
                    .lastName(userForm.getLastName())
                    .hashPassword(hashPassword)
                    .login(userForm.getLogin())
                    .statusHealth(StatusHealth.HEALTH)
                    .role(Role.ADMIN)
                    .state(State.ACTIVE)
                    .passportData(userForm.getPassportData())
                    .build();
            usersRepository.save(user);
        }
        else{
            User user = User.builder()
                    .firstName(userForm.getFirstName())
                    .lastName(userForm.getLastName())
                    .hashPassword(hashPassword)
                    .login(userForm.getLogin())
                    .statusHealth(StatusHealth.HEALTH)
                    .role(Role.USER)
                    .state(State.ACTIVE)
                    .passportData(userForm.getPassportData())
                    .build();
            usersRepository.save(user);
        }
    }

}
