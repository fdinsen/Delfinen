package ComponentValidation;

public class SwimmingDisciplinesComponent implements ValidationComponent {
    @Override
    public boolean checkComponent(String ids) {
        try{
            String[] splitted = ids.split(",");
            for (String str: splitted){
               Integer.parseInt(str);
            }
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
