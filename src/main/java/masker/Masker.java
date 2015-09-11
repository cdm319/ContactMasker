package masker;

/**
 * Chris Matthews
 * chrismatthews@outlook.com
 * 09 September 2015
 */
public class Masker {
    private char maskChar = '*';

    public Masker(char maskChar) {
        this.maskChar = maskChar;
    }

    public String maskString(String str, int unmaskedCharsAtStart, int unmaskedCharsAtEnd) {
        StringBuilder builder = new StringBuilder(str);
        if (str.length() > (unmaskedCharsAtStart + unmaskedCharsAtEnd)) {
            for (int i = unmaskedCharsAtStart; i < str.length() - unmaskedCharsAtEnd; i++) {
                builder.setCharAt(i, maskChar);
            }
        } else {
            throw new RuntimeException(String.format("Length (%d) of string \"%s\" is too short for specified number of unmasked characters (%d).", str.length(), str, unmaskedCharsAtStart + unmaskedCharsAtEnd));
        }

        return builder.toString();
    }
}
