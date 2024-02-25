package Objects.Plant;

import Objects.Dao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Used to define specific actions on the plant DAO
 */
public interface PlantDao extends Dao<Plant> {
    public Plant getByName(String species, String genus) throws SQLException, IOException;
}
