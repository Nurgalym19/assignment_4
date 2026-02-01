package service;

import model.Player;
import repository.PlayerRepository;
import service.interfaces.PlayerServiceInterface;

import java.util.List;

public class PlayerService implements PlayerServiceInterface {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void createPlayer(Player player, int teamId) {
        playerRepository.create(player, teamId);
    }

    @Override
    public void deletePlayer(int playerId) {
        playerRepository.deleteById(playerId);
    }


    @Override
    public List<Player> getPlayersByTeamId(int teamId) {
        return playerRepository.getByTeamId(teamId);
    }
}
