package ComponentValidation;

import enums.MembershipStatus;
import enums.MembershipType;

public class MembershipStatusComponent implements PersonComponent {
    @Override
    public boolean checkComponent(String idOfStatus) {
        int id;
        MembershipStatus type;
        try{
            id = Integer.parseInt(idOfStatus);
            type = MembershipStatus.values()[id-1];
        }catch(Exception e){
            System.out.println(idOfStatus + ", Er ikke en korrekt mulighed");
            return false;
        }
        return true;
    }
}
