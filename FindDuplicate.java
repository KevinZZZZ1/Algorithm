package problems;

public class FindDuplicate {
	/**
	 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
	 * 请找出数组中任意一个重复的数字。要求时间复杂度为O(n),空间复杂度O(1)
	 * @param args
	 */
	
	public static boolean findDuplicate(int[] array) {
		boolean ans = false;
		for(int i=0; i<array.length; i++) {
			
			int key = array[i];

			while(key!=i) {
				if(key==array[key]) return true;
				swap(array, i, key);
				key = array[i];
			}
		}
		return ans;
	}
	
	public static void swap(int[] array, int i, int j) {
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{2, 3, 1, 0, 2, 5};
		System.out.println(findDuplicate(array));
	}

}
