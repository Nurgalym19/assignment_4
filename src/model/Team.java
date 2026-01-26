package model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private int id;
    private String name;
    private List<Player> players;

    public Team(int id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
