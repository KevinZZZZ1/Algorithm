package leetcode;

public class Num67 {
	
    public static String addBinary(String a, String b) {
        String res = "";
        int carry = 0;
        for(int i=a.length()-1, j=b.length()-1; i>=0||j>=0||carry!=0; i--, j--){
            int a_Int = i>=0? Character.getNumericValue(a.charAt(i)):0;
            int b_Int = j>=0? Character.getNumericValue(b.charAt(j)):0;
            res = (a_Int + b_Int + carry)%2 + res;
            carry = (a_Int + b_Int + carry)/2;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	String a = "11";
    	String b = "1";
    	addBinary(a, b);
    }
}
