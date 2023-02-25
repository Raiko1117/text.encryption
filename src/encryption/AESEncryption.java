package encryption;

import keys.SecretKeyGenerator;

import javax.crypto.Cipher;
import java.util.Base64;

public class AESEncryption extends AbstractEncryption {
    private static final String ALGORITHM = "AES";

    private Cipher cipher;

    public AESEncryption(String secretKey, SecretKeyGenerator keyGenerator) {
        super(secretKey, keyGenerator);

        try {
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String encrypt(String input) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes = cipher.doFinal(input.getBytes());

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.out.println(e);

        }

        return null;
    }

    @Override
    public String decrypt(String input) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(input);
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes);
        } catch (Exception e) {
            System.out.println(e);

        }

        return null;
    }
}
