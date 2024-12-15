package main.memoryManagement;

public class MemBlock {
  private int size; 
	private int startAdd;
	private int endAdd;
	
	public MemBlock(int size, int startAdd, int endAdd){
		this.size = size;
		this.startAdd = startAdd;
		this.endAdd = endAdd;
	}
	
	// getters
	public int getSize(){
		return size;
	}
	
	public int getStartAdd(){
		return startAdd;
	}
	
	public int getEndAdd(){
		return endAdd;
	}
	
	// setters
	public void setSize(int size){
		this.size = size;
	}
	
	public void setStartAdd(int startAdd){
		this.startAdd = startAdd;
	}
	
	public void setEndAdd(int endAdd){
		this.endAdd = endAdd;
	}
}
