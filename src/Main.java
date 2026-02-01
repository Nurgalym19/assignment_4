import controller.PlayerController;
import controller.TeamController;

import repository.PlayerRepository;
import repository.TeamRepository;

import service.PlayerService;
import service.TeamService;

import service.interfaces.PlayerServiceInterface;
import service.interfaces.TeamServiceInterface;

import utils.ReflectionUtils;

import model.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ReflectionUtils.inspectClass(Player.class);

        TeamRepository teamRepository = new TeamRepository();
        PlayerRepository playerRepository = new PlayerRepository();


        TeamServiceInterface teamService = new TeamService(teamRepository);
        PlayerServiceInterface playerService = new PlayerService(playerRepository);


        TeamController teamController = new TeamController(teamService);
        PlayerController playerController = new PlayerController(playerService);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== FOOTBALL TEAM MANAGEMENT SYSTEM ===");
            System.out.println("1) Team Menu");
            System.out.println("2) Player Menu");
            System.out.println("0) Exit");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> teamController.menu();
                case "2" -> playerController.menu();
                case "3"-> playerController.menu();
                case "0" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
