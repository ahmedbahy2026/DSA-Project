package main.memoryManagement;

import java.util.Random;

public class Process {


  private int size;
	private int id;
	private int timeout;
	private MemBlock memBlcok;
	
	
	public Process(int id){
		Random random = new Random();
		this.id = id;
		timeout = random.nextInt(20) + 1;
		memBlcok = null;
	}

  public String toString(){
    return "ProcessId: "+ this.id + "ProcessSize: "+ this.size;
  }
  
}