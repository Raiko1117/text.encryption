package encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESEncryption implements EncryptionAlgorithm {
    private SecretKeySpec secretKey;

    public DESEncryption(String secretKey) throws Exception {
        byte[] keyBytes = new byte[8];
        byte[] secretKeyBytes = secretKey.getBytes();
        System.arraycopy(secretKeyBytes, 0, keyBytes, 0, Math.min(secretKeyBytes.length, keyBytes.length));
        this.secretKey = new SecretKeySpec(keyBytes, "DES");
    }

    @Override
    public String encrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    @Override
    public String decrypt(String input) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(input);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
