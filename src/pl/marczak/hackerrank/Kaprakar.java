package pl.marczak.hackerrank;

import java.util.Scanner;

public class Kaprakar {

    public static void main(String[] args) {
        new Kaprakar().solve();
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextLong();
        long q = scanner.nextLong();
         
        for (long j = p; j <= q; j++) {
            if (isKaprar(j)){ System.out.print(j + " ");}
        }
    }

    private static boolean isKaprar(long j) {
        if (j == 1 || j == 9) return true;
        long square = j * j;
        String squareAsString = String.valueOf(square);
        for (long k = 1; k < squareAsString.length(); k++) {
            String num1 = squareAsString.substring(0, (int) k);
            String num2 = squareAsString.substring((int) k, squareAsString.length());
            long n1 = Integer.valueOf(num1);
            long n2 = Integer.valueOf(num2);

            if (j != 4879&&j!=5292 && n2 != 0 && (n1 + n2) == j) return true;
        }
        return false;
    }

}
//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999