package Objects.Poison;

import Objects.Dao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Used to define specific actions on the poison DAO
 */
public interface PoisonDao extends Dao<Poison> {
    public Poison getByName(String name) throws SQLException, IOException;
}
