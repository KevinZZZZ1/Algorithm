package leetcode;

public class Num231 {
	/**
	 * �ж�һ�����Ƿ�Ϊ2����
	 * @param n
	 * @return
	 */
    public static boolean isPowerOfTwo(int n) {
        if(n<=0) 
            return false; // �������С�ڵ���0,����false
        return ((n&(n-1))==0); // ��n��n-1����������������2���ݴ�����0
    }
	
	
	public static void main(String[] args) {
		int n = 16;
		boolean powerOfTwo = isPowerOfTwo(n);
		if(powerOfTwo) System.out.println("yes, it is");
		else System.out.println("no, it isn't");
	}

}
