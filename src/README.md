Football Team Management System

A. Project Overview

Purpose of the API

The purpose of this API is to manage football teams and their players using a Java application connected to a PostgreSQL database.
The system allows creating teams, adding players, retrieving team lineups, updating player data and handling invalid input using custom exceptions.

Summary of entities and their relationships

The main entities in the system are Team, Player, Coach and Person.
A Team can have multiple Players.
Each Player belongs to exactly one Team.
Coach represents the team coach and is associated with the team logically.
Person is a base abstraction for Player and Coach.

OOP design overview

The project is built using object-oriented programming principles such as abstraction, inheritance, encapsulation and polymorphism.
A layered architecture is used to separate concerns between models, repositories, services and controllers.

B. OOP Design Documentation

Abstract class and subclasses

Person is an abstract base class that represents a person in the system.
It contains common fields such as id, name and age, and defines validation behavior.

Example:

    public abstract class Person {

    protected int id;

     protected String name;

    protected int age;

    public abstract void validate();
}

__

Player and Coach are subclasses of Person.

    public class Player extends Person {

    private int number;

    private String position;}

    public class Coach extends Person {

    private String role;}

__

Interfaces and implemented methods

Printable interface defines the printInfo method.

Validatable interface defines the validate method.

    public interface Printable {
    void printInfo();
    }

    public interface Validatable {
    void validate();
    }

These interfaces are implemented by Person and overridden in Player and Coach.

Composition and aggregation

Team has an aggregation relationship with Player.
A team consists of multiple players, but players are stored independently in the database and linked using a foreign key.

--

Polymorphism examples

Polymorphism is demonstrated when a Person reference points to a Player or Coach object.

    Person person = new Player(...);
    person.validate();
    person.printInfo();

The correct overridden method is called at runtime.

UML diagram create using draw.io.

The screenshots:docs > screenshots.

C. Database Description

Schema, constraints and foreign keys

The project uses PostgreSQL with two main tables: teams and players.

    CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL);


    CREATE TABLE players (
     id SERIAL PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
     age INT CHECK (age > 0),
    number INT CHECK (number BETWEEN 1 AND 99),
    position VARCHAR(20),
    team_id INT REFERENCES teams(id) ON DELETE CASCADE);

Foreign key constraints ensure that each player belongs to a valid team.
Cascade delete removes players automatically when a team is deleted.

Sample SQL inserts

    INSERT INTO teams (name) VALUES ('Barcelona');

    INSERT INTO players (name, age, number, position, team_id)
    VALUES ('Lamine Yamal', 18, 10, 'RW', 1);

__

D. Controller

The controller logic is implemented through the Main class and the service layer.

Summary of CRUD operations

Create

    playerRepo.create(new Player(0, "Pedri", 22, 8, "CM"), teamId);

Read

    List<Player> players = playerRepo.getByTeamId(teamId);

Update

    playerRepo.updateNumber(playerId, 10);

Responses are displayed in the console, showing players grouped by positions and formatted in a 4-3-3 formation.

E. Instructions to Compile and Run

Requirements:
Java 17
PostgreSQL
IntelliJ IDEA

Example commands:

javac Main.java

java Main

F. Screenshots

The screenshots : docs > screenshots.

G. Reflection Section

What I learned

During this project, I learned how to design a Java application using object-oriented principles and a layered architecture.
I gained practical experience with JDBC and PostgreSQL integration.

Challenges faced

The main challenge was implementing validation correctly while using inheritance and polymorphism.
Another challenge was organizing the project structure to keep responsibilities clearly separated.

Benefits of JDBC and multi-layer design

Using JDBC allowed direct interaction with the database and better understanding of SQL operations.
The multi-layer design improved code readability, maintainability and scalability, and reflects real-world backend development practices.