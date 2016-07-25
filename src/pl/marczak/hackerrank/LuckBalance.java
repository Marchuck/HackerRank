package pl.marczak.hackerrank;

import java.util.Scanner;
import java.util.*;

public class LuckBalance {

    public static void main(String[] args) {
        new LuckBalance().solve();
    }

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int l = scanner.nextInt();
            boolean isImportant = scanner.nextInt() == 1;
            if (isImportant) {
                list.add(l);
            } else {
                sum += l;
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        });
        for (int j = 0; j < list.size(); j++) {
            if (j < k) sum += list.get(j);
            else sum -= list.get(j);
        }
        System.out.println(sum);
    }

}