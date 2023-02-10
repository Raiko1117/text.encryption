package encryptions;

import javax.crypto.Cipher;
import java.util.Base64;

public class AESEncryption extends AbstractEncryption {
    private static final String ALGORITHM = "AES";

    public AESEncryption(String secretKey) {
        super(secretKey);
    }

    @Override
    protected String getAlgorithm() {
        return ALGORITHM;
    }

    @Override
    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(input.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @Override
    public String decrypt(String input) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(input);
        Cipher cipher = Cipher.getInstance(getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes);
    }
}