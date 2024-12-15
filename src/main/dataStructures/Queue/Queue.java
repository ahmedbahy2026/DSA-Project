package main.dataStructures.Queue;

public class Queue<T extends Comparable<T>> {
    private int[] data; 
    private int front;   
    private int rear;    
    private int size;    
    private int capacity;  // MaxSize

    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity; 
        data[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = data[front];
        front = (front + 1) % capacity; 
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }
}
