package lecture7;

public class BinarySearch {

	
	/**
	 * 实现的是二分查找，区间设置是左闭右闭[L,R]，即为[0,n-1]
	 * 时间复杂度为：O(logn)
	 * @param a 要进行查找的数组,要求是有序的
	 * @param key 要查找的关键字
	 * @return 关键字在数组中的位置
	 */
	public int binarySearch_one(int[] a, int key) {
		int l = 0;
		int r = a.length-1;
		while(l<=r) {
			int m = l + (r-l)/2; // 计算中间位置的索引
			if(a[m]<key) l = m+1; // 关键字在a[m]的右边
			else if(a[m]>key) r = m-1; // 关键字在a[m]的左边
			else return m; // 找到关键字，返回其在数组中的位置
		}
		return -1; // 没有找到
	}
	
	
	/**
	 * 实现的是二分查找，区间设置是左闭右开[L,R)，即为[0,n)
	 * 时间复杂度为：O(logn)
	 * @param a 要进行查找的数组，要求是有序的
	 * @param key 要查找的关键字
	 * @return 关键字在数组中的位置
	 */
	public int binarySearch_two(int[] a, int key) {
		int l = 0;
		int r = a.length;
		while(l<r) {
			int m = l + (r-l)/2; // 计算中间位置的索引
			if(a[m]<key) l = m; // 关键字在a[m]的右边，由于是左闭右开区间设定，所以不需要加1
			else if(a[m]>key) r = m + 1; // 关键字在a[m]的左边
			else return m; // 找到关键字，返回其在数组中的位置
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		int[] test = new int[] {1,2,4,6,7,9,10,14,16,17,19};
		
		System.out.println(bs.binarySearch_one(test, 17));
		System.out.println(bs.binarySearch_two(test, 17));
	}
	
}
