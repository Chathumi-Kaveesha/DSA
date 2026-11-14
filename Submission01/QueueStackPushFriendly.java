
package Submission01;

import java.util.Queue;
import java.util.ArrayDeque;

public class QueueStackPushFriendly<E> {

    private Queue<E> queue1 = new ArrayDeque<>();
    private Queue<E> queue2 = new ArrayDeque<>();

    // Push element
    public void push(E element) {
        queue1.add(element);
    }

    // Pop top element
    public E pop() {

        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        E element = queue1.remove();

        Queue<E> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return element;
    }

    // Peek top element
    public E peek() {

        if (queue1.isEmpty()) {
            return null;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        E element = queue1.peek();

        queue2.add(queue1.remove());

        Queue<E> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return element;
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Return current number of elements
    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {

        QueueStackPushFriendly<Integer> stack =
                new QueueStackPushFriendly<>();

        stack.push(2);
        stack.push(12);
        stack.push(22);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Current size: " + stack.size());
    }
}
