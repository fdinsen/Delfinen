/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import model.SwimmingDiscipline;
import model.TrainingTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class TrainingTimeMapperTest extends TestBaseIntegration{
    
    DBFacade dbf = new DBFacade();
    
    public TrainingTimeMapperTest() throws IOException{
    }

    /**
     * Test of addTime method, of class TrainingTimeMapper.
     */
    /*
    @Test
    public void testAddTime() {
        LocalDate ld = LocalDate.of(2018,11,05);
        TrainingTime trainingTime = new TrainingTime(1, ld, 75000 , SwimmingDiscipline.CRAWL);
        
        dbf.addTime(trainingTime);
        
        fail("The test case is a prototype.");
    }
    */
}
