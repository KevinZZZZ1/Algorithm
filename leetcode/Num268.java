package leetcode;

public class Num268 {
	/**
	 * 这个问题很简单，[0...n]的所有元素之和是已知的，即为(nums.length+1)*nums.length/2,而nums数组中元素之和与(nums.length+1)*nums.length/2之差即为所求
	 * @param nums
	 * @return
	 */
	 public int missingNumber(int[] nums) {
	 	int sum=(nums.length+1)*nums.length/2;
		int act_sum=0;
		for(int i=0; i<nums.length; i++){
		    act_sum+=nums[i];
		}

		return sum-act_sum;
	 }
	
	    
	/**
	 * 这个方法利用的是异或操作来完成对缺失值的寻找：
	 *  if we initialize an integer to n and XOR it with every index and value, we will be left with the missing number
	 *  例如：
	 *  	数组a: 0 1 3 4
	 *  	index: 0 1 2 3
	 *  	缺失值missing = 4^(0^0)^(1^1)^(3^2)^(4^3)
	 *  				  = 4^1^7
	 *  				  = 5^7
	 *  				  = 2
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
    		int missing = nums.length;
    		for (int i = 0; i < nums.length; i++) {
        		missing ^= i ^ nums[i];
    		}
    		return missing;
	}
	
	
	
	
	public static void main(String[] args) {
		
	}

}
