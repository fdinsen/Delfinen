package ComponentValidation;

import java.util.regex.Pattern;

public class StringComponent implements ValidationComponent {

    @Override
    public boolean checkComponent(String string) {
        String regexPhone = "[^\\s\\@]+[@]{0,1}[^\\s\\@]+";
        if(Pattern.matches(regexPhone, string)){
            //correct string
            return true;
        }
        System.err.println(string + ", Er ikke tilladt som et input her");
        return false;
    }
}

