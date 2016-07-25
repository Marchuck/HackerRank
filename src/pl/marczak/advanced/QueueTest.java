package pl.marczak.advanced;

/**
 * HackerRank
 *
 * @author Lukasz Marczak
 * @since 22 lip 2016.
 * 19 : 00
 */
public class QueueTest {
    public static void main(String[] args) {
        new QueueTest().test();
    }

    public static class Queue {

        public static class Node {
            Node prev;
            Node next;
            int val;

            public Node(int e) {
                val = e;
            }
        }

        Node first;
        Node last;
        int size;
//        private List<Element> list = new ArrayList<>();

        public Queue() {

        }

        public void push(int e) {
            ++size;
            if (last == null) {
                last = new Node(e);
            } else {
                Node newNode = new Node(e);
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            }
        }

        public int pop() {
            --size;
            Node tmp = last;
            while (tmp.prev != null) tmp = tmp.prev;
            int e = tmp.val;
            tmp = null;
            return e;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    /*
    2,4,
    4,6,
    6,8
     */
    private void test() {
        Queue q = new Queue();
        q.push(2);
        q.push(4);
        q.pop();
        q.push(6);
        q.push(8);
        q.push(10);
        q.push(12);
        q.push(14);
        q.push(16);
        q.pop();
        q.pop();
        q.pop();
        q.pop();

        Queue.Node node = q.last;
        while (node.prev != null) {
            System.out.println(node.val);
            node = node.prev;
        }
    }
}
