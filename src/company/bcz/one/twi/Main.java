package company.bcz.one.twi;

import java.util.Scanner;

public class Main {


    public static boolean isPrime(int a) {

        boolean flag = true;

        if (a < 2) {
            return false;
        } else {

            for (int i = 2; i <= Math.sqrt(a); i++) {

                if (a % i == 0) {

                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isPrime(num));
    }

}
