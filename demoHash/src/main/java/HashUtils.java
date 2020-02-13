import org.mindrot.jbcrypt.BCrypt;


public class HashUtils {
    public static String hashPassword(String password) {
        // The salt is stored with the result string.
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static boolean verifyPassword(String password, String
            hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
