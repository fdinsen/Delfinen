/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import model.TrainingTime;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
        System.out.println("addTime");
        LocalDate ld = LocalDate.of(2018,11,05);
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        TrainingTime trainingTime = new TrainingTime(10, ld, 400 , 1);
        int exsectlength = 4;
        instanceOfTTMapper.addTime(trainingTime);
        
        ArrayList<TrainingTime> liste = (ArrayList<TrainingTime>) instanceOfTTMapper.getMemberTimes(10);
        
        int actualMs = liste.size();
        assertEquals(exsectlength, actualMs);
    }
    @Test
    public void testGetMemberTime(){
        ArrayList<TrainingTime> liste = new ArrayList<>();
        TrainingTimeMapper instanceOfTTMapper = new TrainingTimeMapper();
        int expsectedSize = 3;
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

    @Test
    public void TestUpdateTrainingTime() {
        int expectedID = 18;
        String str = "2018-11-27";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedDate = LocalDate.parse(str, formatter);
        int memberID = 10;
        int tTimeMs = 1111;
        int disciplineID = 3;
        int expectedSize = 3;
        TrainingTime trainingTimeToBeAdded = new TrainingTime(expectedID, memberID, expectedDate, tTimeMs, disciplineID);

        ArrayList<TrainingTime> actual;
        TrainingTimeMapper trainingTimeMapper = new TrainingTimeMapper();
        trainingTimeMapper.updateTrainingTime(trainingTimeToBeAdded);

        actual = trainingTimeMapper.getMemberTimes(memberID);

        assertEquals(expectedID, actual.get(2).getTrainingTimeID());
        assertEquals(memberID, actual.get(2).getMemberID());
        assertEquals(expectedDate, actual.get(2).getDate());
        assertEquals(tTimeMs, actual.get(2).getTimeInMS());
        assertEquals(disciplineID, actual.get(2).getSwimmingDiscipline());
        assertEquals(expectedSize, actual.size());
    }


}
