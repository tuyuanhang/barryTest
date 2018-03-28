package charpter5;

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
}

public class LinkStackApp {
	
	public static void main(String[] args) {
		
	}

}
