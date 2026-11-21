
public class ArrayCircularQueue {

    int[] arr;
    int front;
    int rear;
    int size;

    // Constructor
    public ArrayCircularQueue(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    // Enqueue - Add element
    public void enqueue(int x) {

        // Check if queue is full
        if ((rear + 1) % size == front) {
            System.out.println("QUEUE FULL");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = x;

        System.out.println(x + " added to queue");
    }

    // Dequeue - Remove element
    public int dequeue() {

        if (front == -1) {
            System.out.println("QUEUE EMPTY");
            return -1;
        }

        int removed = arr[front];

        // Only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return removed;
    }

    // Peek - View front element
    public int peek() {

        if (front == -1) {
            System.out.println("QUEUE EMPTY");
            return -1;
        }

        return arr[front];
    }

    // Display queue
    public void display() {

        if (front == -1) {
            System.out.println("QUEUE EMPTY");
            return;
        }

        System.out.print("Queue: ");

        int i = front;

        while (true) {
            System.out.print(arr[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        ArrayCircularQueue q = new ArrayCircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        q.enqueue(50);
        q.enqueue(60);

        q.display();

        System.out.println("Front element: " + q.peek());
    }
}
