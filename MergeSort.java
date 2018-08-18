package lectute6;
/**
 * 归并排序，分治法的典型例子
 * 时间复杂度O(nlogn)
 * @author Kevin
 *
 */
public class MergeSort {

	/**
	 * 归并排序：数组v被分成两个有序的序列。区间为[L,M)和[M,R)
	 * @param v 要进行排序的数组
	 * @param L 数组的左边界
	 * @param R 数组的右边界
	 */
	public void mergesort(int[] v, int L, int R) {
		if(L<R&&(R-L)!=1) {
			int M = L + (R-L)/2;
			mergesort(v, L, M);
			mergesort(v, M, R);
			merge(v, L, M, R);
		}
	}
	
	public void merge(int[] v, int L, int M, int R) {
		int[] a = new int[v.length];
		int k = 0;
		int i=L,j=M;
		while(i<M&&j<R) {
			if(v[i]<v[j]) a[k++] = v[i++];
			else a[k++] = v[j++];
		}
		//尾部处理
		if(j==R) { // 左半部分的序列没有处理完
			for(;i<M;i++) a[k++] = v[i];
		}
		else if(i==M) { // 右半部分的序列没有处理完
			for(;j<R;j++) a[k++] = v[j];
		}
		
		for(int n=L,z=0; n<R; n++,z++) //数组a中的元素是从0位置开始的，而v中需要替换的元素的位置区间为[L,R)
			v[n] = a[z];
	}
	
	
	
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] test = new int[] {5,2,4,7,1,3,2,6,10,3,9,11};
		int[] test1 = new int[] {2,4,6,8,1,3,5,7};
		ms.merge(test1, 0, 4, test1.length);
		ms.mergesort(test, 0, test.length);
		for(int i : test)
			System.out.println(i);
	}

}
