
import java.util.Random;
import main.dataStructures.DoublyLinkedList.DoublyLinkedList;
import main.dataStructures.DoublyLinkedList.Node;
public class Main {
    public static void main(String[] args) throws Exception {



        
        System.out.println("Hello, World!");
        int size ,timeout ;
        Random HamasRandom = new Random();
        // genrate 20 process
        for (int i =0 ;i<20 ;i++){
            size = HamasRandom.nextInt(256);
            timeout = HamasRandom.nextInt(20000 );


        }
        // Create a doubly linked list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Test: Insert elements at the end
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        System.out.println("After inserting 10, 20, 30 at the end:");
        list.printForward();
        System.out.println();
        list.printReverse();
        System.out.println("\n");

        // Test: Insert elements at the beginning
        list.insertFirst(5);
        list.insertFirst(2);
        System.out.println("After inserting 5, 2 at the beginning:");
        list.printForward();
        System.out.println();
        list.printReverse();
        System.out.println("\n");

        // Test: Find an element
        int searchValue = 20;
        Node<Integer> foundNode = list.find(searchValue);
        if (foundNode != null) {
            System.out.println("Found node with value: " + foundNode.data);
        } else {
            System.out.println("Node with value " + searchValue + " not found.");
        }
        System.out.println();

        // Test: Remove a specific element
        int removeValue = 10;
        boolean isRemoved = list.remove(removeValue);
        System.out.println("Removing node with value " + removeValue + ": " + (isRemoved ? "Success" : "Failure"));
        list.printForward();
        System.out.println("\n");

        // Test: Remove first node
        Node<Integer> removedFirstNode = list.removeFirst();
        System.out.println("Removed first node with value: " + (removedFirstNode != null ? removedFirstNode.data : "None"));
        list.printForward();
        System.out.println("\n");

        // Test: Remove last node
        Node<Integer> removedLastNode = list.removeLast();
        System.out.println("Removed last node with value: " + (removedLastNode != null ? removedLastNode.data : "None"));
        list.printForward();
        System.out.println("\n");

        // Test: Check size
        System.out.println("Size of the list: " + list.getSize());
        System.out.println();

        // Test: Check if list is empty
        System.out.println("Is the list empty? " + (list.isEmpty() ? "Yes" : "No"));


    }
}
