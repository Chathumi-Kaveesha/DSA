package Submission01;
import java.util.Stack;

public class stackQueueEnqueueFriendly {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue - Add element
    public void enqueue(int x) {
        stack1.push(x);
        System.out.println(x + " added to queue");
    }

    // Dequeue - Remove element
    public int dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {

        stackQueueEnqueueFriendly q = new stackQueueEnqueueFriendly();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        q.enqueue(40);

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
    }
}
