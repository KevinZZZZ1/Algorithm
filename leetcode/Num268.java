package leetcode;

public class Num268 {
	/**
	 * �������ܼ򵥣�[0...n]������Ԫ��֮������֪�ģ���Ϊ(nums.length+1)*nums.length/2,��nums������Ԫ��֮����(nums.length+1)*nums.length/2֮�Ϊ����
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
