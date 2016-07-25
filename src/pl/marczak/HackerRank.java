package pl.marczak;


import java.util.Scanner;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 23 cze 2016.
 * 18 : 57
 */
public class HackerRank {
    public static void main(String[] args) {
        new HackerRank().r();
    }
private void r(){
    /* Declare second integer, double, and String variables. */

    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    Scanner scan = new Scanner(System.in);

    int nextInt = scan.nextInt();
    double nextDouble = scan.nextDouble();
    String nextStr = scan.next();


        /* Read and save an integer, double, and String to your variables.*/

        /* Print the sum of both integer variables on a new line. */
    System.out.println(i+nextInt);
        /* Print the sum of the double variables on a new line. */
    System.out.println(d+nextDouble);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
    System.out.println(s+nextStr);
}
    private void run() {
        String input1 = "07:05:45PM";
        String input2 = "07:05:45AM";

        String ss[] = new String[]{"12:05:45AM", "12:05:45PM"};
        for (String input : ss) {
            String output;
            if (input.contains("P")) {
                output = hour(input).concat(input.substring(2, input.length() - 2));
            } else {
                output = (input.substring(0, input.length() - 2));
            }
            System.out.println(output);
        }

    }

    private String hour(String input) {
        int hour = Integer.valueOf(input.substring(0, 2)) + 12;
        if (hour == 24) return "12";
        return String.valueOf(hour);
    }
}











