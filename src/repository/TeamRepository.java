package repository;

import model.Team;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {

    public void create(Team team) {
        String sql = "INSERT INTO teams(name) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, team.getName());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating team", e);
        }
    }

    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT id, name FROM teams";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Team team = new Team(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                teams.add(team);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching teams", e);
        }

        return teams;
    }

    public Team getById(int id) {
        String sql = "SELECT id, name FROM teams WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Team(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error finding team", e);
        }

        return null;
    }

    public void update(int id, Team team) {
        String sql = "UPDATE teams SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, team.getName());
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating team", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM teams WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting team", e);
        }
    }
}
