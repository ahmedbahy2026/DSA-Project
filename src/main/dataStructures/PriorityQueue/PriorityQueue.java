package main.dataStructures.PriorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> {
  private final ArrayList<T> list;

  public PriorityQueue(){
    this.list = new ArrayList<>();
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty(){
    return list.isEmpty();
  }

  // peek the min element
  public T peek(){
    if(isEmpty()){
      throw new NoSuchElementException("The Priorty Queue is empty");
    }
    return list.get(0);
  }

  public void push(T val){
    list.add(val);
    bubbleUp(list.size()-1);
  }

  public T pop(){
    if (isEmpty()) {
      throw new NoSuchElementException("Heap is empty");
    }
    T result = list.get(0); 
    T lastElement = list.remove(list.size() - 1); 
    if (!list.isEmpty()) {
        list.set(0, lastElement); 
        bubbleDown(0);
    }
    return result;
  }

  public void printHeap() {
    System.out.println(list);
  }

  // Helper function for heap implementation
  private void bubbleUp(int index) {
    int parentIndex = (index - 1) / 2;

    while (index > 0 && list.get(index).compareTo(list.get(parentIndex)) < 0) {
        swap(index, parentIndex);
        index = parentIndex;
        parentIndex = (index - 1) / 2;
    }
  }

  // Helper function for heap implementation
  private void bubbleDown(int index) {
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;

    int smallest = index;

    if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(smallest)) < 0) {
        smallest = leftChildIndex;
    }
    if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(smallest)) < 0) {
        smallest = rightChildIndex;
    }

    if (smallest != index) {
        swap(index, smallest);
        bubbleDown(smallest);
    }
  }

  private void swap(int i, int j) {
    T temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

}
