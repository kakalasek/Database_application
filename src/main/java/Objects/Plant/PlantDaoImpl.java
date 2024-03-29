package Objects.Plant;

import Database.DatabaseConnection;
import Objects.Fruit.Fruit;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Defines bodies of all basic and specific interactions. Not all of them are used
 */
public class PlantDaoImpl implements PlantDao{
    @Override
    public Plant get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Plant plant) throws SQLException, IOException {
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String genusSql = "INSERT INTO rod(nazev) VALUES (?)";
        String speciesSql = "INSERT INTO druh(nazev) VALUES (?)";
        String plantSql = "INSERT INTO rostlina(rod_id, druh_id) VALUES ((SELECT rod.id FROM rod WHERE rod.nazev = ?), (SELECT druh.id FROM druh WHERE druh.nazev = ?))";

        PreparedStatement ps1 = conn.getConnection().prepareStatement(genusSql);

        PreparedStatement ps2 = conn.getConnection().prepareStatement(speciesSql);

        PreparedStatement ps3 = conn.getConnection().prepareStatement(plantSql);

        ps1.setString(1, plant.getGenus());

        ps1.execute();
        ps1.close();


        ps2.setString(1, plant.getSpecies());

        ps2.execute();
        ps2.close();

        ps3.setString(1, plant.getGenus());
        ps3.setString(2, plant.getSpecies());

        ps3.execute();
        ps3.close();


        conn.commit();

        conn.close();

        return 1;
    }

    @Override
    public int delete(Plant plant) throws SQLException, IOException {
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String genusSql = "DELETE FROM rod WHERE nazev = ?";
        String speciesSql = "DELETE FROM druh WHERE nazev = ?";
        String plantSql = "DELETE FROM rostlina WHERE ((rod_id = (SELECT rod.id FROM rod WHERE rod.nazev = ?)) AND (druh_id = (SELECT druh.id FROM druh WHERE druh.nazev = ?)))";


        PreparedStatement ps1 = conn.getConnection().prepareStatement(genusSql);
        PreparedStatement ps2 = conn.getConnection().prepareStatement(speciesSql);
        PreparedStatement ps3 = conn.getConnection().prepareStatement(plantSql);

        ps1.setString(1, plant.getGenus());

        ps1.execute();
        ps1.close();

        ps2.setString(1, plant.getSpecies());

        ps2.execute();
        ps2.close();

        ps3.setString(1, plant.getGenus());
        ps3.setString(2, plant.getSpecies());

        ps3.execute();
        ps3.close();

        conn.commit();

        conn.close();

        return 1;
    }

    @Override
    public Plant getByName(String ispecies, String igenus) throws SQLException, IOException {
        Plant plant = null;
        DatabaseConnection conn = DatabaseConnection.createConnection();
        conn.connect();

        String sql1 = "SELECT * FROM rostliny_s_plodem WHERE (druh = ? AND rod = ?)";

        PreparedStatement ps1 = conn.getConnection().prepareStatement(sql1);

        ps1.setString(1, ispecies);
        ps1.setString(2, igenus);

        ResultSet rs = ps1.executeQuery();

        if(rs.next()){
           String genus = rs.getString("rod");
           String species = rs.getString("druh");
           String family = rs.getString("celed");
           String order = rs.getString("rad");
           String class_ = rs.getString("trida");
           String clade = rs.getString("oddeleni");
           String subkingdom = rs.getString("podrise");
           String lengthOfLife = rs.getString("nazev");
           String fruitType = rs.getString("druh_plodu");
           String fruitColor = rs.getString("barva_plodu");
           String fruitShape = rs.getString("tvar_plodu");
           double height = rs.getDouble("vyska_cm");
           double width = rs.getDouble("sirka_cm");
           double length = rs.getDouble("delka_cm");

           plant = new Plant(genus, species, family, order, class_, clade, subkingdom, lengthOfLife, new Fruit(fruitType, fruitColor, fruitShape), height, width, length);
        }
        
        ps1.close();

        //--------------------

        String sql2 = "SELECT prostredi.nazev " +
                      "FROM roste " +
                      "INNER JOIN rostlina ON rostlina.id = rostlina_id " +
                      "INNER JOIN prostredi ON prostredi.id = prostredi_id " +
                      "WHERE ((rostlina.rod_id = (SELECT id FROM rod WHERE nazev = ?)) AND (rostlina.druh_id = (SELECT id FROM druh WHERE nazev = ?)))";

        PreparedStatement ps2 = conn.getConnection().prepareStatement(sql2);

        ps2.setString(1, igenus);
        ps2.setString(2, ispecies);


        rs = ps2.executeQuery();

        while(rs.next()){
            plant.addEnvironment(rs.getString("nazev"));
        }

        ps2.close();
        //--------------------

        String sql3 = "SELECT rostlina_cast.nazev " +
                      "FROM jedovaty " +
                      "INNER JOIN rostlina ON rostlina.id = rostlina_id " +
                      "INNER JOIN rostlina_cast ON rostlina_cast.id = cast_id " +
                      "WHERE ((rostlina.rod_id = (SELECT id FROM rod WHERE nazev = ?)) AND (rostlina.druh_id = (SELECT id FROM druh WHERE nazev = ?)))";

        PreparedStatement ps3 = conn.getConnection().prepareStatement(sql3);

        ps3.setString(1, igenus);
        ps3.setString(2, ispecies);


        rs = ps3.executeQuery();

        while(rs.next()){
            plant.addPoisonousPart(rs.getString("nazev"));
        }

        ps3.close();
        //--------------------

        String sql4 = "SELECT zeme.nazev " +
                "FROM vyskyt " +
                "INNER JOIN rostlina ON rostlina.id = rostlina_id " +
                "INNER JOIN zeme ON zeme.id = zeme_id " +
                "WHERE ((rostlina.rod_id = (SELECT id FROM rod WHERE nazev = ?)) AND (rostlina.druh_id = (SELECT id FROM druh WHERE nazev = ?)))";


        PreparedStatement ps4 = conn.getConnection().prepareStatement(sql4);

        ps4.setString(1, igenus);
        ps4.setString(2, ispecies);

        rs = ps4.executeQuery();

        while(rs.next()){
            plant.addState(rs.getString("nazev"));
        }

        ps4.close();
        //--------------------

        String sql5 = "SELECT jed.nazev " +
                "FROM obsahuje " +
                "INNER JOIN rostlina ON rostlina.id = rostlina_id " +
                "INNER JOIN jed ON jed.id = jed_id " +
                "WHERE ((rostlina.rod_id = (SELECT id FROM rod WHERE nazev = ?)) AND (rostlina.druh_id = (SELECT id FROM druh WHERE nazev = ?)))";

        PreparedStatement ps5 = conn.getConnection().prepareStatement(sql5);

        ps5.setString(1, igenus);
        ps5.setString(2, ispecies);

        rs = ps5.executeQuery();

        while(rs.next()){
            plant.addPoison(rs.getString("nazev"));
        }

        ps5.close();

        conn.commit();

        rs.close();
        conn.close();

        return plant;
    }
}
