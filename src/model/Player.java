package model;

import exception.InvalidInputException;

public class Player extends Person {

    private int number;
    private String position;

    public Player(int id, String name, int age, int number, String position) {
        super(id, name, age);
        this.number = number;
        this.position = position;

        validate();
    }

    @Override
    public void validate() {
        super.validate();

        if (number < 1 || number > 99) {
            throw new InvalidInputException("Error");
        }

        if (position == null || position.isBlank()) {
            throw new InvalidInputException("Error");
        }
    }

    @Override
    public void printInfo() {
        System.out.println(
                name + " | #" + number + " | " + position + " | " + age + " years"
        );
    }

    public int getNumber() { return number; }
    public String getPosition() { return position; }

    @Override
    public String getEntityType() {
        return "PLAYER";
    }
}
