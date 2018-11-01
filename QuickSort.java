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
	 * Hoare划分的实现：
	 * 	Hoare划分的主要思想是：选用数组的第一个元素作为主元，
	 * 		从第二个元素到lessInterval(左闭右开)为止表示小于主元集合；
	 * 		从lessInterval到biggerInterval(左闭右开)表示未排序的元素；
	 * 		从biggerInterval到数组末尾表示大于主元的集合；
	 * 		a[lessInterval]是当前正在处理的元素，
	 * 		如果a[lessInterval]小于主元，则lessInterval++; 
	 * 		如果a[lessInterval]大于主元，则先将biggerInterval++，然后交换a[biggerInterval]和a[lessInterval]位置
	 * @param a
	 * @param l
	 * @param r
	 * @return
	 */
	private int partitionHoare(int[] a, int l, int r) {
		int lessInterval = l+1;
		int biggerInterval = r;
		int key = a[l];
		int temp = 0;
		while(lessInterval<biggerInterval) {
			if(a[lessInterval] < key) lessInterval++;
			else {
				temp = a[lessInterval];
				a[lessInterval] = a[--biggerInterval];
				a[biggerInterval] = temp;
			}
		}
		// 将key于a[lessInterval - 1]交换位置
		temp = a[lessInterval-1];
		a[lessInterval-1] = key;
		a[l] = temp;
		
		return lessInterval-1;
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
