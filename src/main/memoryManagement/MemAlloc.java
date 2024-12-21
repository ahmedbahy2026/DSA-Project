package main.memoryManagement;

import main.dataStructures.DoublyLinkedList.DoublyLinkedList;
import main.dataStructures.PriorityQueue.PriorityQueue;
import main.dataStructures.DoublyLinkedList.Node;

public class MemAlloc {
  private DoublyLinkedList<MemBlock> availableBlocks; 
  private DoublyLinkedList<Process> waitingList;
  private PriorityQueue<Process> startingList;
  private DoublyLinkedList<Process> runningList;
  static int currentTime;

  public MemAlloc(){
    availableBlocks = new DoublyLinkedList<>();
    MemBlock memBlock = new MemBlock( 0,1023);
    availableBlocks.insertFirst(memBlock);

    waitingList = new DoublyLinkedList<>();
    startingList = new PriorityQueue<>();
    runningList = new DoublyLinkedList<>();
    currentTime = 0;
  }

  private void showLists(){
    System.out.println("At time " + currentTime);
    System.out.println("Running:");
    displayRunning();
    System.out.println("Waiting:");
    displayWaiting();
    ++currentTime;
  }

  private void displayRunning(){
    Node<Process> current = runningList.getHead();
    while(current != null){
      System.out.println("process " + current.data.getId() + " with size: " + current.data.getSize());
      current = current.next;
    }
    System.out.println("----------------");
  }

  private void displayWaiting(){
    Node<Process> current = waitingList.getHead();
    while(current != null){
      System.out.println("process " + current.data.getId() + " with size: " + current.data.getSize());
      current = current.next;
    }
    System.out.println("----------------");
  }

  private boolean alloc(Process process){
    int key = process.getSize();
    MemBlock bestCandidate = availableBlocks.getHead().data;
    if(bestCandidate == null) 
      return false;
    Node<MemBlock> current = availableBlocks.getHead();
    while(current != null){
      if(current.data.getSize() >= key && (current.data.getSize() < bestCandidate.getSize() || bestCandidate.getSize() < key))
        bestCandidate = current.data;  // Found a better candidate (smaller block that fits the memory required)
      current = current.next;
    }
    // no sufficienct memory block found
    if(bestCandidate == availableBlocks.getHead().data && bestCandidate.getSize() < process.getSize())
      return false;
    // Assign the process beginning from the start address of the best candidate
    MemBlock assignedBlock = new MemBlock(bestCandidate.getStartAdd(), bestCandidate.getStartAdd() + process.getSize() - 1);
    bestCandidate.setStartAdd(assignedBlock.getEndAdd() + 1);
    if(bestCandidate.getSize() == 0)
      availableBlocks.remove(bestCandidate);
    process.setMemBlock(assignedBlock);
    runningList.insertLast(process);
    return true;
  }

  private void free(Process process){
    Node<MemBlock> current = availableBlocks.getHead();
    
    while(current!=null){
      // possible equality ??
      if(process.getMemBlock().getEndAdd() <= current.data.getStartAdd()){
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
      // if(current.data.getEndAdd() == current.next.data.getStartAdd()) ??
      if(current.data.getEndAdd() == current.next.data.getStartAdd() + 1){
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

    MemBlock initial = new MemBlock(0, 1023);
    availableBlocks.insertFirst(initial);

    while(!startingList.isEmpty() || !waitingList.isEmpty() || !runningList.isEmpty()){
      // check running [ decrease one second --> delete if finished ]
      DoublyLinkedList<Process> finishedPorcessList = modifyRunnigList();
      // calling showlists so that at time 0, no process is running
      showLists();

      if(!startingList.isEmpty())
        waitingList.insertLast(startingList.pop());

      Node<Process> current = waitingList.getHead();

      while(current != null){
        // alloc(current.data); -- return Process or null;    or     return true or false
        // if(removed){
        //    remove from waiting
        // }
        boolean allocated = alloc(current.data);
        if(allocated)
          waitingList.remove(current.data);
        current = current.next; 
      }

      // display the ended process form the "finishedProcessList"
      DisplayFinished(finishedPorcessList);
      System.out.println("----------------");

      try{
        Thread.sleep(1000);
      }catch(InterruptedException err){
        System.out.println(err);
      }
    }
  }

  private void DisplayFinished(DoublyLinkedList<Process> list){
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
      current = current.next;
    }

    return finishedPorcessList;
  }
}
