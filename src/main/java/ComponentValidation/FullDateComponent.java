package ComponentValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FullDateComponent implements ValidationComponent {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Override
    public boolean checkComponent(String date) {
        try {
            LocalDate.parse(date, formatter);
        }catch (Exception e){
            System.err.println(date + ", accepteres ikke som dato");
            return false;
        }

        return true;
    }
}
