
public class SinglyLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // 1. Insert First
    public void insertFirst(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

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

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
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
        temp.next = newNode;

        System.out.println(data + " inserted after " + key);
    }

    // 5. Insert Before a Key
    public void insertBefore(int key, int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            insertFirst(data);
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Key not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        temp.next = newNode;

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

        while (temp.next.next != null) {
            temp = temp.next;
        }

        System.out.println(temp.next.data + " deleted");

        temp.next = null;
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

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        System.out.println(temp.next.data + " deleted");

        temp.next = temp.next.next;
    }

    // 9. Delete By Value
    public void deleteByValue(int key) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            deleteFirst();
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        System.out.println(temp.next.data + " deleted");

        temp.next = temp.next.next;
    }

    // Display
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        System.out.print("Linked List: ");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertAtPosition(30, 3);

        list.display();

        list.insertAfter(30, 35);
        list.display();

        list.insertBefore(40, 38);
        list.display();

        list.deleteFirst();
        list.display();

        list.deletelast();
        list.display();

        list.deleteAtPosition(2);
        list.display();

        list.deleteByValue(35);
        list.display();
    }
}
