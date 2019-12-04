package ComponentValidation;

public class AddressComponent implements ValidationComponent {
    @Override
    public boolean checkComponent(String address) {
        if(address.matches("^(.+) (\\d{1,3}[a-z]?) (\\d{1,2}|st|kl)? ?(\\d{1,2}|tv|mf|th)?.*(\\d{4})$")){
            //correct name
            return true;
        }
        System.err.println(address + ", Er ikke tilladt som en adresse");
        return false;
    }
}
