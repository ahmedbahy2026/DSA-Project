package main.memoryManagement;

import main.dataStructures.DoublyLinkedList.DoublyLinkedList;
import main.dataStructures.PriorityQueue.PriorityQueue;
import main.dataStructures.DoublyLinkedList.Node;

public class MemAlloc {
  private DoublyLinkedList<MemBlock> availableBlocks; 
  // private Queue<Process> waitingList;
  private DoublyLinkedList<Process> waitingList;
  private PriorityQueue<Process> startingList;
  private DoublyLinkedList<Process> runningList;

  public MemAlloc(){
    availableBlocks = new DoublyLinkedList<>();
    MemBlock memBlock = new MemBlock( 0,1023);
    availableBlocks.insertFirst(memBlock);

    waitingList = new DoublyLinkedList<>();
    startingList = new PriorityQueue<>();
    runningList = new DoublyLinkedList<>();
  }

  private void alloc(Process process){

  }

  private void free(Process process){
    Node<MemBlock> current = availableBlocks.getHead();
    
    while(current!=null){

      if(process.getMemBlock().getEndAdd() < current.data.getStartAdd()){
        // insert before current
        Node<MemBlock> newNode = new Node<MemBlock>(process.getMemBlock());
        // insert first
        if(current == availableBlocks.getHead()){
          availableBlocks.insertFirst(process.getMemBlock());
        }else {
          newNode.prev = current.prev;
          newNode.next = current;
          current.prev.next = newNode;
          current.prev = newNode;
        }
      }
      current = current.next;
    }
    if(current == null){
      // insert last
      availableBlocks.insertLast(process.getMemBlock());
    }

    // now the process block is inserted in the available block

    mergeAdjacentBlocks();
  }

  private void mergeAdjacentBlocks(){
    Node<MemBlock> current = availableBlocks.getHead();

    while (current.next != null) {
      if(current.data.getEndAdd() == current.next.data.getStartAdd() - 1){
        current.data.setEndAdd(current.next.data.getEndAdd());

        // if we try to remove the last --> we must modify "tail"
        if(current.next.next == null){
          availableBlocks.removeLast();
        }else{
          // remove element inside the list
          current.next = current.next.next;
          current.next.next.prev = current;
        }

      }else {
        current = current.next;
      }
    }
  }

  public void run(){
    // generate 20 process
    for(int i=0; i<20; i++){
      startingList.push(new Process());
    }

    while(!startingList.isEmpty()){
      // check running [ decrease one second --> delete if finished ]
      DoublyLinkedList<Process> finishedPorcessList = modifyRunnigList();

      waitingList.insertLast(startingList.pop());

      Node<Process> current = waitingList.getHead();

      while(current != null){
        // alloc(current.data); -- return Process or null;    or     return true or false
        // if(removed){
        //    remove from waiting
        // }
        current = current.next; 
      }

      // display the ended process form the "finishedProcessList"
      Display(finishedPorcessList);

      try{
        Thread.sleep(1000);
      }catch(InterruptedException err){
        System.out.println(err);
      }
    }
  }

  private void Display(DoublyLinkedList<Process> list){
    Node<Process> current = list.getHead();
    while (current != null) {
      int id = current.data.getId();
      System.out.println("Process "+ id + " ended!");
      current = current.next;
    }
  }

  private DoublyLinkedList<Process> modifyRunnigList(){
    DoublyLinkedList<Process> finishedPorcessList = new DoublyLinkedList<>();

    Node<Process> current = runningList.getHead();

    while(current != null) {
      if(current.data.getTimeout() <= 1000){
        // delete it
        Process removed;
        if(current == runningList.getHead()){ // delete first
          removed = runningList.removeFirst().data;
        }else if(current.next == null){
          removed = runningList.removeLast().data;
        }else {
          current.prev.next = current.next;
          current.next.prev = current.prev;
          removed =current.data;
        }
        free(removed);
        finishedPorcessList.insertLast(removed);
      }else{
        current.data.setTimeout(current.data.getTimeout() - 1000);
      }
    }

    return finishedPorcessList;
  }
}
