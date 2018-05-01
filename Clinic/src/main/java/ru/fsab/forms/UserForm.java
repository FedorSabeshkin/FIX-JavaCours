package ru.fsab.forms;

import lombok.Data;
import ru.fsab.models.Role;
import ru.fsab.models.State;
import ru.fsab.models.StatusHealth;

@Data
public class UserForm {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String Password;
    private Integer passportData;
    private StatusHealth statusHealth;
    private Role role;
    private State state;
    private String code;
}
