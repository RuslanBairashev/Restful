package edu.school21.restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USR_G")
    private Long id;

    private String firstName;
    private String lastName;
    private String login;
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UsrRole usrRole;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "teachers")
    @JsonIgnore
    private List<Course> coursesTch = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    @JsonIgnore
    private List<Course> coursesStd = new ArrayList<>();

    public Usr() {
    }

    public Usr(String firstName, String lastName, String login, String password, UsrRole usrRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.usrRole = usrRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsrRole getUsrRole() {
        return usrRole;
    }

    public void setUsrRole(UsrRole usrRole) {
        this.usrRole = usrRole;
    }
}
