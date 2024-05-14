import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

public class TextTransform {

    // Text(String) to AES
    private static final String AES_SECRET_KEY = "YourSecretKey123"; // Needs to be 16, 24, or 32 bytes long

    public static String encryptAES(String text) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(AES_SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptAES(String encryptedText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(AES_SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    // Text(String) to DES
    private static final String DES_SECRET_KEY = "YourSecretKey"; // Needs to be 8 bytes long

    public static String encryptDES(String text) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(DES_SECRET_KEY.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptDES(String encryptedText) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(DES_SECRET_KEY.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    // Text(String) to HASH
    public static String sha256Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(text.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    // Text(String) to Blowfish
    private static final String BLOWFISH_SECRET_KEY = "12345678"; // 8 bytes long

    public static String encryptBlowfish(String text) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("Blowfish");
        SecretKey key = keyFactory.generateSecret(new SecretKeySpec(BLOWFISH_SECRET_KEY.getBytes(), "Blowfish"));

        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding"); // Specify mode and padding
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptBlowfish(String encryptedText) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("Blowfish");
        SecretKey key = keyFactory.generateSecret(new SecretKeySpec(BLOWFISH_SECRET_KEY.getBytes(), "Blowfish"));

        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding"); // Specify mode and padding
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}

