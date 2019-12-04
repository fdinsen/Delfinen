package ComponentValidation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class YearComponent implements ValidationComponent {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
    @Override
    public boolean checkComponent(String year) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy", Locale.ENGLISH);
            Date date = format.parse(year);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
