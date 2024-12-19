package main.memoryManagement;

public class MemBlock {
	private int startAdd;
	private int endAdd;
	
	public MemBlock(int startAdd, int endAdd){
		this.startAdd = startAdd;
		this.endAdd = endAdd;
	}
	
	// getters
	public int getSize(){
		return endAdd - startAdd;
	}
	
	public int getStartAdd(){
		return startAdd;
	}
	
	public int getEndAdd(){
		return endAdd;
	}
  
	
	
	public void setStartAdd(int startAdd){
		this.startAdd = startAdd;
	}
	
	public void setEndAdd(int endAdd){
		this.endAdd = endAdd;
	}
}
