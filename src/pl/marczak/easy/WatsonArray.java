package pl.marczak.easy;

import java.util.Scanner;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 25 lip 2016.
 * 20 : 42
 */
public class WatsonArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        boolean[] output = new boolean[testCase];

        for (int i = 0; i < testCase; i++) {
            int numberOfIntegers = scanner.nextInt();

            int array[] = new int[numberOfIntegers];

            for (int j = 0; j < numberOfIntegers; j++) {
                array[j] = scanner.nextInt();
            }
            if (numberOfIntegers == 1) {
                output[i] = true;
                continue;
            } else if (numberOfIntegers == 3) {
                output[i] = array[0] == array[2];
                continue;
            }
            int y = 0, z = numberOfIntegers - 1;
            int sum1 = array[y], sum2 = array[numberOfIntegers - 1];

            do {
                if (sum1 < sum2) {
                    ++y;
                    sum1 += array[y];
                } else if (sum2 > sum1) {
                    --z;
                    sum2 += array[z];
                }
            } while (y < z && sum1 != sum2);

            output[i] = (sum1 == sum2);
        }
        for (boolean b : output) {
            System.out.println(b ? "YES" : "NO");
        }
    }
}