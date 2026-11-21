
public class DoublyLinkedList {

    // Node class
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;

    // 1. Insert First
    public void insertFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(data + " inserted first");
    }

    // 2. Insert Last
    public void insertLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        System.out.println(data + " inserted last");
    }

    // 3. Insert At Position
    public void insertAtPosition(int data, int pos) {

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertFirst(data);
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        System.out.println(data + " inserted at position " + pos);
    }

    // 4. Insert After a Key
    public void insertAfter(int key, int data) {

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        System.out.println(data + " inserted after " + key);
    }

    // 5. Insert Before a Key
    public void insertBefore(int key, int data) {

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp;
        newNode.prev = temp.prev;

        if (temp.prev != null) {
            temp.prev.next = newNode;
        } else {
            head = newNode;
        }

        temp.prev = newNode;

        System.out.println(data + " inserted before " + key);
    }

    // 6. Delete First
    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println(head.data + " deleted");

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    // 7. Delete Last
    public void deletelast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            System.out.println(head.data + " deleted");
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println(temp.data + " deleted");

        temp.prev.next = null;
    }

    // 8. Delete At Position
    public void deleteAtPosition(int pos) {

        if (head == null || pos < 1) {
            System.out.println("Invalid position or empty list");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        System.out.println(temp.data + " deleted");

        temp.prev.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // 9. Delete By Value
    public void deleteByValue(int key) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        System.out.println(temp.data + " deleted");

        if (temp == head) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Display Forward
    public void displayForward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        System.out.print("Forward: ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Display Backward
    public void displayBackward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertAtPosition(30, 3);

        list.displayForward();

        list.insertAfter(30, 35);
        list.displayForward();

        list.insertBefore(40, 38);
        list.displayForward();

        list.deleteFirst();
        list.displayForward();

        list.deletelast();
        list.displayForward();

        list.deleteAtPosition(2);
        list.displayForward();

        list.deleteByValue(35);
        list.displayForward();

        list.displayBackward();
    }
}
