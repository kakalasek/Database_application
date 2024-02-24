package Objects.Plant;

import Database.DatabaseConnection;
import Objects.Fruit.Fruit;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantDaoImpl implements PlantDao{
    @Override
    public Plant get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Plant plant) throws SQLException, IOException {
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql = "INSERT INTO rostlina(druh, rod) VALUES (?, ?)";

        PreparedStatement ps = conn.getConnection().prepareStatement(sql);

        ps.setString(1, plant.getSpecies());
        ps.setString(2, plant.getGenus());

        int result = ps.executeUpdate();

        conn.commit();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public int delete(Plant plant) throws SQLException, IOException {
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql = "DELETE FROM rostlina WHERE (druh = ? AND rod = ?)";

        PreparedStatement ps = conn.getConnection().prepareStatement(sql);

        ps.setString(1, plant.getSpecies());
        ps.setString(2, plant.getGenus());

        int result = ps.executeUpdate();

        conn.commit();

        ps.close();
        conn.close();

        return result;
    }

    @Override
    public Plant getByName(String ispecies, String igenus) throws SQLException, IOException {
        Plant plant = null;
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql1 = "";

        PreparedStatement ps1 = conn.getConnection().prepareStatement(sql1);

        //ps1.set
        //ps1.set

        ResultSet rs = ps1.executeQuery();

        if(rs.next()){
           String genus = rs.getString("rod");
           String species = rs.getString("druh");
           String family = rs.getString("");
           String order = rs.getString("");
           String clade = rs.getString("");
           String subkingdom = rs.getString("");
           String lengthOfLife = rs.getString("");
           String fruitType = rs.getString("");
           String fruitColor = rs.getString("");
           String fruitShape = rs.getString("");
           double height = rs.getDouble("");
           double width = rs.getDouble("");
           double length = rs.getDouble("");

           plant = new Plant(genus, species, family, order, clade, subkingdom, lengthOfLife, new Fruit(fruitType, fruitColor, fruitShape), height, width, length);
        }
        
        ps1.close();

        //--------------------

        String sql2 = "";

        PreparedStatement ps2 = conn.getConnection().prepareStatement(sql2);

        //ps2.set

        rs = ps2.executeQuery();

        while(rs.next()){
            plant.addEnvironment(rs.getString(""));
        }

        ps2.close();
        //--------------------

        String sql3 = "";

        PreparedStatement ps3 = conn.getConnection().prepareStatement(sql3);

        //ps3.set

        rs = ps3.executeQuery();

        while(rs.next()){
            plant.addPoisonousPart(rs.getString(""));
        }

        ps3.close();
        //--------------------

        String sql4 = "";

        PreparedStatement ps4 = conn.getConnection().prepareStatement(sql4);

        //ps4.set

        rs = ps4.executeQuery();

        while(rs.next()){
            plant.addState(rs.getString(""));
        }

        ps4.close();
        //--------------------

        String sql5 = "";

        PreparedStatement ps5 = conn.getConnection().prepareStatement(sql5);

        //ps5.set

        rs = ps5.executeQuery();

        while(rs.next()){
            plant.addPoison(rs.getString(""));
        }

        ps5.close();

        conn.commit();

        rs.close();
        conn.close();

        return plant;
    }
}
