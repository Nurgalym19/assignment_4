package service.interfaces;

import model.Player;

import java.util.List;

public interface PlayerServiceInterface {

    void createPlayer(Player player, int teamId);


    void deletePlayer(int playerId);


    List<Player> getPlayersByTeamId(int teamId);
}
