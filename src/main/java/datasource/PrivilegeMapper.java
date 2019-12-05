
package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class PrivilegeMapper {

    public boolean[] getPrivileges(int userID) {
        boolean[] privileges = new boolean[16];
        Connection con = DBConnector.getConnection();
        
        String sql = "SELECT * FROM user_privileges WHERE user_piv_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                for(int i = 0; i < privileges.length ; i++) {
                    // 2 are added for two reasons:
                    // + 1 because SQL counts columns from 1
                    // + 1 more because the first column is
                    // the user ID and therefore must be skipped
                    privileges[i] = rs.getBoolean(i + 2);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return privileges;
    }
}
