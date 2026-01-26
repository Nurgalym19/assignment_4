package model;

import base.BaseEntity;
import exception.InvalidInputException;
import interfaces.Printable;
import interfaces.Validatable;

public class Person extends BaseEntity implements Printable, Validatable {

    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }
    public void validate() {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException("Error");
        }
        if (age < 16 || age > 60) {
            throw new InvalidInputException("Error");
        }
    }


    public void printInfo() {
        System.out.print(name + " (" + age + " лет)");
    }

    public String getName() { return name; }
    public int getAge() { return age; }


    public String getEntityType() {
        return "PERSON";
    }
}
