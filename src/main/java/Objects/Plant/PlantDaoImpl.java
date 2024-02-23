package Objects.Plant;

import Database.DatabaseConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlantDaoImpl implements PlantDao{
    @Override
    public Plant get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Plant plant) throws SQLException, IOException {
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql = "INSERT INTO rostlina(druh, rod) VALUES (?, ?)";

        PreparedStatement ps = conn.getConnection().prepareStatement(sql);

        ps.setString(1, plant.getSpecies());
        ps.setString(2, plant.getGenus());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(Plant plant) throws SQLException, IOException {
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql = "DELETE FROM rostlina WHERE (druh = ? AND rod = ?)";

        PreparedStatement ps = conn.getConnection().prepareStatement(sql);

        ps.setString(1, plant.getSpecies());
        ps.setString(2, plant.getGenus());

        int result = ps.executeUpdate();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public Plant getByName(String species, String genus) throws SQLException {
        return null;
    }
}
