package Objects.Poison;

import Objects.Dao;

import java.sql.SQLException;

public interface PoisonDao extends Dao<Poison> {
    public Poison getByName(String name) throws SQLException;
}
