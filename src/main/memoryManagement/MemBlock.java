package main.memoryManagement;

public class MemBlock {
  private int size; 
	private int startAdd;
	private int endAdd;
	
	public MemBlock(int startAdd, int endAdd){
		this.size = endAdd - startAdd + 1;
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
		setSize(endAdd - startAdd);
	}
	
	public void setEndAdd(int endAdd){
		this.endAdd = endAdd;
		setSize(endAdd - startAdd);
	}
}
