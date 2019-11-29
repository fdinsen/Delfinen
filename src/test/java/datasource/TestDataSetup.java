package datasource;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.junit.Before;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TestDataSetup {

    private ArrayList<String> DBSetUp = scanFromFile("delfinenTestData.sql");

    public TestDataSetup() throws IOException {
    }

    public ArrayList<String> scanFromFile(String filename) {
        ArrayList<String> lines = new ArrayList();
        try {
            Scanner scan = new Scanner(new File("SQLScripts/" + filename));
            scan.useDelimiter(Pattern.compile(";"));
            while (scan.hasNext()) {
                lines.add(scan.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void rebuildDB() {
        try (Connection connection = DBConnector.getConnection();
                Statement stmt = connection.createStatement();){
            for (String sqlStatement : DBSetUp) {
                if (!sqlStatement.isEmpty()) {
                    stmt.executeUpdate(sqlStatement);
                }
            }
        } catch (SQLException e) {
        }
    }

    @Before
    public void setUp() {
        rebuildDB();
    }
}
