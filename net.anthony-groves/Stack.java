package cs152;

import java.util.ArrayList;

public class Stack<AnyType> {
	
	private ArrayList<AnyType> items;
	
	public Stack() {
		items = new ArrayList<AnyType>();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return items.size();
	}
	
	public void pop() {
		items.remove(size() - 1);
	}
	
	public void push(AnyType item) {
		items.add(item);
	}
	
	public AnyType top() {
		return items.get(size()-1);
	}
	
	public AnyType topAndPop() {
		AnyType tmp = top();
		pop();
		return tmp;
	}

}
