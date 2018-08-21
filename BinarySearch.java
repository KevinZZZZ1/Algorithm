package lecture7;

public class BinarySearch {

	
	/**
	 * ʵ�ֵ��Ƕ��ֲ��ң���������������ұ�[L,R]����Ϊ[0,n-1]
	 * ʱ�临�Ӷ�Ϊ��O(logn)
	 * @param a Ҫ���в��ҵ�����,Ҫ���������
	 * @param key Ҫ���ҵĹؼ���
	 * @return �ؼ����������е�λ��
	 */
	public int binarySearch_one(int[] a, int key) {
		int l = 0;
		int r = a.length-1;
		while(l<=r) {
			int m = l + (r-l)/2; // �����м�λ�õ�����
			if(a[m]<key) l = m+1; // �ؼ�����a[m]���ұ�
			else if(a[m]>key) r = m-1; // �ؼ�����a[m]�����
			else return m; // �ҵ��ؼ��֣��������������е�λ��
		}
		return -1; // û���ҵ�
	}
	
	
	/**
	 * ʵ�ֵ��Ƕ��ֲ��ң���������������ҿ�[L,R)����Ϊ[0,n)
	 * ʱ�临�Ӷ�Ϊ��O(logn)
	 * @param a Ҫ���в��ҵ����飬Ҫ���������
	 * @param key Ҫ���ҵĹؼ���
	 * @return �ؼ����������е�λ��
	 */
	public int binarySearch_two(int[] a, int key) {
		int l = 0;
		int r = a.length;
		while(l<r) {
			int m = l + (r-l)/2; // �����м�λ�õ�����
			if(a[m]<key) l = m; // �ؼ�����a[m]���ұߣ�����������ҿ������趨�����Բ���Ҫ��1
			else if(a[m]>key) r = m + 1; // �ؼ�����a[m]�����
			else return m; // �ҵ��ؼ��֣��������������е�λ��
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
