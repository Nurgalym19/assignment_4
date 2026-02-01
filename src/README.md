Football Team Management System 

1.Overview
   Console application for managing football teams and players using Java OOP, SOLID architecture and PostgreSQL (JDBC).
   Layers:
- Controller: console menu + input/output
- Service: business logic
- Repository: SQL CRUD via JDBC
- Utils: sorting and reflection tools

2.SOLID Documentation

SRP (Single Responsibility)
- TeamController / PlayerController: UI logic only
- TeamService / PlayerService: business logic only
- TeamRepository / PlayerRepository: DB operations only
- DatabaseConnection: connection management
- SortingUtils: sorting logic
- ReflectionUtils: reflection inspection logic

OCP (Open/Closed)
- Base classes (BaseEntity, Person) can be extended with new entities (example: Coach) without changing existing logic.
- New sorting rules can be added by extending SortingUtils methods.

LSP (Liskov Substitution)
- Player and Coach extend Person and can be used anywhere Person is expected.
- Overridden methods (printInfo, validate) preserve correct behavior.

ISP (Interface Segregation)
- Small interfaces are used (example: Printable, Validatable) so classes implement only required behaviors.

DIP (Dependency Inversion)
- Controllers depend on services, not directly on repositories/SQL.
- Data access is isolated inside repository layer.

3.Advanced OOP Features

Generics
- Generic CRUD repository abstraction: CrudRepository<T> (reusable CRUD contract for entities).

Lambdas
- Sorting implemented using lambda expressions:
  players.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

Reflection
- ReflectionUtils.inspectClass(Class<?> clazz) prints fields/methods of a class at runtime.

Interface default/static methods
- Interfaces can include default/static helper methods to keep logic reusable without forcing overrides.

4.OOP Documentation

Abstract class + subclasses
- BaseEntity (abstract)
- Person extends BaseEntity
- Player extends Person
- Coach extends Person

Composition
- Team has many Players (DB relation via players.team_id foreign key).

Polymorphism
- printInfo() works differently depending on the real object type (Player vs Coach).
- validate() can be overridden to enforce entity-specific rules.

UML diagram ---  docs--> screenshots --> UML diagram

5.Database

Schema

    CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
    );

    CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL CHECK (age > 0),
    number INT NOT NULL,
    position VARCHAR(50) NOT NULL,
    team_id INT REFERENCES teams(id) ON DELETE CASCADE
    );

Constraints
- PK: teams.id, players.id
- FK: players.team_id -> teams.id
- CHECK: age > 0
- ON DELETE CASCADE: deletes players when team is deleted

Sample Inserts

        INSERT INTO teams(name) VALUES ('Kairat');
        INSERT INTO players(name, age, number, position, team_id)
        VALUES ('Dastan', 18, 9, 'St', 2);

6.Architecture Explanation

Controllers
- Handle user requests (menu selection, input parsing)
- Call service methods
- Print results/errors

Services
- Contain business logic and validations
- Call repositories for persistence

Repositories
- Execute SQL queries using JDBC
- Map ResultSet -> model objects

Example flow: Show players by teamId
Controller -> PlayerService -> PlayerRepository -> DB -> returns List<Player> -> Controller prints.

7.Execution Instructions

Requirements
- Java 17+
- PostgreSQL
- JDBC driver
- IntelliJ IDEA (recommended)

Run steps
1.Configure DB credentials in src/utils/DatabaseConnection.java
2.Run SQL schema in PostgreSQL
3.Run Main.java

8) All screenshots --- docs-> screenshots


9) Reflection

Learned
- Building layered architecture (controller/service/repository)
- Applying SOLID to keep code maintainable
- JDBC integration with PostgreSQL
- Using Generics, Lambdas and Reflection in practice

Challenges
- DB connection and SQL debugging
- Clean separation of responsibilities
- Correct input handling and exception management

Value of SOLID
- Easier testing and extension
- Clear structure
- Less coupling between UI, logic, and database

Author:Ermek Nurgalym

