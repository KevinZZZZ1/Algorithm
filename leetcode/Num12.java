package leetcode;

import java.util.Collections;
import java.util.HashMap;

public class Num12 {
	private enum Roman{
		
	}
	/**
	 * Given an integer, convert it to a roman numeral.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * ���Ǵ��������ֵı�ʾ���Կ�������ʵ����������ÿһλ����0-9����˵�������ʾ�������ֳ��������֣�
	 * 	��һ������һЩ�ر�ı�ʾ:����4,9,0
	 * 	�ڶ������������ʾ���Ļ�:1,5
	 * 	����������ʣ�������
	 * 
	 * @param num
	 * @return
	 */
    public String intToRoman(int num) {
    	int th,hu,de,un; // �������λ
    	String ret = "";
    	th = num/1000;
    	hu = (num%1000)/100;
    	de = (num%100)/10/10;
    	un = num%10;
    	
    	ret = ret +handleThousand(th)+handleHundred(hu)+handleDecade(de)+handleUnit(un);
    	return ret;
    }
    /**
     * �����λ������
     * @param i
     * @return
     */
    private String handleUnit(int i) {
    	String ret = "";
    	if(i==0) return "";
		if(i==4) return "IV";
		if(i==9) return "IX";
		if(i/5>0) { // i����[5,8]
			ret = ret+"V"+String.join("", Collections.nCopies(i%5, "I"));
		} else {// i����[1,3]
			ret = ret + String.join("", Collections.nCopies(i%5, "I"));
		}
		return ret;
    }
    /**
     * ����ʮλ������
     * @param i
     * @return
     */
    private String handleDecade(int i) {
    	String ret = "";
    	if(i==0) return "";
		if(i==4) return "XL";
		if(i==9) return "XC";
		if(i/5>0) { // i����[5,8]
			ret = ret+"L"+String.join("", Collections.nCopies(i%5, "X"));
		}else { // i����[1,3]
			ret = ret+String.join("", Collections.nCopies(i%5, "X"));
		}
		return ret;
    }
    /**
     * �����λ������
     * @param i
     * @return
     */
    private String handleHundred(int i) {
    	String ret = "";
    	if(i==0) return "";
		if(i==4) return "CD";
		if(i==9) return "CM";
		if(i/5>0) { // i����[5,8]
			ret = ret+"D"+String.join("", Collections.nCopies(i%5, "C"));
		}else { // i����[1,3]
			ret = ret+String.join("", Collections.nCopies(i%5, "C"));
		}
		return ret;
    }
    /**
     * ����ǧλ������
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
     * ����leetcode�ϵĴ���д�ģ��������������޵ģ���ֱ�ӰѸ���λ���Ŀ��ܳ��ֵ�����г������һ�д����ô���if�жϣ���ֱ�ˣ�amazing!!!
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
