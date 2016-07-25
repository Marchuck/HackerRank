package pl.marczak.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RareElements {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Element {
        int x, y;
        int[] cost;
        boolean isBoard;
        boolean[] seen;

        public Element(int x, int y, int isBoard, int k) {
            this.x = x;
            this.y = y;
            this.isBoard = isBoard == 1;
            this.cost = new int[k];
            this.seen = new boolean[k];
        }
    }

    public static class Queue {
        private Element[] arr;
        int first;
        int last;
        int size;
        List<Element> list = new ArrayList<>();

        public Queue(int n) {
            // arr = new Element[Integer.MAX_VALUE];
        }

        public void push(Element e) {
            list.add(e);
        }

        public Element pop() {
            Element e = list.remove(0);
            return e;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    public static void main(String[] args) {
        new RareElements().solve();
    }

   private int output[];

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        output = new int[testCases];
        for (int j = 0; j < testCases; j++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Point[] rareElements = new Point[k];
            for (int i = 0; i < k; i++) {
                rareElements[i] = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
            }
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int l = 0; l < n; l++) {
                    board[i][l] = scanner.nextInt();
                }
            }
            process(j, n, k, rareElements, board);
        }
        for (int i = 0; i < testCases; i++) {
            System.out.println("#" + (i + 1) + " " + output[i]);
        }
    }

    private void process(int testCaseIndex, int n, int k, Point[] rareElements, int[][] board) {

        Element[][] elements = new Element[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elements[i][j] = new Element(i, j, board[i][j], k);
            }
        }
        for (int q = 0; q < rareElements.length; q++) {
            Point p = rareElements[q];

            Queue list = new Queue(n * n);
            elements[p.x][p.y].cost[q] = 1;

            list.push(elements[p.x][p.y]);
            System.out.println("Processing for rare element (" + p.x + "," + p.y + ")");
            while (!list.isEmpty()) {
                Element e = list.pop();
                int x = e.x, y = e.y;
                elements[x][y].seen[q] = true;

                if (e.isBoard) {
                    if (x > 0 && !elements[x - 1][y].seen[q] && elements[x - 1][y].isBoard) {
                        System.out.println("ok! " + (x - 1) + "," + y);
                        elements[x - 1][y].cost[q] = elements[x][y].cost[q] + 1;
                        list.push(elements[x - 1][y]);
                    }
                    if (y > 0 && !elements[x][y - 1].seen[q] && elements[x][y - 1].isBoard) {
                        System.out.println("ok! " + (x) + "," + (y - 1));
                        elements[x][y - 1].cost[q] = elements[x][y].cost[q] + 1;
                        list.push(elements[x][y - 1]);
                    }
                    if (x < n - 1 && !elements[x + 1][y].seen[q] && elements[x + 1][y].isBoard) {
                        System.out.println("ok! " + (x + 1) + "," + (y));
                        elements[x + 1][y].cost[q] = elements[x][y].cost[q] + 1;
                        list.push(elements[x + 1][y]);
                    }
                    if (y < n - 1 && !elements[x][y + 1].seen[q] && elements[x][y + 1].isBoard) {
                        System.out.println("ok! " + (x) + "," + (y + 1));

                        elements[x][y + 1].cost[q] = elements[x][y].cost[q] + 1;
                        list.push(elements[x][y + 1]);
                    }


                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(elements[i][j].cost[q] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();

                }
            }
        }
        int minMax = Integer.MAX_VALUE;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (elements[i][j].isBoard) {
                    boolean skip = false;
                    for (Point p : rareElements) {
                        if (p.x == i && p.y == j) {
                            skip = true;
                            break;
                        }
                    }
                    if (skip) continue;
                    int max = maxWeight(elements[i][j]);
                    if (max < minMax) minMax = max;
                }
            }
        }
        output[testCaseIndex] = minMax;
    }

    private int maxWeight(Element element) {
        int max = element.cost[0];
        for (int i = 1; i < element.cost.length; i++) {
            if (element.cost[i] > max) max = element.cost[i];
        }
        return max;
    }
}