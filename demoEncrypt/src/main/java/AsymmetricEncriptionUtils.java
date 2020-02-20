import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class AsymmetricEncriptionUtils {
    private static final String RSA_ALGORITHM = "RSA";
    private static final int RSA_KEY_SIZE_IN_BITS = 4096;

    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(RSA_KEY_SIZE_IN_BITS, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] encryptWithRSA(String plainText, PrivateKey privateKey) throws
            BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decryptWithRSA(byte[] cipherText, PublicKey publicKey) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}
