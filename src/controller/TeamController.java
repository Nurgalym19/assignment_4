package controller;

import model.Team;
import service.interfaces.TeamServiceInterface;

import java.util.List;
import java.util.Scanner;

public class TeamController {

    private final TeamServiceInterface teamService;
    private final Scanner scanner = new Scanner(System.in);

    public TeamController(TeamServiceInterface teamService) {
        this.teamService = teamService;
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== TEAM MENU ===");
            System.out.println("1) Create Team");
            System.out.println("2) Show All Teams");
            System.out.println("0) Back");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> createTeam();
                    case "2" -> showAllTeams();
                    case "0" -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    private void createTeam() {
        System.out.print("Team id (number): ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Team name: ");
        String name = scanner.nextLine();

        Team team = new Team(id, name);
        teamService.createTeam(team);

        System.out.println("Team created!");
    }

    private void showAllTeams() {
        List<Team> teams = teamService.getAllTeams();

        if (teams.isEmpty()) {
            System.out.println("No teams found.");
            return;
        }

        System.out.println("\n--- Teams ---");
        for (Team t : teams) {
            System.out.println("ID: " + t.getId() + " | Name: " + t.getName());
        }
    }
}
