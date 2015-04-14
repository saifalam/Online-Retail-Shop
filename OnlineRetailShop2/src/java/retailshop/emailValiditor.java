/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rahat
 */
public class emailValiditor {

    private Pattern pattern;
    public String EMAIL_PATTERN = "[a-zA-Z_.+-]+[0-9]?[\\._]?[a-z0-9]+[@][a-z]+[.][a-z]{2,4}";

    public boolean valid(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher m = pattern.matcher(email);
        boolean b = m.matches();
        return b;
    }
}
