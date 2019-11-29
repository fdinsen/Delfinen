/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.SwimmingDiscipline;
import model.TrainingTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class TrainingTimeMapperTest extends TestBaseIntegration{
    
    public TrainingTimeMapperTest() throws IOException{
    }

    /**
     * Test of addTime method, of class TrainingTimeMapper.
     */
    
    @Test
    public void testAddTime() {
        LocalDate ld = LocalDate.of(2018,11,05);
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        TrainingTime trainingTime = new TrainingTime(1, ld, 75000 , SwimmingDiscipline.CRAWL, "Simon");
        int exsectlength = 4;
        instanceOfTTMapper.addTime(trainingTime);
        
        ArrayList<TrainingTime> liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getMemberTimes(1);
        
        int actualMs = liste.size();
        assertEquals(exsectlength, actualMs);
    }
    @Test
    public void testGetMemberTime(){
        ArrayList<TrainingTime> liste = new ArrayList<>();
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        int expsectedMs = 60000;
        SwimmingDiscipline exspectedSD = SwimmingDiscipline.CRAWL;
        liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getMemberTimes(1);
        
        int actualMs = liste.get(0).getTimeInMS();
        SwimmingDiscipline actualSd = liste.get(0).getSd();
        
        assertEquals(expsectedMs, actualMs);
        assertEquals(exspectedSD, actualSd);
    }
    
}
