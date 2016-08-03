package me.mervinz.djanpto;

import java.util.Random;

/**
 * RandomUtil provides functions for random string generation used by {@link PasswordUtil}
 *
 * @author Mervin
 */
@SuppressWarnings("unused")
public class RandomUtil {

    /**
     * Generate random string with specified length
     *
     * @param length length of result
     * @return random string
     */
    public static String generateRandomString(int length) {
        return generateRandomString(
                length,
                RandomStringBase.NUMBER,
                RandomStringBase.LOWER_CASE_LETTER,
                RandomStringBase.UPPER_CASE_LETTER
        );
    }

    /**
     * Generate random string with specified length and base character definitions
     *
     * @param length length of result
     * @param bases base character definitions
     * @return random string
     */
    public static String generateRandomString(int length, RandomStringBase... bases) {
        StringBuilder baseBuilder = new StringBuilder();
        for (RandomStringBase base : bases) {
            baseBuilder.append(base.baseChars);
        }
        return generateRandomString(length, baseBuilder.toString());
    }

    /**
     * Generate random string with specified length and base characters
     *
     * @param length length of result
     * @param base base characters
     * @return random string
     */
    public static String generateRandomString(int length, String base) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (Integer i = 0; i < length; i++) {
            Integer number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
