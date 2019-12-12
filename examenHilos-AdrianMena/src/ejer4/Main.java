package ejer4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int number = (int) ((Math.random() * 10) + 1);
        doFunctions(number);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doFunctions(int number) {
        CompletableFuture.supplyAsync(() -> doFactorial(number))
                .thenApply((result) -> multiply(result))
                .thenApply((result) -> convertToString(result))
                .thenAccept((result) -> showResult(result));
    }


    private static int doFactorial(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int multiply(int number) {
        return number * 2;
    }


    private static String convertToString(Integer result) {
        String stringAux = result.toString();
        String resultString = "";
        for (int i = 0; i < stringAux.length(); i++) {
            if (i != stringAux.length() - 1) {
                resultString += stringAux.charAt(i) + "-";

            } else {
                resultString += stringAux.charAt(i);

            }
        }
        return resultString;
    }


    private static void showResult(String result) {
        System.out.printf("The string produced is %s\n", result);
    }
}
