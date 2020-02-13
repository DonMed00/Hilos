import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.next();
        System.out.println(HashUtils.verifyPassword(password,HashUtils.hashPassword(password)));
    }

    }

