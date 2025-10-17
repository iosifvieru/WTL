package org.L03.beans;

public class Instructor {
    private String firstName;
    private String lastName;

    public Instructor() {}
    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
}
