package me.mervinz.djanpto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test
 *
 * @author Mervin
 */
public final class PasswordTest {

    /**
     * Run test
     *
     * @throws Exception exception on failure
     */
    @Test
    public void runTest() throws Exception {

        int sampleNumber = 10;

        String painPassword = "123456";

        List<String> encodedPasswordList = new ArrayList<>(sampleNumber);

        // Make passwords
        for (int i=0; i<sampleNumber; i++) {
            String encodedPassword = PasswordUtil.makePassword(painPassword);
            encodedPasswordList.add(encodedPassword);
            System.out.println(encodedPassword);
        }

        // Check password
        for (String encodedPassword: encodedPasswordList) {
            Assert.assertTrue(PasswordUtil.checkPassword(painPassword, encodedPassword));
            Assert.assertFalse(PasswordUtil.checkPassword(String.format("_%s", painPassword), encodedPassword));
        }
    }
}
