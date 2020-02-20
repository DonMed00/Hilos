import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Introduzca texto a encriptar: ");
        String password = scanner.next();
        try {
            SecretKey key = SymmetricEncryptionUtils.createAESKey();
            byte[] vector = SymmetricEncryptionUtils.createInitiazationVector();
            System.out.println("Desencriptando texto encriptado de manera simétrica.....");
            System.out.println(SymmetricEncryptionUtils.decryptWithAES(SymmetricEncryptionUtils.encryptWithAES(password,key,vector),key,vector));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        try {
            KeyPair keyAsy = AsymmetricEncriptionUtils.generateRSAKeyPair();
            System.out.println("Desencriptando texto encriptado de manera asimétrica...");
            System.out.println(AsymmetricEncriptionUtils.decryptWithRSA(AsymmetricEncriptionUtils.encryptWithRSA(password,keyAsy.getPrivate()),keyAsy.getPublic()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }


    }

}
