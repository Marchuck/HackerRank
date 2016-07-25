package pl.marczak.search;

import java.util.Scanner;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 25 lip 2016.
 * 22 : 15
 */
public class Search2 {

    public static void insertionSortPart2(int[] arr) {
        int n = arr.length;
        int index = 1;
        while (index < n) {
            int tmpIndex = index;
            while (tmpIndex > 0 && arr[tmpIndex] < arr[tmpIndex - 1]) {
                if (arr[tmpIndex] < arr[tmpIndex - 1]) {
                    int tmp = arr[tmpIndex];
                    arr[tmpIndex] = arr[tmpIndex - 1];
                    arr[tmpIndex - 1] = tmp;
                }
                --tmpIndex;
            }
            ++index;
            printArray(arr);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);

    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
