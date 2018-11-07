package leetcode;

public class Num66 {

	
    public static int[] plusOne(int[] digits) {
    	int countNine = 0; // 计算digits中连续9的个数
    	int[] res;
    	if(digits[digits.length-1] == 9) { // 如果digits中最后一个元素是9，这样可能会出现位数加一的情况
	        for(int i=digits.length-1; i>=0; i--){
	            if(digits[i]==9) countNine++;
	            else break;
	        }
    	}else { 
    		digits[digits.length-1]++;
    		return digits;
    	}
    	
    	if(countNine == digits.length) { // digits全为9
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
