package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    MariaDbDataSource dataSource = new MariaDbDataSource();

    public JurassicPark(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation(){
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT `breed` FROM dinosaur WHERE actual > expected")
        ) {
            return getOverpopulation(stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can't query", sqle);
        }
    }

    private List<String> getOverpopulation(PreparedStatement stmt) {
        List<String> dinosName = new ArrayList<>();

        try (
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                String dinoName = rs.getString("breed");

                dinosName.add(dinoName);
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can't query", sqle);
        }
        return dinosName;
    }

}
