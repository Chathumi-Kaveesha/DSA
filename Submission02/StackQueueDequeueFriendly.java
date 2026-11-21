
import java.util.Stack;

public class StackQueueDequeueFriendly {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue - Add element
    public void enqueue(int x) {

        // Move all elements to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Add new element
        stack1.push(x);

        // Move elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println(x + " added to queue");
    }

    // Dequeue - Remove element
    public int dequeue() {

        if (stack1.isEmpty()) {
            System.out.println("QUEUE EMPTY");
            return -1;
        }

        return stack1.pop();
    }

    // Peek - View front element
    public int peek() {

        if (stack1.isEmpty()) {
            System.out.println("QUEUE EMPTY");
            return -1;
        }

        return stack1.peek();
    }

    // Display queue
    public void display() {
        System.out.println(stack1);
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly q =
                new StackQueueDequeueFriendly();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Front: " + q.peek());

        q.display();
    }
}
