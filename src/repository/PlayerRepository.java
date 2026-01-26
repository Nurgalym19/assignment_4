package repository;

import model.Player;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class PlayerRepository {
    public void create(Player player, int teamId) {
        String sql = """
            INSERT INTO players(name, age, number, position, team_id)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setInt(3, player.getNumber());
            ps.setString(4, player.getPosition());
            ps.setInt(5, teamId);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Player> getByTeamId(int teamId) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM players WHERE team_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, teamId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                players.add(new Player(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("number"),
                        rs.getString("position")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return players;
    }
}
