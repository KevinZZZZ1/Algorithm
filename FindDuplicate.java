package problems;

public class FindDuplicate {
	/**
	 * ��һ������Ϊ n ����������������ֶ��� 0 �� n-1 �ķ�Χ�ڡ�
	 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ģ�Ҳ��֪��ÿ�������ظ����Ρ�
	 * ���ҳ�����������һ���ظ������֡�Ҫ��ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�O(1)
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
