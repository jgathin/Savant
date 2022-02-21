package com.test.Savant.models;

import com.test.Savant.AbstractEntity;
import com.test.Savant.models.layout.Project;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class User extends AbstractEntity {

    /* Universal user class which should be imported with the minor changes that pertain to each individual
    projects */

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull String email;

    @OneToMany(mappedBy = "user")
    private List<Project> projects;


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User (String username, String password, String email) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;

    }

    public String getUsername() {return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) { return encoder.matches(password, pwHash);}

    public String getEmail() { return email;}

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
