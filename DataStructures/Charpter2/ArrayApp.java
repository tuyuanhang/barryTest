package Charpter2;

public class ArrayApp {
	
	public static void main(String[] args) {
		int nElems = 0;
		int j;
		long searchKey;
		
		//-------------
		long[] arr = new long[]{77, 99, 44, 55, 22, 88, 11, 0, 66, 33};
		nElems = 10;
		
		for (j=0; j < nElems; j++){
			System.out.print(arr[j] + " ");
		}
		System.out.println("");
		
		searchKey = 66; //find item with key 66
		
		for (j = 0; j < arr.length; j++) {
			if (arr[j] == searchKey) {
				break;
			}
		}
		if (j == nElems) {
			System.out.println("Can not find " + searchKey);
		} else {
			System.out.println("Found:" + searchKey);
		}
		
		searchKey = 55; //delete item with key 55
		for (j=0; j < nElems; j++) {
			if (arr[j] == searchKey) {
				break;
			}
		}
		for (int k=j ; k < nElems-1; k++){
			arr[k] = arr[k+1];
		}
		nElems--;
		
		for (j=0; j < nElems; j++){
			System.out.print(arr[j] + " ");
			
		}
		System.out.println("");
	}
}
