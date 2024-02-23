package Objects.Plant;

import Objects.Dao;

import java.sql.SQLException;

public interface PlantDao extends Dao<Plant> {

    public Plant getByName(String species, String genus) throws SQLException;
}
