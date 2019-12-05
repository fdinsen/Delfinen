/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gamma
 */
public class DisciplineMapper {

    public String[] getAllDisciplines() {
        ArrayList<String> allDisciplinesList = new ArrayList();
        Connection con = DBConnector.getConnection();
        String sql = "SELECT * FROM disciplines";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next() ) {
                String discipline = rs.getString("discipline_name");
                allDisciplinesList.add(discipline);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] allDisciplines = new String[allDisciplinesList.size()];
        int count = 0;
        for (String discipline : allDisciplinesList) {
            allDisciplines[count] = discipline;
            count++;
        }
        return allDisciplines;
    }
}
