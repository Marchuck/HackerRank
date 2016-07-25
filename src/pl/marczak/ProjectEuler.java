package pl.marczak;

import java.util.*;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 11 lip 2016.
 * 19 : 41
 */
public class ProjectEuler {
    public interface Effective {
        void getResult();
    }

    public static void main(String[] args) {
        new ProjectEuler.Problem7().getResult();
    }

    /**
     * https://projecteuler.net/problem=1
     */
    private static class Problem1 implements Effective {

        long sum = 0;

        Problem1() {
            for (int j = 1; j < 1000; j++) {
                if (j % 3 == 0 || j % 5 == 0) sum += j;
            }
        }

        @Override
        public void getResult() {
            System.out.println((sum));
        }
    }

    /**
     * https://projecteuler.net/problem=2
     */
    private static class Problem2 implements Effective {

        long sum = 0;

        Problem2() {
            List<Long> fibbTable = new ArrayList<>();
            fibbTable.add(1l);
            fibbTable.add(1l);
            boolean conditionsMet = true;
            for (int j = 2; conditionsMet; j++) {
                long val = fibbTable.get(j - 1) + fibbTable.get(j - 2);
                if (val < 4000000) fibbTable.add(val);
                else conditionsMet = false;
            }
            for (Long aFibbTable : fibbTable) {
                long it = aFibbTable;
                if (it % 2 == 0) sum += it;
            }
        }

        @Override
        public void getResult() {
            System.out.println((sum));
        }
    }

    /**
     * https://projecteuler.net/problem=3
     */
    private static class Problem3 implements Effective {

        Set<Long> primes = new HashSet<>();

        private boolean isPrime(long s) {

            for (int j = 2; j < Math.sqrt(s) + 1; j++) {
                if (s % j == 0) return false;
            }
            return true;
        }

        long value = 600851475143l;

        Problem3() {
        }

        @Override
        public void getResult() {
            for (long k = (long) (Math.sqrt(value)); k > 1; k--) {
                if (isPrime(k)) {
                    System.out.println(k);
                    System.exit(1);
                }
            }
        }
    }

    private static class Problem4 implements Effective {

        @Override
        public void getResult() {
            long maxMul = 0;
            for (long l = 999; l > 99; l--) {
                for (long k = 999; k > 99; k--) {
                    long mul = l * k;
                    String s = String.valueOf(mul);

                    if (isPalindrome(s)) {
                        System.out.println(l + " * " + k + " = " + mul);
                        if (maxMul < mul) maxMul = mul;
                    }
                }
            }
            System.out.println("\nMax is " + maxMul);
        }

        private boolean isPalindrome(String s) {
            for (int k = 0; k < 1 + s.length() / 2; k++) {
                if (s.charAt(k) != s.charAt(s.length() - 1 - k)) return false;
            }
            return true;
        }
    }

    private static class Problem5 implements Effective {

        @Override
        public void getResult() {
//            Set<Long> primes =new HashSet<>();
//            for (int j = 1; j <= 20; j++) {
//                primes.add(j);
//            }
//            System.out.println("\nMax is ");
        }

        private boolean isPrime(long s) {

            for (int j = 2; j < Math.sqrt(s) + 1; j++) {
                if (s % j == 0) return false;
            }

            return true;
        }
    }

    private static class Problem6 implements Effective {

        @Override
        public void getResult() {
            long squaresSum = 0, sum = 0;
            for (int j = 1; j <= 100; j++) {
                sum += j;
                squaresSum += j * j;
            }
            System.out.println(sum * sum - squaresSum);
        }

        private boolean isPrime(long s) {

            for (int j = 2; j < Math.sqrt(s) + 1; j++) {
                if (s % j == 0) return false;
            }

            return true;
        }
    }

    private static class Problem7 implements Effective {

        @Override
        public void getResult() {
            List<Long> primes = new ArrayList<>();
            long i = 2;
            primes.add(2l);
            while (true) {
                if (isPrime(i)) primes.add(i);
                if (primes.size() > 10000) break;
                ++i;
            }
            Utils.log(Utils.toString(primes));
            Utils.log("" + primes.get(primes.size() - 1));
        }

        private boolean isPrime(long s) {
            for (int j = 2; j < Math.sqrt(s) + 1; j++) {
                if (s % j == 0) return false;
            }
            return true;
        }
    }
}
