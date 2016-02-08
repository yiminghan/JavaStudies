package DynamicProg;

/*
 * Solves the two-bag knapsack problem giving inputs (w1,v2), (w2,v2) ... (w_n,v_n), W)
 * and returns the maximized sum(v) in two bags each with a max capacity of W.
 * General recurrence of this problem is:
 * OPT(i, w1, w2) =
 * MAX( (v_i + MAX(OPT(i - 1, w1 - w_i), w2), (OPT(i - 1, w1, w2 - w_i)) // if w_i < w1 or w_i < w2
 * 		OPT(i - 1, w1, w2) // Does not use i in any knapsack. 
 */
public class TwoBagKnapSackProblem {
	private Integer[] weight, value;
	private Integer C;
	public Integer[][][] sol;
	
	/*
	 * Initially takes three inputs, two arrays of weight value and a capacity
	 * to construct the problem.
	 * w_i corresponds to v_i, and assume w is sorted.
	 * Assumes all entered values are positive.
	 */
	public TwoBagKnapSackProblem(Integer[] w, Integer[] v, Integer capacity) throws Exception{
		if( w.length != v.length){
			throw new Exception("Input w and v needs to be of the same length!");
		}
		weight = w;
		value = v;
		C = capacity;
		buildSolutionTable();
	}
	
	public void buildSolutionTable(){
		int k = weight.length;
		sol = new Integer[C+1][C+1][k];
	}
	
	/*
	 * Solves the problem and returns the optimal value
	 * This uses a top-down recursive approach.
	 */
	public Integer OPTKnapsack(Integer i, Integer w1, Integer w2){
		if(sol[w1][w2][i] != null){
			return sol[w1][w2][i];
		} else {
			int max = 0;
			if(i == 0){
				if((weight[i] <= w1) || (weight[i] <= w2)) {
					max = value[i];
				} 
				sol[w1][w2][i] = max;
				return max;
			} else {
				if ((weight[i] > w1) && (weight[i] > w2)){
					max = OPTKnapsack(i - 1, w1, w2);
				}
				if(weight[i] <= w1){
					if(max < value[i] + OPTKnapsack(i - 1, w1 - weight[i], w2)){
						max = value[i] + OPTKnapsack(i - 1, w1 - weight[i], w2);
					}
				} 
				if(weight[i] <= w2) {
					if(max < value[i] + OPTKnapsack(i - 1, w1 , w2 - weight[i])){
						max = value[i] + OPTKnapsack(i - 1, w1 , w2 - weight[i]);
					}
				}
				if(max <  OPTKnapsack(i - 1, w1 , w2)){
					max =  OPTKnapsack(i - 1, w1 , w2);
				} 
			sol[w1][w2][i] = max;
			return max;
			}
		}
	}
	
	/*
	 * After computing the solution, use this function to print your solution. 
	 */
	public String printSol(Integer Index, Integer Weight1, Integer Weight2){
		int w1 = Weight1; 
		Integer i = Index;
		int w2 = Weight2;
		Integer solVal = OPTKnapsack(i,w1,w2);
		Integer solValf = solVal;
		String Bag1 = "";
		String Bag2 = "";
		while(i >= 0){
			if(i > 0) {
				if(w1 >= weight[i]){
					if(solVal == value[i] + OPTKnapsack(i - 1,w1-weight[i],w2)){
						Bag1 = Bag1 + i.toString() + " ";
						w1 = w1 - weight[i];
						solVal = OPTKnapsack(i - 1, w1,w2);
					}
				} else if(w2 >= weight[i]){
					if(solVal == value[i] + OPTKnapsack(i - 1,w1,w2-weight[i])){
						Bag2 = Bag2 + i.toString() + " ";
						w2 = w2 - weight[i];
						solVal = OPTKnapsack(i - 1,w1,w2);	
					} 
				}
			} else {
				if(solVal == value[i]){
					Bag1 = Bag1 + i.toString() + " ";
				} else if(solVal == value[i]){
					Bag2 = Bag2 + i.toString() + " ";
				} 
			}
			i--;
		}
		return "Bag1 Contains: " + Bag1 + "\nBag2 Contains: " + Bag2 +"\nTotal Value is: " + solValf.toString();
	}
}
