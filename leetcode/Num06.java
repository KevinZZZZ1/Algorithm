package test;

public class Num06 {
	
    public String convert(String s, int numRows) {
        if(s.length() <= numRows) return s;
        if(numRows<2) return s;
        int mod = numRows*2 - 2;
        char[] cs = new char[s.length()];
        int j = 0;
        
        for(int remain=0; remain<=mod/2; remain++){
        	for(int i=0; i<s.length(); i++){
        		if(i%mod==remain||i%mod==(mod-remain)) {
        			cs[j++] = s.charAt(i);
        		}
        	}
        }
    	String ret = "";
        for(char c: cs){
        	ret += c;
        }
        
        
    	return ret;
    }
	
	public static void main(String[] args){
		Num06 n = new Num06();
		String s = "AB";
		String ans = n.convert(s, 1);
		System.out.println(ans);
	}
}
