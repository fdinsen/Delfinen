package ComponentValidation;

public class nameComponent implements PersonComponent{

    @Override
    public boolean checkComponent(String name) {
        if(name.matches("[a-zA-Z ]+)")){
        //correct name
        return true;
        }
        return false;
    }

}
