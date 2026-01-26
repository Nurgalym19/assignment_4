import model.Player;
import model.Coach;
import repository.PlayerRepository;

public class Main {

    public static void main(String[] args) {
        PlayerRepository playerRepo = new PlayerRepository();
        int barcelonaId = 1;

        Coach coach = new Coach(1, "Nurgalym Ermek", 18, "Head Coach");

        System.out.println(" FC Barcelona ");
        coach.printInfo();

        System.out.println("\n=== Formation 4-3-3 ===\n");


        System.out.println("Goalkeeper:");
        for (Player p : playerRepo.getByTeamId(barcelonaId)) {
            if (p.getPosition().equals("GK")) {
                printPlayer(p);
            }
        }

        System.out.println("\nDefenders:");
        for (Player p : playerRepo.getByTeamId(barcelonaId)) {
            if (p.getPosition().equals("RB")
                    || p.getPosition().equals("CB")
                    || p.getPosition().equals("LB")) {
                printPlayer(p);
            }
        }
        System.out.println("\nMidfielders:");
        for (Player p : playerRepo.getByTeamId(barcelonaId)) {
            if (p.getPosition().equals("CM")
                    || p.getPosition().equals("AM")) {
                printPlayer(p);
            }
        }
        System.out.println("\nAttackers:");
        for (Player p : playerRepo.getByTeamId(barcelonaId)) {
            if (p.getPosition().equals("RW")
                    || p.getPosition().equals("LW")
                    || p.getPosition().equals("ST")) {
                printPlayer(p);
            }
        }
    }
    private static void printPlayer(Player p) {
        System.out.println(
                p.getName()
                        + " | #" + p.getNumber()
                        + " | " + p.getPosition()
                        + " | " + p.getAge() + " years"
        );
    }
}
