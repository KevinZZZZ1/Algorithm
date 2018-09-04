import java.util.HashSet;

public class Num03 {
	
	
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
	
 
    
    public static void main(String args[]){
    	//String s = "abcabcbb";
    	//String s = "pwwkew";
    	String s = "dvdf";
    	Num03 n = new Num03();
    	int len = n.lengthOfLongestSubstring(s);
    	System.out.println(len);
    }

}
