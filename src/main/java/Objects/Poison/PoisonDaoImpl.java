package Objects.Poison;

import java.sql.SQLException;

public class PoisonDaoImpl implements PoisonDao{
    @Override
    public Poison get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Poison poison) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Poison poison) {
        return 0;
    }

    @Override
    public Poison getByName(String name) throws SQLException {
        return null;
    }
}
