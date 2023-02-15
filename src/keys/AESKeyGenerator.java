package keys;

import javax.crypto.spec.SecretKeySpec;

public class AESKeyGenerator implements KeyGenerator {
    @Override
    public SecretKeySpec generateKey(String secretKey) {
        return new SecretKeySpec(secretKey.getBytes(), "AES");
    }
}