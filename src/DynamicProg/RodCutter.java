package DynamicProg;

import java.util.ArrayList;

/*
 * Given a table of lengths i = 1, 2, 3, ... , n and the corresponding value V_1, V_2, V_3, ... , V_n and the constraint c < n
 * Solves the rod cutting problem of cutting the rod of length c into smaller rods R_1, R_2, R_3 
 * such that the sum of the values of the smaller rods are maximized. 
 * 
 * This solves the problem in a bottom-up dynamic programming approach. Assumes that all values are integers. 
 * I used ArrayList, but a simple array will also work, I just felt like using ArrayList... 
 */
public class RodCutter {
	
	private ArrayList<Integer> result;
	private ArrayList<Integer> values;
	private ArrayList<Integer> size;
	
	
	/*
	 * Takes in two arguments: an array list of values, where the ith index corresponds with a length i.
	 * 							where 0th index has a value of 0 ( default)
	 * 							an integer constraint on the total length. 
	 * Stories the resulting computation in results.
	 */
	public Integer cutRod(ArrayList<Integer> v, Integer c) throws Exception{
		result = new ArrayList<Integer>();
		size = new ArrayList<Integer>(c + 1);
		result.add(0,0);
		size.add(0,0);
		this.values = v;
		if (c > values.size()) {
			throw new Exception("Input: does not have a value for the rod of length c");
		}
		return OPTRod(c);
	}
	
	/*
	 * Surrounds functions with try / catch to avoid exceptions
	 * writes the opt values in results
	 */
	private Integer OPTRod(Integer c) {
		int max = values.get(c);
		int temp, length = c;
		if( c == 0){
			return 0;
		} else {
			 	try {
			 			if(result.get(c) != null){
			 				return result.get(c);
			 			}
			 	} catch (IndexOutOfBoundsException e){
			 		
			 	}
				for (int j = 1; j < c; j ++){
					temp = values.get(j) + OPTRod(c - j);
					if (max < temp){
						max = temp;
						length = j;
					}
				}
				try {
		 			if(result.get(c) == null){
		 				result.add(c, max);
		 			}
				} catch (IndexOutOfBoundsException e){
					result.add(c, max);
				}
				try {
		 			if(size.get(c) == null){
		 				result.add(c, length);
		 			}
				} catch (IndexOutOfBoundsException e){
					size.add(c, length);
				}
				return max;
		}
	}
	
	/*
	 * Instead of the optimal value, returns how to get the value by 
	 * showing length of the cuts.
	 */
	public String printCut(ArrayList<Integer> v, Integer c) throws Exception{
		result = new ArrayList<Integer>(c + 1);
		result.add(0,0);
		this.values = v;
		if (c > values.size()) {
			throw new Exception("Input: does not have a value for the rod of length c");
		}
		Integer x = OPTRod(c);
		String out = "Opt Value is " + x.toString() + " \nHow to Cut: ";
		int i = c;
		while(i > 0) {
			out = out + size.get(i).toString() + " ";
			i = i - size.get(i);
		}
		return out;
	}
	
	/*
	 * Output the result for potential usage
	 */
	public ArrayList<Integer> getResult(){
		return result;
	}

}
