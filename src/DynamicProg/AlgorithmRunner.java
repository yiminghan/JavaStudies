package DynamicProg;

import java.util.ArrayList;

/*
 * Uses to run and demonstrate the algorithms built in this package;
 */
public class AlgorithmRunner {

	/*
	 * Choose whatever problem you want to solve.
	 */
	public static void main(String args[]){
		LongestPal();
	}
	
	/*
	 *  Play around the values a bit and see what happens
	 */
	public static void rodCutter() throws Exception{
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(0, 0);
		v.add(1, 1);
		v.add(2, 5);
		v.add(3, 8);
		v.add(4, 9);
		v.add(5, 10);
		v.add(6, 17);
		v.add(7, 17);
		v.add(8, 20);
		v.add(9, 24);
		v.add(10, 30);
		RodCutter R = new RodCutter();
		String out = R.printCut(v, 5);
		System.out.println(out);
	}
	
	public static void TwoBagKnapSack() throws Exception{
		Integer[] w = new Integer[]{1,2,4,5,7,8};
		Integer[] v = new Integer[]{1,3,7,8,10,20};
		Integer c = 8;
		TwoBagKnapSackProblem B = new TwoBagKnapSackProblem(w,v,c);
		Integer sol = B.OPTKnapsack(5,c,c);
		String out = B.printSol(5, c, c);
		System.out.println(out);
	}
	
	public static void LongestPal(){
		LongestPalindrome LP = new LongestPalindrome("racecar");
		System.out.println(LP.solve());
	}
}
