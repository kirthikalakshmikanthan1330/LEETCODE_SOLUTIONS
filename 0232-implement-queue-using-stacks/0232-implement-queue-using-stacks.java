import java.util.Stack;

class MyQueue {

    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move all elements to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int result = s2.pop(); // remove front element

        // Move back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return result;
    }

    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int result = s2.peek(); // just peek

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return result;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}