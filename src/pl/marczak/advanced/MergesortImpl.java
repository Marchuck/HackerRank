package pl.marczak.advanced;

import java.util.*;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 22 lip 2016.
 * 17 : 48
 */
public class MergesortImpl {
    public static void main(String[] args) {
        MergesortImpl impl = new MergesortImpl();
        int[] array = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        };
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Collections.shuffle(list);
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        //shuffled array here
        System.out.println(Arrays.toString(array));

        System.out.println("\nAfter mergeSort\n");
        new MergesortImpl().sort(array);
        System.out.println(Arrays.toString(array));
    }

    void sort(int[] array) {

        if (array.length > 2) {

        } else {

        }
    }

    /**
     * 1,3,2,6,7,       8,9,10,2,
     * <p>
     * 1,3,2,  6,7     8,9,  10,2
     *
     * @param array
     * @param left
     * @param right
     */
    private void sort(int[] array, int left, int right) {
        if (right - left > 1) {
            sort(array, 0, left + (right - left) / 2);
            sort(array, left + (1 + right - left) / 2, right);
        } else {
            if (right - left == 1) {
                if (array[left] > array[right]) {
                    int t = array[left];
                    array[left] = array[right];
                    array[right] = t;
                }
            }
        }

    }
}
