package me.mervinz.djanpto;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * PasswordUtil provides functions for password encode and validation.
 *
 * @author Mervin
 */
@SuppressWarnings("unused")
public class PasswordUtil {

    public static final Integer DEFAULT_ITERATIONS = 10000;
    public static final Integer DEFAULT_SALT_LENGTH = 12;
    public static final Algorithm DEFAULT_ALGORITHM = Algorithm.PBKDF2SHA256;

    /**
     * Make encoded hash by using specified pain password, salt value, iterations and algorithm.
     * The supported algorithm defined in enum {@link Algorithm}.
     *
     * @param password  plain password
     * @param salt      salt value
     * @param iter      iterations
     * @param algorithm algorithm
     * @return encoded hash
     */
    private static String makeEncodedHash(String password, String salt, int iter, Algorithm algorithm) {
        // Returns only the last part of whole encoded password
        SecretKeyFactory keyFactory;
        try {
            keyFactory = SecretKeyFactory.getInstance(algorithm.algorithmName);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(Charset.forName("UTF-8")), iter, 256);
        SecretKey secret;
        try {
            secret = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
        byte[] rawHash = secret.getEncoded();
        byte[] hashBase64 = Base64.getEncoder().encode(rawHash);

        return new String(hashBase64);

    }

    /**
     * Make encoded password by using specified pain password, salt value, iterations and algorithm.
     * The supported algorithm defined in enum {@link Algorithm}.
     *
     * @param password plain password
     * @param salt salt value
     * @param iter iterations
     * @param algorithm algorithm
     * @return encoded password
     */
    public static String makePassword(String password, String salt, Integer iter, Algorithm algorithm) {
        String hash = makeEncodedHash(password, salt, iter, algorithm);
        return String.format("%s$%d$%s$%s", algorithm.name, iter, salt, hash);
    }

    /**
     * Make encoded password by using default setting.
     *
     * @param password plain password
     * @return encoded password
     */
    public static String makePassword(String password) {
        return makePassword(password, makeRandomSalt(), DEFAULT_ITERATIONS, DEFAULT_ALGORITHM);
    }

    /**
     * Check password returns a boolean of whether the raw password matches the three part encoded digest.
     *
     * @param password plain password
     * @param hashedPassword encoded password
     * @return {@code true} if the raw password matches the three part encoded digest.
     */
    public static Boolean checkPassword(String password, String hashedPassword) {
        String[] parts = hashedPassword.split("\\$");
        if (parts.length != 4) {
            // wrong hash format
            return false;
        }
        String algorithmName = parts[0];

        Algorithm algorithm = null;

        for (Algorithm algorithmItem : Algorithm.values()) {
            if (algorithmItem.name.equals(algorithmName)) {
                algorithm = algorithmItem;
                break;
            }
        }

        if (algorithm == null) {
            return false;
        }

        Integer iterations = Integer.parseInt(parts[1]);
        String salt = parts[2];
        String hashed = parts[3];

        return hashed.equals(makeEncodedHash(password, salt, iterations, algorithm));
    }

    /**
     * Make random salt value
     *
     * @return random salt value
     */
    private static String makeRandomSalt() {
        return RandomUtil.generateRandomString(DEFAULT_SALT_LENGTH);
    }
}
