package encryption;

import keys.SecretKeyGenerator;

public class EncryptionAlgorithmFactory {
    private SecretKeyGenerator keyGenerator;

    public EncryptionAlgorithmFactory(SecretKeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }
    public EncryptionAlgorithmFactory() {
    }

    public EncryptionAlgorithm createEncryptionAlgorithm(String algorithmName, String secretKey) throws Exception {
        switch (algorithmName) {
            case "AES":
                return new AESEncryption(secretKey, keyGenerator);
            case "DES":
                return new DESEncryption(secretKey);
            default:
                throw new IllegalArgumentException("Invalid algorithm name");
        }
    }
}

