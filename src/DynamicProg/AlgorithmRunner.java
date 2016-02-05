package DynamicProg;

import java.util.ArrayList;

/*
 * Uses to run and demonstrate the algorithms built in this package;
 */
public class AlgorithmRunner {

	
	public static void main(String args[]){
		try {
			rodCutter();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
