package leetcode;

public class Num65 {
	
    public static boolean isNumber(String s) {
        
        //[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
        
    	
    	//去掉前后的空格
        s = s.trim();
        
        boolean pointSeen = false; // 表示此前的字符已经出现过小数点
        boolean eSeen = false; // 表示此前的字符已经出现过e
        boolean numberSeen = false; // 表示此前的字符已经出现过数字
        boolean numberAfterE = true; // 表示e之后是否有数字
        
        for(int i=0; i<s.length(); i++) {// 遍历字符串的每个字符，s.charAt(i)
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') { // 出现了数字
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) { // 如果该小数点在e后面或者以及出现过小数点的情况
                    return false; // 那肯定不是Valid Number
                }
                pointSeen = true; // 出现过小数点
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) { // 在该e之前出现过e或者之前没有数字出现
                    return false;
                }
                numberAfterE = false; //
                eSeen = true; // e出现
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') { // "-"和"+"只能出现在最前和e的后面
                    return false;
                }
            } else {
                return false; // 出现其他字符
            }
        }

        return numberSeen && numberAfterE;
        
        
    }
	
	
	public static void main(String[] args) {
		
		String test = " 99e2.5 ";
		
		boolean isNumber = isNumber(test);
		
	}

}
