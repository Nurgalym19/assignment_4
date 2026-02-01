package controller;
import utils.SortingUtils;

import model.Player;
import service.interfaces.PlayerServiceInterface;

import java.util.List;
import java.util.Scanner;

public class PlayerController {

    private final PlayerServiceInterface playerService;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerController(PlayerServiceInterface playerService) {
        this.playerService = playerService;
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== PLAYER MENU ===");
            System.out.println("1) Add Player to Team");
            System.out.println("2) Show Players by Team ID");
            System.out.println("3) Delete Player from Team");
            System.out.println("0) Back");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> addPlayer();
                    case "2" -> showPlayersByTeamId();
                    case "3"->deletePlayerById();
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

    private void addPlayer() {
        System.out.print("Player name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Number (1-99): ");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.print("Position: ");
        String position = scanner.nextLine();

        System.out.print("Team ID: ");
        int teamId = Integer.parseInt(scanner.nextLine());

        Player player = new Player(0, name, age, number, position);
        playerService.createPlayer(player, teamId);

        System.out.println("Player added!");
    }

    private void deletePlayerById() {
        System.out.print("Enter Player ID to delete: ");
        int playerId = Integer.parseInt(scanner.nextLine());

        playerService.deletePlayer(playerId);

        System.out.println("Player deleted (if existed).");
    }


    private void showPlayersByTeamId() {
        System.out.print("Enter Team ID: ");
        int teamId = Integer.parseInt(scanner.nextLine());

        List<Player> players = playerService.getPlayersByTeamId(teamId);


        SortingUtils.sortPlayersByAge(players);

        if (players.isEmpty()) {
            System.out.println("No players found for this team.");
            return;
        }

        System.out.println("\n--- Players (sorted by age)---");
        for (Player p : players) {
            p.printInfo();
        }
    }
}

