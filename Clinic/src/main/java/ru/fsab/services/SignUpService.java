package ru.fsab.services;

import ru.fsab.forms.UserForm;

public interface SignUpService {
    void signUp(UserForm userForm, Boolean adminCheck);
}
