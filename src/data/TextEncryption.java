package data;

public class TextEncryption {
    private int id;
    private String encrypted_text;
    private String decrypted_text;
    private String key;
    private String algorithm;

    public TextEncryption() {

    }

    public TextEncryption(String encrypted_text , String decrypted_text , String key , String algorithm) {
        setEncrypted_text(encrypted_text);
        setDecrypted_text(decrypted_text);
        setKey(key);
        setAlgorithm(algorithm);

    }

    public TextEncryption(int id, String encrypted_text , String decrypted_text , String key , String algorithm) {
        setId(id);
        setEncrypted_text(encrypted_text);
        setDecrypted_text(decrypted_text);
        setKey(key);
        setAlgorithm(algorithm);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEncrypted_text() {
        return encrypted_text;
    }

    public void setEncrypted_text(String encrypted_text) {
        this.encrypted_text = encrypted_text;
    }

    public String getDecrypted_text() {
        return decrypted_text;
    }

    public void setDecrypted_text(String decrypted_text) {
        this.decrypted_text = decrypted_text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String toString() {
        return "data.TextEncryption{" +
                "id=" + id +
                ", encrypted_text='" + encrypted_text + '\'' +
                ", decrypted_text='" + decrypted_text + '\'' +
                ", key='" + key + '\'' +
                ", algorithm='" + algorithm + '\'' +
                '}';
    }
}