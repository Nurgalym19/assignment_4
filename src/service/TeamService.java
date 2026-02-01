package service;

import model.Team;
import repository.TeamRepository;
import service.interfaces.TeamServiceInterface;

import java.util.List;

public class TeamService implements TeamServiceInterface {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void createTeam(Team team) {
        teamRepository.create(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.getAll();
    }
}
