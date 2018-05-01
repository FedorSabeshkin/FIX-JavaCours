package ru.fsab.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.fsab.models.Role;
import ru.fsab.models.User;


@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String login;
    private Integer passportData;
    private Role role;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .passportData(user.getPassportData())
                .role(user.getRole())
                .build();
    }
}
