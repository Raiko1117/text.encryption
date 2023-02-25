package encryption;

import keys.SecretKeyGenerator;

import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractEncryption implements EncryptionAlgorithm {
    protected SecretKeySpec key;

    public AbstractEncryption(String secretKey, SecretKeyGenerator keyGenerator) {
        this.key = keyGenerator.generateKey(secretKey);
    }
}