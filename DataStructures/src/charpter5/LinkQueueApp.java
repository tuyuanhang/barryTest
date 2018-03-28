package charpter5;


class LinkQ {
	public long dData;
	public Link next;
	
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
}

public class LinkQueueApp {

}
