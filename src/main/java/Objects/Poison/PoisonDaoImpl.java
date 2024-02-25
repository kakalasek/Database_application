package Objects.Poison;

import Database.DatabaseConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Defines bodies of all basic and specific interactions. Not all of them are used
 */
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
    public Poison getByName(String iname) throws SQLException, IOException {
        Poison poison = null;
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql1 = "SELECT * FROM jedy WHERE nazev = ?";

        PreparedStatement ps1 = conn.getConnection().prepareStatement(sql1);

        ps1.setString(1, iname);

        ResultSet rs = ps1.executeQuery();

        if(rs.next()){
            String name = rs.getString("nazev");
            String group = rs.getString("skupina");
            double ld50 = rs.getDouble("ld50_mg_na_kg");

            poison = new Poison(name, group, ld50);
        }

        ps1.close();

        //------------------

        String sql2 = "SELECT ucinek.nazev " +
                "FROM zpusobuje " +
                "INNER JOIN jed ON jed.id = jed_id " +
                "INNER JOIN ucinek ON ucinek.id = ucinek_id " +
                "WHERE jed.id = (SELECT id FROM jed WHERE nazev = ?)";

        PreparedStatement ps2 = conn.getConnection().prepareStatement(sql2);

        ps2.setString(1, iname);

        rs = ps2.executeQuery();

        while(rs.next()){
            poison.addEffect(rs.getString("nazev"));
        }

        ps2.close();

        conn.commit();

        rs.close();
        conn.close();

        return poison;
    }
}
