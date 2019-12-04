package ComponentValidation;

import enums.MembershipStatus;

public class MembershipStatusComponent implements ValidationComponent {
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
