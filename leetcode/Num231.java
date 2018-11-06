package leetcode;

public class Num231 {
	/**
	 * 判断一个数是否为2的幂
	 * @param n
	 * @return
	 */
    public static boolean isPowerOfTwo(int n) {
        if(n<=0) 
            return false; // 如果输入小于等于0,返回false
        return ((n&(n-1))==0); // 对n和n-1进行与操作，如果是2的幂答案则是0
    }
	
	
	public static void main(String[] args) {
		int n = 16;
		boolean powerOfTwo = isPowerOfTwo(n);
		if(powerOfTwo) System.out.println("yes, it is");
		else System.out.println("no, it isn't");
	}

}
