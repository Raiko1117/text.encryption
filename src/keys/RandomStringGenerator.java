package keys;
import java.security.SecureRandom;
import java.util.Base64;

public class RandomStringGenerator {
    private static final int STRING_LENGTH = 24;

    public  String generateRandomString() {
        SecureRandom random = new SecureRandom();
        byte[] stringBytes = new byte[STRING_LENGTH];
        random.nextBytes(stringBytes);
        return Base64.getEncoder().encodeToString(stringBytes);
    }
}