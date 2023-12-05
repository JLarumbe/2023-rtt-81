package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateCustomerFormBean {
    private Integer id;
    
    @NotEmpty(message = "First name is required")
    @Length(max = 45, message = "First name must less than 45 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Length(max = 45, message = "Last name must be less than 45 characters")
    private String lastName;

    @Length(max = 45, message = "Email must be less than 45 characters")
    private String phone;

    @NotEmpty(message = "City is required")
    @Length(max = 45, message = "City must be less than 45 characters")
    private String city;
}
