package encryptions;

public class RSAEncryption extends AbstractEncryption {
    private static final String ALGORITHM = "RSA";

    public RSAEncryption(String secretKey) {
        super(secretKey);
    }

    @Override
    protected String getAlgorithm() {
        return null;
    }

    @Override
    public String encrypt(String input) throws Exception {
        return null;
    }

    @Override
    public String decrypt(String input) throws Exception {
        return null;
    }
}