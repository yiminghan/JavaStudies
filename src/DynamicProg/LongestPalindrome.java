package DynamicProg;

/*
 * A palindrome is a non-empty string that reads the same forwards and backwards.
 * e.g.  civic, racecar, wow, p;
 * Given a input string s, this finds the longest palindrome in s.
 * For example, an input of "character" returns "carac"
 */
public class LongestPalindrome {
	
	private String input;
	
	public LongestPalindrome(String i){
		input = i;
	}
	
	/*
	 * returns the longest Palindrome.
	 */
	public String solve(){
		return OPT(0, input.length() - 1);
	}
	
	/*
	 * Solves using recursion.  
	 * Please make sure to check Capitalized letters, as they well not be matched
	 */
	private String OPT(int h, int t){
		if(h == t){
			return "";
		} else {
			String s = input;
			String max = "";
			String head = s.substring(h,h+1);
			if(s.substring(h,t + 1).lastIndexOf(head) == 0){
				max = head;
				if(max.length() < OPT(h+1, t).length()){
					max = OPT(h+1, t);
				}
			} else {
				max = head + OPT(h + 1, s.lastIndexOf(head)) + head;
				if(max.length() < OPT(h+1, t).length()){
					max = OPT(h+1, t);
				}
			} 
			return max;
		}
	}
	
}
