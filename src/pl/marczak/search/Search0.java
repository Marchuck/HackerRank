package pl.marczak.search;

import java.util.Scanner;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 25 lip 2016.
 * 21 : 39
 */
public class Search0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int index = n - 1;
        while (index != 0) {
            if (index > 0) {
                if (arr[index] < arr[index - 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = tmp;
                    for (int i = 0; i < n; i++) {
                        if (i == index - 1)
                            System.out.print(arr[index] + " ");
                        else
                            System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                }
                --index;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
