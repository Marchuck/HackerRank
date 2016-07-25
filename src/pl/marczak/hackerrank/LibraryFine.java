package pl.marczak.hackerrank;

import java.util.Scanner;

public class LibraryFine {

    public static void main(String[] args) {
        new LibraryFine().solve();
    }

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int deliveryDay = scanner.nextInt();
        int deliveryMonth = scanner.nextInt();
        int deliveryYear = scanner.nextInt();


        int aDay = scanner.nextInt();
        int aMonth = scanner.nextInt();
        int aYear = scanner.nextInt();

        int hackos = 0;
        if (aYear < deliveryYear) {
            hackos = 10000;

        } else {
            if (aMonth < deliveryMonth + 1) {
                hackos += 500 * (deliveryMonth - aMonth);
            }
            if (aDay < deliveryDay) {
                // if ()
            }


        }
        System.out.println(hackos);

    }

}