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
	
	
	public static void main(String[] args) {
		
	}

}
