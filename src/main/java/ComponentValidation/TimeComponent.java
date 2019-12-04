/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentValidation;

import java.util.regex.Pattern;

/**
 *
 * @author gamma
 */
public class TimeComponent implements ValidationComponent {
    
    @Override
    public boolean checkComponent(String string) {
        String regex = "[0-5]+[\\d]+:+[0-5]+[\\d]+:+[\\d]+[\\d]+[\\d]";
        if(Pattern.matches(regex, string)) {
            return true;
        }
        System.err.println(string + ", er ikke tilladt som et input her");
        return false;
    }
}
