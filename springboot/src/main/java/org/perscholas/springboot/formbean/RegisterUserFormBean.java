package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserFormBean {
    private Integer id;

    @Email(message = "Please enter a valid email address")
    @NotEmpty(message = "Please enter an email address")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, " +
                    "one lowercase letter, one number, and one special character")
    private String password;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, " +
                    "one lowercase letter, one number, and one special character")
    private String confirmPassword;
}
