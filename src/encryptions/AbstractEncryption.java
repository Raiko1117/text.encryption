package encryptions;

import javax.crypto.spec.SecretKeySpec;
public abstract class AbstractEncryption implements EncryptionAlgorithm {
    protected SecretKeySpec key;

    public AbstractEncryption(String secretKey) {
        this.key = new SecretKeySpec(secretKey.getBytes(), getAlgorithm());
    }

    protected abstract String getAlgorithm();
}