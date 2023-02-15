package keys;

import javax.crypto.spec.SecretKeySpec;

public class DESKeyGenerator {
    public SecretKeySpec generateKey(String secretKey) {
        byte[] keyBytes = new byte[8];
        byte[] secretKeyBytes = secretKey.getBytes();
        System.arraycopy(secretKeyBytes, 0, keyBytes, 0, Math.min(secretKeyBytes.length, keyBytes.length));
        return new SecretKeySpec(keyBytes, "DES");
    }
}