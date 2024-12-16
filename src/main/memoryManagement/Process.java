package main.memoryManagement;

import java.util.Random;

public class Process implements Comparable<Process>{
  static private int count = 0;
  private int size;
	private int id;
	private int timeout;
	private MemBlock memBlock;
	
	
	public Process(){
		Random random = new Random();
		this.id = count++;
    this.size = random.nextInt(256) + 1;
		this.timeout = random.nextInt(20000) + 1;
		this.memBlock = null;
	}

  public String toString(){
    return "ProcessId: "+ this.id + ", ProcessSize: "+ this.size;
  }

  public MemBlock getMemBlock(){
    return memBlock;
  } 

  public int getTimeout(){
    return this.timeout;
  }

  public int getId(){
    return this.id;
  }

  public int getSize(){
    return this.size;
  }

  public void setMemBlock(MemBlock block){
    this.memBlock = block;
  }

  public void setTimeout(int timeout){
    this.timeout = timeout;
  }

  @Override
  public int compareTo(Process other) {
      // Define priority logic here (e.g., prioritize smaller timeout)
      return Integer.compare(this.timeout, other.timeout);
  }
}