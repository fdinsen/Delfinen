package ComponentValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FullDateComponent implements ValidationComponent {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Override
    public boolean checkComponent(String date) {
        try {
            LocalDate.parse(date, formatter);
        }catch (Exception e){
            System.err.println(date + ", accepteres ikke som fødselsdag");
            return false;
        }

        return true;
    }
}
