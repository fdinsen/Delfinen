package ComponentValidation;

import enums.MembershipType;

public class MembershipTypeComponent implements PersonComponent {
    @Override
    public boolean checkComponent(String idOfType) {
        int id;
        MembershipType type;
        try{
            id = Integer.parseInt(idOfType);
            type = MembershipType.values()[id-1];
        }catch(Exception e){
            System.out.println(idOfType + ", Er ikke en korrekt mulighed");
            return false;
        }
        return true;
    }
}
