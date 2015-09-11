package masker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Chris Matthews
 * chrismatthews@outlook.com
 * 09 September 2015
 */
public class EmailMasker {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^(?<name>[\\S^@]+)@(?<domain>[A-Z0-9.-]+\\.[A-Z]{2,24})$", Pattern.CASE_INSENSITIVE);

    public static String maskEmailAddress(String email) {
        Masker masker = new Masker('*');
        Matcher matcher = EMAIL_REGEX.matcher(email);

        if (matcher.matches()) {
            String name = matcher.group("name");
            String domain = matcher.group("domain");
            String maskedName;

            if (name.length() == 1) {
                maskedName = name;
            } else if (name.length() == 2) {
                maskedName = masker.maskString(name, 1, 0);
            } else if (name.length() > 2 && name.length() < 5) {
                maskedName = masker.maskString(name, 1, 1);
            } else {
                maskedName = masker.maskString(name, 2, 2);
            }

            return maskedName + "@" + domain;
        } else {
            return email;
        }
    }
}
