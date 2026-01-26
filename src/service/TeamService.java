package service;

import model.Team;
import repository.TeamRepository;

import java.util.List;

public class TeamService {

    private final TeamRepository teamRepository = new TeamRepository();

    public void createTeam(Team team) {
        teamRepository.create(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.getAll();
    }
}
