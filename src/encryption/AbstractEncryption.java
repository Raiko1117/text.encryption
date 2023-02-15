package encryption;

import keys.KeyGenerator;

import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractEncryption implements EncryptionAlgorithm {
    protected SecretKeySpec key;

    public AbstractEncryption(String secretKey, KeyGenerator keyGenerator) {
        this.key = keyGenerator.generateKey(secretKey);
    }
}