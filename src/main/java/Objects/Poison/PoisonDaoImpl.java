package Objects.Poison;

import Database.DatabaseConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Poison getByName(String iname) throws SQLException, IOException {
        Poison poison = null;
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql1 = "";

        PreparedStatement ps1 = conn.getConnection().prepareStatement(sql1);

        //ps1.set

        ResultSet rs = ps1.executeQuery();

        if(rs.next()){
            String name = rs.getString("nazev");
            String group = rs.getString("skupina");
            double ld50 = rs.getDouble("ld50_mg_na_kg");

            poison = new Poison(name, group, ld50);
        }

        ps1.close();

        //------------------

        String sql2 = "";

        PreparedStatement ps2 = conn.getConnection().prepareStatement(sql2);

        //ps2.set

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
