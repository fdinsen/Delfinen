package ComponentValidation;

import java.util.regex.Pattern;

public class PhoneComponent implements ValidationComponent {
    @Override
    public boolean checkComponent(String phone) {
        String regexPhone = "([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])";
        if(Pattern.matches(regexPhone, phone)){
            //correct email
            return true;
        }
        System.err.println(phone + ", Er ikke tilladt som et telefon nr.");
        return false;
    }
}
