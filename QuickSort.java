package lecture17;

public class QuickSort {
	/**
	 * 划分算法
	 * @param a
	 * @param l
	 * @param r
	 * @return
	 */
	private int partition(int[] a, int l, int r) {
		int key = a[r-1]; // key是数组a的最后一个元素，用来做主元。
		int temp=0;
		// 区间[l,i)表示比key值小的元素区间
		// 区间[i,j)表示比key值大的元素区间
		// 区间[j,r)表示未排序的部分
		int i = l; 
		for(int j=l; j<r-1; j++) { // j表示当前处理的元素
			if(a[j]<=key) {
				temp = a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
			}
		}
		temp = a[i];
		a[i] = a[r-1];
		a[r-1] = temp;
		
		return i;
	}
	/**
	 * 采用的是左闭右开区间
	 * @param a
	 * @param l
	 * @param r
	 */
	private void quicksort(int[] a, int l, int r) {
		int i = 0;
		if(l>=r) return;
		
		i = partition(a, l, r);
		quicksort(a, l, i);
		quicksort(a, i+1, r);

		
		
	}
	public void quicksort(int[] a) {
		quicksort(a, 0, a.length); 
	}
	
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = new int[] {2,8,7,1,3,5,6,4};
		qs.quicksort(a);
		for(int x:a)
			System.out.println(x+" ");
	}
	
	
	
}
