
package Controllers;
import datasource.DataSource;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class BookkeeperController extends Controller{

    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public BookkeeperController(DataSource datasource, int profileId) {
        super(datasource, profileId);
    }
    
    //----------------//
    // RestanceMapper //
    //----------------//
    
    public ArrayList<Member> getAllRestance() {
        return (ArrayList) datasource.getAllRestance();
    }
    
    public boolean memberHasRestance(int memberID) {
        return datasource.memberHasRestance(memberID);
    }
    
    public boolean markAsPaid(int memberID) {
        return datasource.markAsPaid(memberID);
    }
    
    public boolean makeNewSeason() {
        return datasource.makeNewSeason();
    }
    
    //---------//
    // METHODS //
    //---------//
    @Override
    public String toString() {
        return "Kasserer";
    }
}
