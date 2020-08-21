package com.sample.sampleapp.Model; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
    private String username;
    private char[] password;
    private char[] passwordConfirmation;
    private String email;
    private String emailConfirmation;
    private String image;
    private String usernameRegex = "^[\\b|\\S|\\W]{2,20}$";
    private String passwordRegex = "^(?=\\d)(?=*[a-z])(?=[A-Z])(?=*[!@#$%^&*()_+]){8,20}$";
    private String emailRegex = "^[\\b|\\W|\\S][@][\\b|\\W|\\S][.][\\w|\\S]${5,30}";
    
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
}