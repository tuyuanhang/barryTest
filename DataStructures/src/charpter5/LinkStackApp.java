package charpter5;

import javax.lang.model.type.NullType;

class LinkS {
	public long dData;
	public LinkS next;
	
	public LinkS(long dd) {
		dData = dd;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}

class LinkListS {
	
	private LinkS first;
	
	public LinkListS(){
		first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(long dd) {
		LinkS newLink = new LinkS(dd);
		newLink.next = first;
		first = newLink;
	}
	
	public long deleteFirst() {
		LinkS temp = first;
		first = first.next;
		return temp.dData;
	}
	
	public void displayList() {
		LinkS current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}

class LinkStack {
	private LinkListS theList;
	
	public LinkStack(){
		theList = new LinkListS();
	}
	
	public void  push(long j) {
		theList.insertFirst(j);
	}
	
	public long pop() {
		return theList.deleteFirst();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	public void displayStack() {
		System.out.print("Stack (pop --> bottom):");
		theList.displayList();
	}
}

public class LinkStackApp {
	
	public static void main(String[] args) {
		
	}

}
