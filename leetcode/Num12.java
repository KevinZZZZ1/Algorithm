package leetcode;

import java.util.Collections;
import java.util.HashMap;

public class Num12 {
	private enum Roman{
		
	}
	/**
	 * Given an integer, convert it to a roman numeral.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 我们从罗马数字的表示可以看出，其实对于整数的每一位数（0-9）来说，罗马表示法把它分成三个部分：
	 * 	第一部分是一些特别的表示:例如4,9,0
	 * 	第二部分是罗马表示法的基:1,5
	 * 	第三部分是剩余的数字
	 * 
	 * @param num
	 * @return
	 */
    public String intToRoman(int num) {
    	int th,hu,de,un; // 代表各个位
    	String ret = "";
    	th = num/1000;
    	hu = (num%1000)/100;
    	de = (num%100)/10/10;
    	un = num%10;
    	
    	ret = ret +handleThousand(th)+handleHundred(hu)+handleDecade(de)+handleUnit(un);
    	return ret;
    }
    /**
     * 处理个位的数字
     * @param i
     * @return
     */
    private String handleUnit(int i) {
    	String ret = "";
    	if(i==0) return "";
		if(i==4) return "IV";
		if(i==9) return "IX";
		if(i/5>0) { // i属于[5,8]
			ret = ret+"V"+String.join("", Collections.nCopies(i%5, "I"));
		} else {// i属于[1,3]
			ret = ret + String.join("", Collections.nCopies(i%5, "I"));
		}
		return ret;
    }
    /**
     * 处理十位的数字
     * @param i
     * @return
     */
    private String handleDecade(int i) {
    	String ret = "";
    	if(i==0) return "";
		if(i==4) return "XL";
		if(i==9) return "XC";
		if(i/5>0) { // i属于[5,8]
			ret = ret+"L"+String.join("", Collections.nCopies(i%5, "X"));
		}else { // i属于[1,3]
			ret = ret+String.join("", Collections.nCopies(i%5, "X"));
		}
		return ret;
    }
    /**
     * 处理百位的数字
     * @param i
     * @return
     */
    private String handleHundred(int i) {
    	String ret = "";
    	if(i==0) return "";
		if(i==4) return "CD";
		if(i==9) return "CM";
		if(i/5>0) { // i属于[5,8]
			ret = ret+"D"+String.join("", Collections.nCopies(i%5, "C"));
		}else { // i属于[1,3]
			ret = ret+String.join("", Collections.nCopies(i%5, "C"));
		}
		return ret;
    }
    /**
     * 处理千位的数字
     * @param i
     * @return
     */
    private String handleThousand(int i) {
    	String ret = "";
    	if(i==0) return "";
		ret = ret+String.join("", Collections.nCopies(i%5, "M"));
		return ret;
    }
    
    /**
     * 这是leetcode上的大神写的，由于输入是有限的，他直接把各个位数的可能出现的情况列出来，我还写了那么多的if判断，简直了，amazing!!!
     * @param num
     * @return
     */
//    public String intToRoman(int num) {
//        String M[] = {"", "M", "MM", "MMM"};
//        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
//    }
    
	
	public static void main(String[] args) {
		Num12 n = new Num12();
		System.out.println(n.intToRoman(500));
		
		
		
	}
	
}
