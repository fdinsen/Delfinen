package ComponentValidation;

public class IntInputComponent implements ValidationComponent {
    @Override
    public boolean checkComponent(String input) {
        try {
            int inter = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ne) {
            System.err.println("Ugyldigt input!");
            System.err.println("Prøv igen");
            return false;
        }
    }
}
