package lecture19;
/**
 * 计数排序的实现：计数排序不是基于比较的排序，
 * 假设输入为一个数组A元素个数为n,其中数组的每个元素A[i]在[0,k]之间，当n和k数量级差不多时可以选用计数排序
 * 
 * @author Kevin
 *
 */
public class CounterSort {
	/**
	 * 计数排序的实现：
	 * 数组b是用来纪录排好序的元素，数组c是纪录a中各个元素的出现次数；
	 * 步骤是：
	 * 	1.先是遍历数组a，并且在数组c中纪录下其中每个元素出现的个数
	 * 	2.累加数组c,使得c[i]表示小于等于数字i的元素个数；
	 * 	3.从后向前遍历数组a，将数字a[i]放入相应的位置b[c[a[i]]-1]中，并将c[a[i]]--
	 * 在k=O(n)的时候，时间复杂度为O(n)，计数排序是稳定的
	 * @param a 要排序的数组
	 * @param k 数组a中最大值
	 * @return
	 */
	public int[] counterSort(int[] a, int k) {
		int[] b = new int[a.length];
		int[] c = new int[k+1]; // c[i]表示数字i出现的次数  c[i]表示小于等于数字i的元素个数
		
		for(int i=0; i<a.length; i++) {
			c[a[i]] = c[a[i]]+1; // 纪录数字a[i]出现的次数
		}
		for(int i=1; i<c.length; i++) {
			c[i] = c[i]+c[i-1]; // 将c[i]进行累加，最后c[i]表示小于等于数字i的元素个数
		}
		for(int i=a.length-1; i>=0; i--) {
			b[c[a[i]]-1] = a[i]; // 由于数组是从0开始的，所以这个地方要减一
			c[a[i]] = c[a[i]] - 1;
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		CounterSort cs = new CounterSort();
		int[] a = new int[] {2,5,3,0,2,3,0,3};
		int[] counterSort = cs.counterSort(a, 5);
		for(int x:counterSort)
			System.out.println(x);
		
	}

}
