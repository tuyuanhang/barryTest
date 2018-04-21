package charpter7;

class ArraySh {
	private long[] theArray;
	private int nElems;
	
	public ArraySh(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display() {
		System.out.print("A=");
		for (int j=0; j<nElems; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println("");
	}
	
	public void shellSort() {
		int inner, outer;
		long temp;
		
		int h = 1;
		while( h <= nElems/3) {
			h = 3 * h + 1;
		}
	}
}

public class ShellSortApp {

}
