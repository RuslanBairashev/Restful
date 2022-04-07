package edu.school21.restful.model;

public class User {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private enum role {
        ADMINISTRATOR,
        TEACHER,
        STUDENT
    }
}
