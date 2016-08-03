package me.mervinz.djanpto;

/**
 * Algorithm defines algorithm that supported by PasswordUtil for password generation
 *
 * @author Mervin
 */
public enum Algorithm {

    PBKDF2SHA1("pbkdf2_sha1", "PBKDF2WithHmacSHA1"),
    PBKDF2SHA256("pbkdf2_sha256", "PBKDF2WithHmacSHA256"),
    PBKDF2SHA512("pbkdf2_sha512", "PBKDF2WithHmacSHA512"),
    PBKDF2MD5("pbkdf2_md5", "PBKDF2WithHmacMD5");

    public final String name;

    public final String algorithmName;

    Algorithm(String name, String algorithmName) {
        this.name = name;
        this.algorithmName = algorithmName;
    }
}
