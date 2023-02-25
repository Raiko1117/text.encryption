package keys;

import javax.crypto.spec.SecretKeySpec;

public interface SecretKeyGenerator {
    SecretKeySpec generateKey(String secretKey);
}