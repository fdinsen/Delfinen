package ComponentValidation;

public class NameComponent implements ValidationComponent {

    @Override
    public boolean checkComponent(String name) {
        if(name.matches("[a-zA-Z ]+")){
        //correct name
        return true;
        }
        System.err.println(name + ", Er ikke tilladt som et navn");
        return false;
    }

}
