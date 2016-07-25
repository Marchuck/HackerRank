package pl.marczak.hackerrank;

import java.util.Scanner;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 18 lip 2016.
 * 23 : 06
 */
public class Test {

    static int[][] arr;
    static boolean notpossible;
    static int n = 0;
    static int lastY, lastX;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            lastX = -1;
            lastY = -1;
            notpossible = false;
            n = Integer.valueOf(scanner.nextLine());
            arr = new int[n][n];
            for (int l = 0; l < n; l++) {
                String nextLine = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    arr[l][j] = nextLine.charAt(j);
                }
            }

            greedy(0, 0);
            greedy(0, 0);
            System.out.println(!notpossible ? "YES" : "NO");
        }
    }

    private static void greedy(int i, int j) {
        if (lastX != i && lastY != j) {
            if (i < n && j < n) {
                if (i < n - 1 && arr[i][j] > arr[i + 1][j]) {
                    int tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;
                    lastX = i;
                    lastY = j;
                    greedy(i, j);
                }
                if (j < n - 1 && arr[i][j] > arr[i][j + 1]) {
                    int tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;
                    greedy(i, j);
                } else {
                    greedy(i + 1, j);
                    greedy(i, j + 1);
                }
            }
        } else {
            notpossible = true;
        }
    }
}
