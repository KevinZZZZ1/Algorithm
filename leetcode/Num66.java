package leetcode;

public class Num66 {

	
    public static int[] plusOne(int[] digits) {
    	int countNine = 0; // ����digits������9�ĸ���
    	int[] res;
    	if(digits[digits.length-1] == 9) { // ���digits�����һ��Ԫ����9���������ܻ����λ����һ�����
	        for(int i=digits.length-1; i>=0; i--){
	            if(digits[i]==9) countNine++;
	            else break;
	        }
    	}else { 
    		digits[digits.length-1]++;
    		return digits;
    	}
    	
    	if(countNine == digits.length) { // digitsȫΪ9
    		res = new int[digits.length+1];
    		res[0]=1;
    	}else {
    		res = digits;
    		int i=res.length-1;
    		for(; countNine>0; i--) {
    			res[i] = 0;
    			countNine--;
    		}
    		res[i]++;
    	}
    	
        return res;
    }
	
	public static void main(String[] args) {
		int[] test = new int[] {9,8,9,9,9};
		plusOne(test);
	}

}
