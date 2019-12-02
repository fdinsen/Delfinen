
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
    private Connection con = null;
    
    public boolean[] getPrivileges(int userID) {
        boolean[] privileges = new boolean[16];
        con = DBConnector.getConnection();
        
        String sql = "SELECT * FROM user_privileges WHERE user_piv_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while(rs.next()) {
                for(int i = 0; i < privileges.length ; i++) {
                    privileges[i] = rs.getBoolean(i + 1);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return privileges;
    }
}
