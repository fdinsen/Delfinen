package ComponentValidation;

import enums.MembershipType;

public class TrainerComponent implements PersonComponent {
    @Override
    public boolean checkComponent(String trainerID) {
        int id;
        try{
            id = Integer.parseInt(trainerID);
            //TODO add more logic when all trainers can be called
        }catch(Exception e){
            System.out.println(trainerID + ", Er ikke et id på en træner");
            return false;
        }
        return true;
    }
}
