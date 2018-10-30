package lecture17;

public class QuickSort {
	/**
	 * �����㷨
	 * @param a
	 * @param l
	 * @param r
	 * @return
	 */
	private int partition(int[] a, int l, int r) {
		int key = a[r-1]; // key������a�����һ��Ԫ�أ���������Ԫ��
		int temp=0;
		// ����[l,i)��ʾ��keyֵС��Ԫ������
		// ����[i,j)��ʾ��keyֵ���Ԫ������
		// ����[j,r)��ʾδ����Ĳ���
		int i = l; 
		for(int j=l; j<r-1; j++) { // j��ʾ��ǰ�����Ԫ��
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
	 * ���õ�������ҿ�����
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
