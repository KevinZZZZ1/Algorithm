package lectute6;
/**
 * �鲢���򣬷��η��ĵ�������
 * ʱ�临�Ӷ�O(nlogn)
 * @author Kevin
 *
 */
public class MergeSort {

	/**
	 * �鲢��������v���ֳ�������������С�����Ϊ[L,M)��[M,R)
	 * @param v Ҫ�������������
	 * @param L �������߽�
	 * @param R ������ұ߽�
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
		//β������
		if(j==R) { // ��벿�ֵ�����û�д�����
			for(;i<M;i++) a[k++] = v[i];
		}
		else if(i==M) { // �Ұ벿�ֵ�����û�д�����
			for(;j<R;j++) a[k++] = v[j];
		}
		
		for(int n=L,z=0; n<R; n++,z++) //����a�е�Ԫ���Ǵ�0λ�ÿ�ʼ�ģ���v����Ҫ�滻��Ԫ�ص�λ������Ϊ[L,R)
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
