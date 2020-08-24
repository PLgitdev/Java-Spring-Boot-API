package com.sample.sampleapp.Model; 

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotBlank;

/**
 * Description of this class.
 *
 * @author roundsquare
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")

public class User {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message="\n username is blank \n")
    @Pattern(regexp = "^(?=[a-zA-Z0-9._]{2,20}$)(?!.*[_.]{2})[^_.].*[^_.]$", 
        message = "\n invalid username \n")
    private String username;
    @NotBlank(message = "\n password is blank \n")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,}$", 
        message = "\n invalid password \n")
    private String password;
    @NotBlank(message="\n the password confirmation is blank \n")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,}$", 
        message = "\n invalid password confirmation")
    private String passwordConfirmation;
    @NotBlank(message = "\n email  is blank \n")
    @Email(message = "\n invalid email \n")
    private String email;
    @NotBlank(message = "\n email confirmation is blank \n")
    @Email(message = "\n invalid email confirmation \n")
    private String emailConfirmation;
    private String image;

    /* private String usernameRegex = "^[\\b|\\S|\\W]{2,20}$";
    private String passwordRegex = "^(?=\\d)(?=*[a-z])(?=[A-Z])(?=*[!@#$%^&*()_+]){8,20}$";
    private String emailRegex = "^[\\b|\\W|\\S][@][\\b|\\W|\\S][.][\\w|\\S]${5,30}";
    //manual validation
    public boolean valid() {

        if (!this.username.matches(this.usernameRegex)) {
            return false;
        }
        if (!String.valueOf(this.password).matches(this.passwordRegex) && 
            !String.valueOf(this.passwordConfirmation).matches(this.passwordRegex)) {
                return false;
        }
        for (int i = 0; i < this.password.length; i++) {
            if (this.password[i] != this.passwordConfirmation[i]) {
                return false;
            }
        }
        if (!this.email.matches(this.emailRegex) && 
            !this.emailConfirmation.matches(this.emailRegex)) {
                return false;
        }
        return true;
    }
    */
}
