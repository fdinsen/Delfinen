package ComponentValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthdayComponent implements ValidationComponent {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Override
    public boolean checkComponent(String birthday) {
        try {
            LocalDate.parse(birthday, formatter);
        }catch (Exception e){
            System.err.println(birthday + ", accepteres ikke som fødselsdag");
            return false;
        }

        return true;
    }
}
