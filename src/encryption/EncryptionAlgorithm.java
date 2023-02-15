package encryption;

public interface EncryptionAlgorithm {
    String encrypt(String input);

    String decrypt(String input);
}