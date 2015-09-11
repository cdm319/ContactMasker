package masker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Chris Matthews
 * chrismatthews@outlook.com
 * 09 September 2015
 */
public class PhoneMasker {
    private static final Pattern UK_PHONE_REGEX = Pattern.compile("^(?<prefix>(?:\\+|00)?(?:44|0)?7(?:[0-9]{1}))[0-9]{8}$");

    public static String maskPhoneNumber(String phone) {
        Masker masker = new Masker('*');
        Matcher matcher = UK_PHONE_REGEX.matcher(phone);

        if (matcher.matches()) {
            String prefix = matcher.group("prefix");
            return masker.maskString(phone, prefix.length(), 3);
        } else {
            return phone;
        }
    }
}
