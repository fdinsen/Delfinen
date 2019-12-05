/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.TrainingTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class TrainingTimeMapperTest extends TestDataSetup{
    
    public TrainingTimeMapperTest() throws IOException{
    }

    /**
     * Test of addTime method, of class TrainingTimeMapper.
     */
    
    @Test
    public void testAddTime() {
        LocalDate ld = LocalDate.of(2018,11,05);
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        TrainingTime trainingTime = new TrainingTime(10, ld, 400 , 1);
        int exsectlength = 5;
        instanceOfTTMapper.addTime(trainingTime);
        
        ArrayList<TrainingTime> liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getMemberTimes(10);
        
        int actualMs = liste.size();
        assertEquals(exsectlength, actualMs);
    }
    @Test
    public void testGetMemberTime(){
        ArrayList<TrainingTime> liste = new ArrayList<>();
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        int expsectedSize = 5;
        liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getMemberTimes(1);
        
        int actualSize = liste.size();
        
        assertEquals(expsectedSize, actualSize);
    }
    @Test
    public void testGetTop5Senior(){
        
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        int expsected = 5;
        
        ArrayList<TrainingTime> liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getTop5Senior(1);
        int actual = liste.size();
        
        assertEquals(expsected, actual);
        
    }
    @Test
    public void testGetTop5Junior(){
        
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        int expsected = 1;
        
        ArrayList<TrainingTime> liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getTop5Junior(1);
        int actual = liste.size();
        
        assertEquals(expsected, actual);
        
    }
    
}
