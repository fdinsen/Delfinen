package ComponentValidation;

public class TrainerComponent implements ValidationComponent {
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
