
package model;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class Trainer {
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    String name;
    int id;
    
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Trainer(String trainerName) {
        name = trainerName;
    }
    
    public Trainer(String trainerName, int id)  {
        name = trainerName;
        this.id = id;
    }

    //---------//
    // GETTERS //
    //---------//
    public String getTrainerName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
