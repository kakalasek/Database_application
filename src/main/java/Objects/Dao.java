package Objects;

import java.sql.SQLException;

public interface Dao<T> {

    T get(int id) throws SQLException;

    int insert(T t) throws SQLException;

    int delete(T t);
}
