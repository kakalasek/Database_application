package Objects.Plant;

import java.sql.SQLException;

public class PlantDaoImpl implements PlantDao{
    @Override
    public Plant get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Plant plant) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Plant plant) {
        return 0;
    }

    @Override
    public Plant getByName(String species, String genus) throws SQLException {
        return null;
    }
}
