package encryptions;

public interface EncryptionAlgorithm {
    String encrypt(String input) throws Exception;

    String decrypt(String input) throws Exception;
}