package me.mervinz.djanpto;

/**
 * RandomStringBase defines base characters for random string generation
 *
 * @author Mervin
 */
public enum RandomStringBase {

    NUMBER("0123456789"),
    LOWER_CASE_LETTER("abcdefghijklmnopqrstuvwxyz"),
    UPPER_CASE_LETTER("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public final String baseChars;

    RandomStringBase(String baseChars) {
        this.baseChars = baseChars;
    }
}
