package Objects;

import java.io.IOException;
import java.sql.SQLException;

public interface Dao<T> {

    T get(int id) throws SQLException;

    int insert(T t) throws SQLException, IOException;

    int delete(T t) throws IOException, SQLException;
}
