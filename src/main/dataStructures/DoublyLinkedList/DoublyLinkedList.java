package main.dataStructures.DoublyLinkedList;

// Doubly Linked List class with Generic Data Type
public  class DoublyLinkedList<T> {

    private Node<T> head;  // The first node of the list
    private Node<T> tail;  // The last node of the list
    private int size;      // The number of elements in the list

    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    

    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
    }

    // Add a node to the end of the list
    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);  // Create a new node with the given data

        if (head == null) {  // If the list is empty
            head = newNode;  // Both head and tail point to the new node
            tail = newNode;
        } else {
            tail.next = newNode;  // Set the current tail's next to the new node
            newNode.prev = tail;  // Set the new node's previous to the current tail
            tail = newNode;  // Update tail to be the new node
        }
        size++;  // Increment the size of the list
    }

    // Find a node by its value and return the node
    public Node<T> find(T data) {
        if (head == null) {
            return null;  // List is empty, return null
        }
        Node<T> current = head;  // Start from the head node

        // Traverse the list to find the node with the specified data
        while (current != null) {
            if (current.data.equals(data)) {
                return current;  // Node found, return it
            }
            current = current.next;  // Move to the next node
        }

        return null;  // Node not found
    }

    // Add a node to the beginning of the list
    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);  // Create a new node with the given data

        if (head == null) {  // If the list is empty
            head = newNode;  // Both head and tail point to the new node
            tail = newNode;
        } else {
            newNode.next = head;  // Set the new node's next to the current head
            head.prev = newNode;  // Set the current head's previous to the new node
            head = newNode;  // Update head to be the new node
        }
        size++;  // Increment the size of the list
    }

    // Remove the first node and return the removed node
    public Node<T> removeFirst() {
        if (head == null) {
            return null;  // List is empty, return null
        }
        Node<T> removedNode = head;  // Store the node to be removed
        if (head == tail) {
            // If there is only one node in the list
            head = tail = null;  // Set both head and tail to null
        } else {
            // More than one node in the list
            head = head.next;  // Move the head to the next node
            head.prev = null;  // Set the new head's previous to null
        }
        size--;  // Decrease the size of the list
        removedNode.next = null;  // Clean up references to the removed node
        return removedNode;  // Return the removed node
    }

    // Remove a node by its value
    public boolean remove(T data) {
        if (head == null) {
            return false;  // List is empty, return false
        }

        Node<T> current = head;  // Start from the head

        // Traverse the list to find the node with the specified data
        while (current != null) {
            if (current.data.equals(data)) {
                // Node found, remove it
                if (current == head) {
                    head = current.next;  // If the node to remove is the head
                    if (head != null) {
                        head.prev = null;  // Update head's previous to null
                    }
                } else if (current == tail) {
                    tail = current.prev;  // If the node to remove is the tail
                    if (tail != null) {
                        tail.next = null;  // Update tail's next to null
                    }
                } else {
                    current.prev.next = current.next;  // Bypass the node to be removed
                    current.next.prev = current.prev;  // Link the previous and next nodes
                }
                size--;  // Decrease the size of the list
                return true;  // Node removed successfully
            }
            current = current.next;  // Move to the next node
        }
        return false;  // Node not found
    }

    // Remove the last node and return the removed node
    public Node<T> removeLast() {
        if (tail == null) {
            return null;  // List is empty, return null
        }
        Node<T> removedNode = tail;  // Store the node to be removed
        if (head == tail) {
            // If there is only one node in the list
            head = tail = null;  // Set both head and tail to null
        } else {
            // More than one node in the list
            tail = tail.prev;  // Move the tail to the previous node
            tail.next = null;  // Set the new tail's next to null
        }
        size--;  // Decrease the size of the list
        removedNode.prev = null;  // Clean up references to the removed node
        return removedNode;  // Return the removed node
    }

    // Display the list in forward order
    public void printForward() {
        Node<T> current = head;  // Start from the head
        System.out.print("Forward List: ");
        // Traverse the list and print each node's data
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;  // Move to the next node
        }
        System.out.println();
    }

    // Display the list in reverse order
    public void printReverse() {
        Node<T> current = tail;  // Start from the tail
        System.out.print("Reverse List: ");
        // Traverse the list and print each node's data in reverse
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.prev;  // Move to the previous node
        }
        System.out.println();
    }

    // Get the size of the list
    public int getSize() {
        return size;  // Return the number of elements in the list
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;  // If size is 0, the list is empty
    }
}


