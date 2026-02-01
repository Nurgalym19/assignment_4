package service.interfaces;

import model.Team;
import java.util.List;

public interface TeamServiceInterface {
    void createTeam(Team team);
    List<Team> getAllTeams();
}
