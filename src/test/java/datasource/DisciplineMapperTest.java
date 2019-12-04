/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gamma
 */
public class DisciplineMapperTest extends TestDataSetup {
    
    public DisciplineMapperTest() throws IOException {
    }

    /**
     * Test of getAllDisciplines method, of class DisciplineMapper.
     */
    @Test
    public void testGetAllDisciplinesByContent() {
        //Arrange
        DisciplineMapper instance = new DisciplineMapper();
        String[] expectedDisciplines 
                = {"CRAWL", "BACKCRAWL", "BREASTSTROKE", "BUTTERFLY"};
        String[] actualDisciplines;

        //Act
        actualDisciplines = instance.getAllDisciplines();
        
        //Assert
        assertArrayEquals(expectedDisciplines, actualDisciplines);
    }
    
}
