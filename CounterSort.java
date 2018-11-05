package lecture19;
/**
 * ���������ʵ�֣����������ǻ��ڱȽϵ�����
 * ��������Ϊһ������AԪ�ظ���Ϊn,���������ÿ��Ԫ��A[i]��[0,k]֮�䣬��n��k���������ʱ����ѡ�ü�������
 * 
 * @author Kevin
 *
 */
public class CounterSort {
	/**
	 * ���������ʵ�֣�
	 * ����b��������¼�ź����Ԫ�أ�����c�Ǽ�¼a�и���Ԫ�صĳ��ִ�����
	 * �����ǣ�
	 * 	1.���Ǳ�������a������������c�м�¼������ÿ��Ԫ�س��ֵĸ���
	 * 	2.�ۼ�����c,ʹ��c[i]��ʾС�ڵ�������i��Ԫ�ظ�����
	 * 	3.�Ӻ���ǰ��������a��������a[i]������Ӧ��λ��b[c[a[i]]-1]�У�����c[a[i]]--
	 * ��k=O(n)��ʱ��ʱ�临�Ӷ�ΪO(n)�������������ȶ���
	 * @param a Ҫ���������
	 * @param k ����a�����ֵ
	 * @return
	 */
	public int[] counterSort(int[] a, int k) {
		int[] b = new int[a.length];
		int[] c = new int[k+1]; // c[i]��ʾ����i���ֵĴ���  c[i]��ʾС�ڵ�������i��Ԫ�ظ���
		
		for(int i=0; i<a.length; i++) {
			c[a[i]] = c[a[i]]+1; // ��¼����a[i]���ֵĴ���
		}
		for(int i=1; i<c.length; i++) {
			c[i] = c[i]+c[i-1]; // ��c[i]�����ۼӣ����c[i]��ʾС�ڵ�������i��Ԫ�ظ���
		}
		for(int i=a.length-1; i>=0; i--) {
			b[c[a[i]]-1] = a[i]; // ���������Ǵ�0��ʼ�ģ���������ط�Ҫ��һ
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
