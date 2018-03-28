package charpter5;

class LinkQ {
	public long dData;
	public LinkQ next;
	
	public LinkQ(long d) {
		dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}

class FirstLastList {
	private LinkQ first;
	private LinkQ last;
	
	public FirstLastList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertLast(long dd) {
		LinkQ newLink = new LinkQ(dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	public long deleteFirst() {
		long temp = first.dData;
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		LinkQ current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}

class LinkQueue {
	private FirstLastList theList;
	
	public LinkQueue() {
		theList = new FirstLastList();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	public void inset(long j) {
		theList.insertLast(j);
	}
	
	public long remove() {
		return theList.deleteFirst();
	}
	
	public void displayQueue() {
		System.out.print("Queue (front-->rear): ");
		theList.displayList();
	}
}

public class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue theQueue = new LinkQueue();
		
		theQueue.inset(20);
		theQueue.inset(40);
		
		theQueue.displayQueue();
		
		theQueue.inset(60);
		theQueue.inset(80);
		
		theQueue.displayQueue();
		
		theQueue.remove();
		theQueue.remove();
		
		theQueue.displayQueue();
	}
}
