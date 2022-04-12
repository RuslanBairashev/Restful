package edu.school21.restful.model;

public enum UsrRole {
    ADMINISTRATOR ("Administrator"),
    TEACHER ("Teacher"),
    STUDENT ("Student");

    private final String name;

    UsrRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
