package ComponentValidation;

public class AddressComponent implements ValidationComponent {
    @Override
    public boolean checkComponent(String address) {
        if(true){
            //correct name
            return true;
        }
        System.err.println(address + ", Er ikke tilladt som en adresse");
        return false;
    }
}
