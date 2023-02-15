package keys;

import javax.crypto.spec.SecretKeySpec;

public interface KeyGenerator {
    SecretKeySpec generateKey(String secretKey);
}