
package model;

import exception.InvalidInputException;

public class Coach extends Person {

    private String role;

    public Coach(int id, String name, int age, String role) {
        super(id, name, age);
        this.role = role;
        validate();
    }

    @Override
    public void validate() {
        super.validate();

        if (role == null || role.isBlank()) {
            throw new InvalidInputException("Coach role cannot be empty");
        }
    }

    public String getRole() {
        return role;
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Coach: " + name +
                        " | Role: " + role +
                        " | Age: " + age + " years"
        );
    }

    @Override
    public String getEntityType() {
        return "COACH";
    }
}
