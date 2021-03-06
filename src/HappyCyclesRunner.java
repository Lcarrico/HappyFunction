import java.util.ArrayList;
import java.util.Scanner;


public class HappyCyclesRunner {
	public static ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		ArrayList<Integer> listOfNum = new ArrayList<Integer>();

		Scanner s = new Scanner(System.in);
				
		System.out.print("Enter the Number in base 10: ");
		int n = s.nextInt();
		
		listOfNum.add(n);
		System.out.println(happyFunction(n,4));
		numList = new ArrayList<Integer>();
		while(getPattern(listOfNum).size() == 0) {
			System.out.println(n);
			n = happyFunction(n,4);
			numList = new ArrayList<Integer>();
			listOfNum.add(n);
		
		}
		
		System.out.println(getPattern(listOfNum));
	}
	
	
	
	public static ArrayList<Integer> baseConverter(int n) {
		
		int i;
		
		if ( n < 3 ) {	
			i = n;
			
			numList.add(i);
		}
			
		else {
			i = n % 3;
			
			numList.add(i);
			
			n = 2 * ( n - i ) / 3 ;
			
			baseConverter(n);
			}
		return numList;	
		
	}
	
	public static int happyFunction(int n, int d) {
		
		ArrayList<Integer> fractionBaseNumber = baseConverter(n);
		
		
		int dSum = 0;
		
		for(Integer i: fractionBaseNumber)
		{
			dSum += Math.pow(i, d);
		}
		
		return dSum;
		
	}
	
	public static ArrayList<Integer> getPattern(ArrayList<Integer> arr){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		if (arr.size() == 0) {
			return temp;
		}
		int lastNum = arr.get(arr.size() - 1 );
		
		int ind = arr.indexOf(lastNum);
		
		
		if (ind == (arr.size() - 1 ))
			return temp;
		
		else {
			
			for (int i = ind; i < arr.size(); i++) {
				temp.add(arr.get(i));
				
			}
			return temp;
			
		}
		
	}
	
}
